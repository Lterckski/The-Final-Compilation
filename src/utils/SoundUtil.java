package utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class SoundUtil {

    // adjust this if your working directory is different
    private static final String BASE_PATH = "The-Final-Compilation/src/audio/";

    private static Clip bgmClip;

    // ---------- ONE-SHOT SFX ----------

    // default full volume
    public static void play(String relativePath) {
        play(relativePath, 1.0f);
    }

    public static void play(String relativePath, float volume) {
        String path = BASE_PATH + relativePath;

        try {
            File soundFile = new File(path);
            if (!soundFile.exists()) {
                System.out.println("Sound file not found: " + path);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            setVolume(clip, volume);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error playing sound (" + path + "): " + e.getMessage());
        }
    }

    // ---------- LOOPING BGM ----------

    // default full volume
    public static void playLoop(String relativePath) {
        playLoop(relativePath, 1.0f);
    }

    public static void playLoop(String relativePath, float volume) {
        stopLoop(); // stop any previous loop

        String path = BASE_PATH + relativePath;

        try {
            File soundFile = new File(path);
            if (!soundFile.exists()) {
                System.out.println("BGM file not found: " + path);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            bgmClip = AudioSystem.getClip();
            bgmClip.open(audioStream);

            setVolume(bgmClip, volume);
            bgmClip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error playing BGM (" + path + "): " + e.getMessage());
        }
    }

    public static void stopLoop() {
        if (bgmClip != null) {
            if (bgmClip.isRunning()) {
                bgmClip.stop();
            }
            bgmClip.close();
            bgmClip = null;
        }
    }

    // ---------- VOLUME HELPER ----------

    private static void setVolume(Clip clip, float volume) {

        if (volume < 0f) volume = 0f;
        if (volume > 1f) volume = 1f;

        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            // convert 0–1 to decibels
            float safe = (volume <= 0.0001f) ? 0.0001f : volume;
            float dB = (float) (20.0 * Math.log10(safe));
            gain.setValue(dB);
        }
    }
    // --------- DELAY SFX ---------

    public static void playDelayed(String relativePath, int delayMs) {
        new Thread(() -> {
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException ignored) {
            }
            play(relativePath);
        }).start();
    }
    public static void playDelayed(String relativePath, int delayMs, float volume) {
        new Thread(() -> {
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException ignored) {
            }
            play(relativePath, volume);
        }).start();
    }


}
