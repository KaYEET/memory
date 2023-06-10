package memorypackage.model;

import javafx.scene.media.AudioClip;

import java.io.File;
/**
 * This class is responsible for the timer and the sounds during the game.
 * @author Niels Verstrepen, Kai Ekkart
 * @version 1.0
 * @version JDK 11.08
 * @since 25 March 2022
 */
public class TimerModel {
    private int minutes;
    private int seconds;
    private long timer;
    AudioClip clockSoundClip = new AudioClip(new File("resources/sounds/clock-ticking-3.mp3").toURI().toString());

    public TimerModel() {
    }

    /**
     * This method is responsible of keeping track of the minutes and seconds.
     */
    public void tick() {
        clockSoundClip.play();
        this.seconds++;
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes++;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    /**
     * This method is used to calculate the amount of time the player needed to finish the game and will be used in the HighscoresModel.
     * @return Long - time needed to finish the game.
     */
    public long calculateTimer() {
        return (System.currentTimeMillis() - timer) / 1000;
    }
}

