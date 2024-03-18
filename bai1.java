package bai1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {
    public static void createFile(String filename) throws IOException {
        File file = new File(filename);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    public static void writeFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
        System.out.println("Successfully wrote to the file.");
    }

    public static String readFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        return Files.readString(path);
    }

    public static String getFilePath(String filename) {
        File file = new File(filename);
        return file.getAbsolutePath();
    }

    public static void deleteFile(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void createDirectory(String directoryName) {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created: " + directory.getName());
            } else {
                System.out.println("Failed to create the directory.");
            }
        } else {
            System.out.println("Directory already exists.");
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "test.txt";
        String content = "Hello, world!";
        createFile(filename);
        writeFile(filename, content);
        System.out.println("Content of the file:");
        System.out.println(readFile(filename));
        System.out.println("File path: " + getFilePath(filename));
        deleteFile(filename);

        String directoryName = "testDir";
        createDirectory(directoryName);
    }
}

