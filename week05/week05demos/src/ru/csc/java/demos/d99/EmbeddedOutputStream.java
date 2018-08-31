package ru.csc.java.demos.d99;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

public class EmbeddedOutputStream extends FilterOutputStream {

    static final int BUFFER_SIZE = 65535; // max unsigned integer representable by 2 bytes

    private final byte[] buffer;
    private int bufferPosition;
    private boolean closed;

    public EmbeddedOutputStream(OutputStream out) {
        super(Objects.requireNonNull(out, "out is null"));
        this.buffer = new byte[BUFFER_SIZE];
        this.bufferPosition = 0;
    }

    @Override
    public void write(int b) throws IOException {
        write(new byte[]{(byte) b});
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        write(bytes, 0, bytes.length);
    }

    @Override
    public void write(byte[] bytes, int offset, int length) throws IOException {
        while (0 < length) {
            int bytesAddedToBuffer = addBytesToBuffer(bytes, offset, length);
            if (isBufferFull()) {
                writeBufferToUnderlyingStream();
            }
            offset += bytesAddedToBuffer;
            length -= bytesAddedToBuffer;
        }
    }

    @Override
    public void flush() throws IOException {
        if (!isBufferEmpty()) {
            writeBufferToUnderlyingStream();
        }
    }

    @Override
    public void close() throws IOException {
        if (closed) {
            return;
        }

        flush();
        writeEndOfStreamMarker();
        closed = true;
    }


    private int addBytesToBuffer(byte[] bytes, int offset, int length) {
        int remainingBytesInBuffer = buffer.length - bufferPosition;
        int bytesToWrite = Math.min(length, remainingBytesInBuffer);
        System.arraycopy(bytes, offset, buffer, bufferPosition, bytesToWrite);
        bufferPosition += bytesToWrite;
        return bytesToWrite;
    }

    private boolean isBufferFull() {
        return bufferPosition == buffer.length;
    }

    private boolean isBufferEmpty() {
        return bufferPosition == 0;
    }

    private void writeBufferToUnderlyingStream() throws IOException {
        out.write((bufferPosition >> 8) & 0xFF);
        out.write(bufferPosition & 0xFF);
        out.write(buffer, 0, bufferPosition);
        bufferPosition = 0;
    }

    private void writeEndOfStreamMarker() throws IOException {
        out.write(0);
        out.write(0);
    }
}
