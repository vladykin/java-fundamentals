package ru.csc.java.demos.d99;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.zip.GZIPInputStream;

public class YetAnotherArchiveReader implements AutoCloseable {

    private final DataInputStream inputStream;
    private ArchiveEntry currentEntry;

    public YetAnotherArchiveReader(Path file) throws IOException {
        inputStream = new DataInputStream(Files.newInputStream(file));
        currentEntry = null;
    }

    public void extractToDirectory(Path directory) throws IOException {
        for (ArchiveEntry entry = nextEntry(); entry != null;  entry = nextEntry()) {
            Path targetFile = directory.resolve(entry.getName());
            extractFile(targetFile, entry);
        }
    }

    private void extractFile(Path targetFile, ArchiveEntry entry) throws IOException {
        ensureParentDirectoryExists(targetFile);
        Files.copy(entry.getInputStream(), targetFile, StandardCopyOption.REPLACE_EXISTING);
        BasicFileAttributeView fileAttributes = Files.getFileAttributeView(targetFile, BasicFileAttributeView.class);
        fileAttributes.setTimes(
                FileTime.fromMillis(entry.getLastModifiedTime()),
                null,
                FileTime.fromMillis(entry.getCreationTime()));
    }

    private void ensureParentDirectoryExists(Path targetFile) throws IOException {
        Path parentDirectory = targetFile.getParent();
        Files.createDirectories(parentDirectory);
    }

    private ArchiveEntry nextEntry() throws IOException {
        if (currentEntry != null) {
            currentEntry.getInputStream().close();
        }

        ArchiveEntry nextEntry = readEntry();
        if (nextEntry == null) {
            return null;
        }

        currentEntry = nextEntry;
        return currentEntry;
    }

    private ArchiveEntry readEntry() throws IOException {
        try {
            ArchiveEntry entry = new ArchiveEntry();
            entry.setName(inputStream.readUTF());
            entry.setCreationTime(inputStream.readLong());
            entry.setLastModifiedTime(inputStream.readLong());
            entry.setInputStream(new GZIPInputStream(new EmbeddedInputStream(inputStream)));
            return entry;
        } catch (EOFException e) {
            return null;
        }
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
