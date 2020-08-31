import java.util.List;

public class Album {
//a private string property for the album ```name```
//a private property for a list of song objects called ```songs```
    private String name;
    private List<Song> songs;
//- a constructor that sets both instance properties

    public Album(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }
//- getters and setters for both instance properties

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
//a public method with a void return type called ```printTrackListings``` that will iterate through all songs for a given album and print output like the following (90s Hits is the example album name):
    void printTrackListings(){
        System.out.println(this.name + " track listing...");//this!!
        int count = 1;
        for(Song song: songs){
            System.out.println(count + " " + song.getTitle() + " by " + song.getArtist());
            count++;
        }
    }


}
