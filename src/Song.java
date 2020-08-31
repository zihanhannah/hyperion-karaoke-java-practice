import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Song {
//    - private string properties for ```title```, ```artist```, and a private list of strings for ```lyrics```
    private String title;
    private String artist;
    private List<String> Lyrics;
//	- a constructor to assign values to all instance properties
    public Song(String title, String artist, List<String> lyrics) {
        this.title = title;
        this.artist = artist;
        Lyrics = lyrics;
    }
//- getters and setters for all instance properties


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getLyrics() {
        return Lyrics;
    }

    public void setLyrics(List<String> lyrics) {
        Lyrics = lyrics;
    }
//- a static method ```parseLyrics``` that takes in a single string input of possibly several words and returns a list of strings that are the output of splitting all the words in the input string on a single space character ```" "```
    static List<String> parseLyrics(String input){
        List<String> output = Arrays.asList(input.split(" "));//input.split(" ") return an Array!!!!
        return output;
    }
}
