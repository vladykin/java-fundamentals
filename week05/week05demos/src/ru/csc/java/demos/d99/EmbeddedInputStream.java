package ru.csc.java.demos.d99;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class EmbeddedInputStream extends FilterInputStream {

    private static final int EOF = -1;
    private static final int BUFFER_SIZE = EmbeddedOutputStream.BUFFER_SIZE;

    private final byte[] buffer;
    private int bufferPosition;
    private int bufferLimit;
    private boolean streamDataFinished;

    public EmbeddedInputStream(InputStream in) throws IOException {
        super(Objects.requireNonNull(in, "in"));
        this.buffer = new byte[BUFFER_SIZE];
        this.bufferPosition = 0;
        this.bufferLimit = 0;
    }

    @Override
    public int read() throws IOException {
        byte[] bytes = new byte[1];
        int bytesRead = read(bytes);
        return bytesRead == 1 ? bytes[0] & 0xFF : EOF;
    }

    @Override
    public int read(byte[] bytes) throws IOException {
        return read(bytes, 0, bytes.length);
    }

    @Override
    public int read(byte[] bytes, int offset, int length) throws IOException {
        int bytesRead = 0;
        while (0 < length) {
            if (isBufferEmpty() && readBufferFromUnderlyingStream() <= 0) {
                break;
            }
            int bytesGotFromBuffer = getBytesFromBuffer(bytes, offset, length);
            bytesRead += bytesGotFromBuffer;
            offset += bytesGotFromBuffer;
            length -= bytesGotFromBuffer;
        }
        return bytesRead;
    }

    @Override
    public long skip(long bytesToSkip) throws IOException {
        for (long i = 0; i < bytesToSkip; ++i) {
            if (read() == EOF) {
                return i;
            }
        }
        return bytesToSkip;
    }

    @Override
    public int available() throws IOException {
        return bufferLimit - bufferPosition;
    }

    @Override
    public void close() throws IOException {
        while (!streamDataFinished) {
            readBufferFromUnderlyingStream();
        }
    }



    @Override
    public synchronized void mark(int readlimit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public synchronized void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean markSupported() {
        return false;
    }


    private boolean isBufferEmpty() {
        return bufferPosition == bufferLimit;
    }

    private int getBytesFromBuffer(byte[] bytes, int offset, int length) {
        int bytesAvailable = bufferLimit - bufferPosition;
        int bytesToRead = Math.min(length, bytesAvailable);
        System.arraycopy(buffer, bufferPosition, bytes, offset, bytesToRead);
        bufferPosition += bytesToRead;
        return bytesToRead;
    }

    private int readBufferFromUnderlyingStream() throws IOException {
        if (streamDataFinished) {
            return EOF;
        }

        int chunkSizeHighByte = in.read();
        int chunkSizeLowByte = in.read();
        if (chunkSizeHighByte == EOF || chunkSizeLowByte == EOF
                || chunkSizeHighByte == 0 && chunkSizeLowByte == 0) {
            streamDataFinished = true;
            return EOF;
        }

        int chunkSize = ((chunkSizeHighByte & 0xFF) << 8) | (chunkSizeLowByte & 0xFF);
        int bytesRead = readFullyFromUnderlyingStream(buffer, 0, chunkSize);
        if (bytesRead != chunkSize) {
            throw new IOException("Expected " + chunkSize + " bytes, but got " + bytesRead);
        }

        bufferPosition = 0;
        bufferLimit = chunkSize;

        return chunkSize;
    }

    private int readFullyFromUnderlyingStream(byte[] bytes, int offset, int length) throws IOException {
        int totalBytesRead = 0;
        while (0 < length) {
            int bytesRead = in.read(bytes, offset, length);
            if (bytesRead <= 0) {
                break;
            }
            totalBytesRead += bytesRead;
            offset += bytesRead;
            length -= bytesRead;
        }
        return totalBytesRead;
    }
}
