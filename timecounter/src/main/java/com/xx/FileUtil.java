package com.xx;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<File> filterEndWiy(List<File> files, String endStr){
        if (null == files || files.isEmpty() || null == endStr || "".equals(endStr.trim())){
            return new ArrayList<File>(0);
        }
        List<File> result = new ArrayList<File>(endStr.length()/2);
        for (File file : files){
            if (file.exists() && file.isFile()){
                if (file.getName().toLowerCase().endsWith(endStr.trim().toLowerCase())){
                    result.add(file);
                }
            }
        }
        return result;
    }
    /**
     * 获取该路径下所有文件
     * @param dir
     * @return
     */
    public static List<File> getAllFile(String dir){
        File dirFile = new File(dir);
        return getAllFile(dirFile);
    }

    /**
     * 获取该路径下所有文件
     * @param dir
     * @return
     */
    public static List<File> getAllFile(File dir){
        ArrayList<File> files = new ArrayList<File>();
        if (null == dir || !dir.exists()){
            return files;
        }

        if (dir.isFile()){
            files.add(dir);
            return files;
        }

        getFile(dir, files);

        return files;
    }

    /**
     * 把原路径的文件循环递归到目标列表
     * @param source
     * @param target
     */
    private static void getFile(File source, List<File> target){
        // 文件不存在
        if (null == source || !source.exists()){
            return;
        }
        // 文件直接加入
        if (source.isFile()){
            target.add(source);
        } else {
            // 读取子文件夹
            File[] files = source.listFiles();
            if (null == files || 0 ==files.length){
                // 没有文件
                return;
            } else {
                // 递归加入文件列表
                for (File file : files) {
                    getFile(file, target);
                }
            }
        }
    }
}
