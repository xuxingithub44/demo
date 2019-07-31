package com.xx;

import java.util.List;

public class DirVideoInfo {
    private List<VideoInfo> videoInfos;
    private long durations;

    public List<VideoInfo> getVideoInfos() {
        return videoInfos;
    }

    public void setVideoInfos(List<VideoInfo> videoInfos) {
        this.videoInfos = videoInfos;
    }

    public long getDurations() {
        return durations;
    }

    public void setDurations(long durations) {
        this.durations = durations;
    }
}
