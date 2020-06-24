import java.io.IOException;
import static java.lang.Thread.sleep;

public class MusicPlayer extends Player {

    private String voice = "";

    public MusicPlayer() {
    }

    public MusicPlayer(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public void play(Album a) {
        for (Song s : a.getSongs()) {
            play(s);
        }
    }

    @Override
    public void play(Song s) {
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("say " + "now playing..." + s.getTitle() + " by " + s.getArtist());
            sleep(INTRO_PAUSE);
            for (String lyric : s.getLyrics()) {
                if (voice.isEmpty()) {
                    r.exec("say " + lyric);
                } else {
                    r.exec("say -v " + voice + " " + lyric);
                }
                sleep(WORD_CADENCE);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
