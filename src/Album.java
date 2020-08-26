import java.util.ArrayList;
import java.util.List;

public class Album {
    private String albumName;
    private List<Song> songs;

    public Album(String albumName, List<Song> songs) {
        this.albumName = albumName;
        this.songs = songs;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void printTrackListings() {
        // we have access to 'songs' - iterate through them here
        System.out.println(albumName + " track listing...");

        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i).getTitle() + " by " + songs.get(i).getArtist());
        }
    }

    public static void main(String[] args) {

        String lyrics1 = "Well, you can dig me up a grave and try and stick me in the ground";
        Song followYouHome = new Song("Follow You Home", "Nickelback", Song.parseLyrics(lyrics1));

        String lyrics2 = "Look at this photograph every time I do it makes me laugh";
        Song photograph = new Song("Photograph", "Nickelback", Song.parseLyrics(lyrics2));

        String lyrics3 = "I'm sick of standing in lines at clubs I'll never get in";
        Song rockStar = new Song("Rockstar", "Nickelback", Song.parseLyrics(lyrics3));

        List<Song> theseSongs = new ArrayList<>();
        theseSongs.add(followYouHome);
        theseSongs.add(photograph);
        theseSongs.add(rockStar);

        Album allTheWrongReasons = new Album("All the Wrong Reasons", theseSongs);

        allTheWrongReasons.printTrackListings();
    }
}
