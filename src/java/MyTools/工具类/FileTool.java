package MyTools.工具类;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTool {
    public static List<File> enumAllSubFiles(String topDir) {
        List<File> result = new ArrayList<>();
        File dir = new File(topDir);
        final File[] files = dir.listFiles();
        if (files == null) return result;
        for (File file : files) {
            if (file.isDirectory()) {
                result.addAll(enumAllSubFiles(file.getPath()));
            } else if(file.isFile()){
                result.add(file);
            }
        }
        return result;
    }
}
