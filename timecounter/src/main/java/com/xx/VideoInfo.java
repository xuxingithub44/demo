package com.xx;

import java.io.File;

public class VideoInfo {
    private File file;
    private String name;
    private long duration;

    public VideoInfo(String name, long duration) {
        this.name = name;
        this.duration = duration;
    }

    public VideoInfo(File file) {
        this.file = file;
    }

    public VideoInfo(File file, String name, long duration) {
        this.file = file;
        this.name = name;
        this.duration = duration;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
