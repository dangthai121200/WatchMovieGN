package com.example.demo;

import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.feature.local.matcher.FastBasicKeypointMatcher;
import org.openimaj.feature.local.matcher.LocalFeatureMatcher;
import org.openimaj.feature.local.matcher.consistent.ConsistentLocalFeatureMatcher2d;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.feature.local.engine.DoGSIFTEngine;
import org.openimaj.image.feature.local.keypoints.Keypoint;
import org.openimaj.math.geometry.transforms.estimation.RobustAffineTransformEstimator;
import org.openimaj.math.model.fit.RANSAC;
import org.openimaj.video.Video;
import org.openimaj.video.xuggle.XuggleVideo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeyFrameDetection {
    static Video<MBFImage> video;
    static List<MBFImage> imageList = new ArrayList<MBFImage>();
    static List<Long> timeStamp = new ArrayList<Long>();
    static List<Double> mainPoints = new ArrayList<Double>();

    public static void main(String args[]) throws MalformedURLException {
        // https://d2kk6yv2oyh0kd.cloudfront.net/content/1/62023/video/4918026670_img_1569.mp4

        // Run as commandline
        // jar -xvf JavaProgramingTest-0.0.1-SNAPSHOT.war
        // cd WEB-INF
        // java -classpath "lib/*;classes/." com.example.demo.KeyFrameDetection
        //"D:/EnTribe/Task/EP-3490-Content-VideoDetection-KeyFrames/4918026670_img_1569.mp4"

        String path = "http://d2kk6yv2oyh0kd.cloudfront.net/content/1/62023/video/4918026670_img_1569.mp4";
        Frames(path);//w  ww. j a  va 2s .co  m
        MainFrames();
    }

    public static void Frames(String path) throws MalformedURLException {
        video = new XuggleVideo(new URL(path));
        int j = 0;
        for (MBFImage mbfImage : video) {
            BufferedImage bufferedFrame = ImageUtilities
                    .createBufferedImageForDisplay(mbfImage);
            j++;
            String name = "D:\\EnTribe\\Task\\EP-3490-Content-VideoDetection-KeyFrames\\openimaj\\test.jpg";
            File outputFile = new File(name);

            try {

                ImageIO.write(bufferedFrame, "jpg", outputFile);

            } catch (IOException e) {
                e.printStackTrace();
            }
            MBFImage b = mbfImage.clone();
            imageList.add(b);
            timeStamp.add(video.getTimeStamp());
        }
    }

    public static void MainFrames() {
        for (int i = 0; i < imageList.size() - 1; i++) {
            MBFImage image1 = imageList.get(i);
            MBFImage image2 = imageList.get(i + 1);
            DoGSIFTEngine engine = new DoGSIFTEngine();
            LocalFeatureList<Keypoint> queryKeypoints = engine
                    .findFeatures(image1.flatten());
            LocalFeatureList<Keypoint> targetKeypoints = engine
                    .findFeatures(image2.flatten());
            RobustAffineTransformEstimator modelFitter = new RobustAffineTransformEstimator(
                    5.0, 1500,
                    new RANSAC.PercentageInliersStoppingCondition(0.5));
            LocalFeatureMatcher<Keypoint> matcher = new ConsistentLocalFeatureMatcher2d<Keypoint>(
                    new FastBasicKeypointMatcher<Keypoint>(8), modelFitter);
            matcher.setModelFeatures(queryKeypoints);
            matcher.findMatches(targetKeypoints);
            double size = matcher.getMatches().size();
            mainPoints.add(size);
            System.out.println(size);
        }
        Double max = Collections.max(mainPoints);
        for (int i = 0; i < mainPoints.size(); i++) {
            if (((mainPoints.get(i)) / max < 0.01) || i == 0) {
                Double name1 = mainPoints.get(i) / max;
                BufferedImage bufferedFrame = ImageUtilities
                        .createBufferedImageForDisplay(imageList.get(i + 1));
                String name = i + "_"
                        + name1.toString() + ".jpg";
            }
        }
    }
}