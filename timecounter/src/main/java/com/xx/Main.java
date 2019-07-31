package com.xx;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static String[] exts = {".avi", ".rmvb" ,".rm", ".asf", ".divx", ".mpg", ".mpeg", ".mpe",
            ".wmv", ".mp4", ".mkv", ".vob"};
    public static void main(String[] args) {
        List<File> files = FileUtil.getAllFile("G:/BaiduNetdiskDownload/【马士兵教育】公开课大礼包");
        long time = 0L;
        for (String end : exts){
            DirVideoInfo dirVideoInfo = MovieUtil.getVideoDuration(FileUtil.filterEndWiy(files, end));
            if (0L != dirVideoInfo.getDurations()){
                time += dirVideoInfo.getDurations();
                System.out.println(String.format("%s文件总时长: %s", end, timeFormat(dirVideoInfo.getDurations())));
            }
        }
        // 计算总时长
        if (0L == time){
            System.out.println("当前目录下不包含视频文件，视频后缀名为：" + Arrays.toString(exts));
        } else {
            System.out.println("视频总时长: " + timeFormat(time));
        }
    }

    /**
     * 时长转化为中文
     * @param time
     * @return
     */
    private static String timeFormat(long time){
        long seconds = time / 1000;

        long days = seconds / (3600 * 24);
        long hours = (seconds - days * 3600 *24) / 3600;
        long millis = (seconds - days * 3600 *24 - hours * 3600) / 60 ;
        long second = seconds % 60;

        StringBuilder stringBuilder = new StringBuilder();
        if (0 != days){
            stringBuilder.append(days).append("天");
        }
        if (0 != hours){
            stringBuilder.append(hours).append("小时");
        }
        if (0 != millis){
            stringBuilder.append(millis).append("分");
        }
        if (0 != second){
            stringBuilder.append(second).append("秒");
        }
        return stringBuilder.toString();
    }

    private static void printVideoInfo(VideoInfo videoInfo){
        System.out.println(String.format("名称: %s\t时长: %s\t路径: %s", videoInfo.getName(), timeFormat(videoInfo.getDuration()), videoInfo.getFile().getAbsolutePath()));
    }
}
