package main.java.company;

import java.io.*;

public class CopyDirectory {
    private final String originDirectoryPath;
    private final String targetPath;
    private final File originDirectory;
    private final File targetDirectory;

    public CopyDirectory(String originDirectoryPath, String targetPath) {
        this.originDirectoryPath = originDirectoryPath;
        this.targetPath = targetPath;
        this.originDirectory = new File(this.originDirectoryPath);
        this.targetDirectory = this.generateCopiedDirectoryPath();
    }

    private File generateCopiedDirectoryPath() {
        String originDirectoryName = this.originDirectory.getName();
        File targetDirectory = new File(this.targetPath, originDirectoryName);
        if (targetDirectory.exists()) {
            targetDirectory = new File(this.targetPath, "copy_of_".concat(originDirectoryName));
        }
        return targetDirectory;
    }

    public boolean createDirectory() {
        return this.targetDirectory.mkdir();
    }

    public boolean copyFiles() {
        File[] originFiles = this.originDirectory.listFiles();
        if (originFiles != null) {
            for (File originFile : originFiles) {
                String content = this.readFile(originFile);
                File copiedFile = new File(this.targetDirectory, originFile.getName());
                this.writeFile(copiedFile, content);
            }
        }
        return true;
    }

    private String readFile(File file) {
        try (FileReader reader = new FileReader(file)) {
            int temp;
            String content = "";
            while ((temp = reader.read()) != -1) {
                content += (char)temp;
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeFile(File file, String content) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
