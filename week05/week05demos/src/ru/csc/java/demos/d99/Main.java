package ru.csc.java.demos.d99;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            printUsageAndExit();
        }

        String cmd = args[0];
        Path archive = Paths.get(args[1]);
        Path directory = Paths.get(args[2]);

        switch (cmd) {
            case "pack":
                pack(archive, directory);
                break;

            case "unpack":
                unpack(archive, directory);
                break;

            default:
                printUsageAndExit();
                break;
        }
    }


    private static void printUsageAndExit() {
        System.err.println("Usage: yar <pack|unpack> <archive> <dir>");
        System.exit(1);
    }

    private static void pack(Path archive, Path directory) throws IOException {
        try (YetAnotherArchiveWriter archiveWriter = new YetAnotherArchiveWriter(archive)) {
            archiveWriter.addDirectoryRecursively(directory);
        }
    }

    private static void unpack(Path archive, Path directory) throws IOException {
        try (YetAnotherArchiveReader archiveReader = new YetAnotherArchiveReader(archive)) {
            archiveReader.extractToDirectory(directory);
        }
    }
}
