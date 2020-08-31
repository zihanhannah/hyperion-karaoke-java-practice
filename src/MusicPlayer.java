public class MusicPlayer extends Player {
    //- a private instance string property called ```voice``` set to an empty string by default
    private String voice = "";
//- an empty constructor

    public MusicPlayer() {
    }
//- a constructor that sets the value of the ```voice``` property

    public MusicPlayer(String voice) {
        this.voice = voice;
    }
//	- a getter and setter for the ```voice``` property

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public void play(Album album) {
//- an implementation of the ```play``` method that takes in an album instance and invokes the ```play(Song s)``` method for each song in the album
        for(Song song : album.getSongs()){
            play(song);
        }
    }

    @Override
    public void play(Song song) {
        Runtime r = Runtime.getRuntime();
//-  a command can be issued from Java to the terminal using ```r.exec()``` and passing in a string that will be executed by the terminal (this will require handling a checked exception; please use a try-catch for this)
//		-  you can make your MacBook say text aloud by simply running a command in the terminal using the ```say``` command. For example, you can make your computer say "hello world" by typing into the terminal ```say hello world```
//		-  using the knowledge in the previous bullet points, this method should issue a say command to the terminal for each lyric in the list of song ```lyrics```
//	-  to avoid saying multiple words at once, issue include a pause after saying "now playing...SONG_TITLE by SONG_ARTIST" using the ```sleep()``` method and passing in the ```INTRO_PAUSE``` constant (this is the number of milliseconds to wait) and include a ```sleep()``` command after each lyric reading command is issued, passing in the constant ```WORD_CADENCE```
        try { r.exec("say "+ "now playing..." + song.getTitle() + " by " + song.getArtist());
            Thread.sleep(Player.INTRO_PAUSE);
            for(String lyric :song.getLyrics()){
                r.exec("say " + lyric);
                Thread.sleep(Player.WORD_CADENCE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
