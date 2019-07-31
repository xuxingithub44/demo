package com.xx;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MovieUtil {
    private static Encoder encoder = new Encoder();

    public static DirVideoInfo getVideoDuration(List<File> videos){
        DirVideoInfo dirVideoInfo = new DirVideoInfo();
        List<VideoInfo> videoInfos = new ArrayList<VideoInfo>(videos.size());
        long totalTime = 0L;
        long duration = 0L;
        MultimediaInfo multimediaInfo;

        for (File video : videos){
            try{
                multimediaInfo = encoder.getInfo(video);
                duration = multimediaInfo.getDuration();
                totalTime += duration;
                videoInfos.add(new VideoInfo(video, video.getName(), duration));
            } catch (InputFormatException e) {
                e.printStackTrace();
            } catch (EncoderException e) {
                e.printStackTrace();
            }
        }
        dirVideoInfo.setVideoInfos(videoInfos);
        dirVideoInfo.setDurations(totalTime);
        return dirVideoInfo;
    }
}
