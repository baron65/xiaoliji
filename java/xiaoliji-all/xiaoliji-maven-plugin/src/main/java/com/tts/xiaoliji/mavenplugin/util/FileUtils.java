package com.tts.xiaoliji.mavenplugin.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

public class FileUtils {

    public static void writer(String filePath, Collection<String> coll, boolean isAppend) throws IOException {
        writer(filePath, coll, "UTF-8", isAppend);
    }

    public static void writer(String filePath, Collection<String> coll, String charsetName, boolean isAppend)
            throws IOException {
        if (!isAppend || !new File(filePath).exists()) {
            clear(filePath);
        }

        // TODO check
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, isAppend),
                charsetName));
        for (String string : coll) {
            writer.append(string);
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    public static void clear(String fileName) throws IOException {
        File file = new File(fileName);
        file = new File(file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }
        else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
    }

}
