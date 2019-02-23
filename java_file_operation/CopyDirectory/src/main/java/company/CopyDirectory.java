package main.java.company;

import java.io.File;

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

    public boolean createCopiedDirectory() {
        return this.targetDirectory.mkdir();
    }


}
