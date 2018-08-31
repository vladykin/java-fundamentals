package ru.csc.java.demos.d99;

import java.io.InputStream;

public class ArchiveEntry {

    private String name;
    private long creationTime;
    private long lastModifiedTime;
    private InputStream inputStream;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(long lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}
