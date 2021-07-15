package tyrael.filetool;

import wang.tyrael.file.FileUtil;

import java.io.File;
import java.io.FilenameFilter;

public class ChangeRNToNUtil {
    public static void changeDirectory(String folderPath, FilenameFilter filenameFilter) {
        File file = new File(folderPath);
        File[] files = file.listFiles();
        if (files == null) {
            System.out.println("null child:" + folderPath);
            return;
        }
        for (File fileItem : files) {
            if (fileItem.isDirectory()) {
                changeDirectory(fileItem.getAbsolutePath(), filenameFilter);
            } else {
                if (filenameFilter != null) {
                    if (!filenameFilter.accept(file, fileItem.getName())) {
                        continue;
                    }
                }

                changeFile(fileItem.getAbsolutePath());
            }
        }
    }

    public static void changeFile(String filePath) {
        System.out.println("changeFile: " + filePath);
        String content = FileUtil.readString(filePath);
        String newContent = content.replace("\r\n", "\n");
        FileUtil.write(filePath, newContent);
    }
}
