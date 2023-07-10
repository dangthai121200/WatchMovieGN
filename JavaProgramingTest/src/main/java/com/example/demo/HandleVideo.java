package com.example.demo;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class HandleVideo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:handle-video.mp4");
        System.out.println(file.length());
    }
}