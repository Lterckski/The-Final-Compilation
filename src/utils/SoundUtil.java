package utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundUtil {

    public static void play(String fileName) {
        String path = "The-Final-Compilation/src/audio/" + fileName;

        try {
            File soundFile = new File(path);
            if (!soundFile.exists()) {
                System.out.println("Sound file not found: " + path);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error playing sound (" + path + "): " + e.getMessage());
        }
    }
}
