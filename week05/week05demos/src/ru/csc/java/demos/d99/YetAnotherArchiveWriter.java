package ru.csc.java.demos.d99;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.GZIPOutputStream;

public class YetAnotherArchiveWriter implements AutoCloseable {

    private final DataOutputStream outputStream;

    public YetAnotherArchiveWriter(Path outputFile) throws IOException {
        this.outputStream = new DataOutputStream(Files.newOutputStream(
                outputFile,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING));
    }

    public void addDirectoryRecursively(Path directory) throws IOException {
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                addFile(file, directory, attrs);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private void addFile(Path file, Path baseDirectory, BasicFileAttributes fileAttributes) throws IOException {
        outputStream.writeUTF(baseDirectory.relativize(file).toString());
        outputStream.writeLong(fileAttributes.creationTime().toMillis());
        outputStream.writeLong(fileAttributes.lastModifiedTime().toMillis());
        try (OutputStream contentStream = new GZIPOutputStream(new EmbeddedOutputStream(outputStream))) {
            Files.copy(file, contentStream);
        }
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
