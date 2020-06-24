# Build a Karaoke App Mock Java Assessment!

This repository is a source of practice for the Java concepts introduced in the Java II Codeup curriculum.

## Set Up

1. read through all instructions in this readme
1. fork, clone, and open this repository in your preferred IDE for Java
1. create and checkout to a new branch called ```my-solution```
1. follow the steps below to build a karaoke program

## Instructions

The ```KaraokeApp``` class included with this project contains a commented out main method that can be used to test your app after you complete it. Add other main methods to any class as needed for simpler testing as you build the app.    

1. add a ```Song``` class with the following...
	
	- private string properties for ```title```, ```artist```, and a private list of strings for ```lyrics```
	- a constructor to assign values to all instance properties
	- getters and setters for all instance properties
	- a static method ```parseLyrics``` that takes in a single string input of possibly several words and returns a list of strings that are the output of splitting all the words in the input string on a single space character ```" "```

1. add a ```Album``` class with the following...

	- a private string property for the album ```name```
	- a private property for a list of song objects called ```songs```
	- a constructor that sets both instance properties
	- getters and setters for both instance properties
	- a public method with a void return type called ```printTrackListings``` that will iterate through all songs for a given album and print output like the following (90s Hits is the example album name):

	```
	90S HITS track listing...
	1. Every Day is a Winding Road by Sheryl Crow
	2. Ready to Go by Republica
	3. Airbag by Radiohead
	```
1. add a ```Playable``` interface with the following...

	- a method called ```play``` that takes in an album instance with a void return type
	- a method called ```play``` that takes in a song instance with a void return type

1. add an abstract ```Player``` class that implements the ```Playable``` interface (not it's methods, however) and include the following...

	- an int constant called ```WORD_CADENCE``` set to a value of 600
	- an int constant called ```INTRO_PAUSE``` set to a value of 7000

1. add a class ```MusicPlayer``` that extends the ```Player``` abstract class and include the following...

	- a private instance string property called ```voice``` set to an empty string by default
	- an empty constructor
	- a constructor that sets the value of the ```voice``` property
	- a getter and setter for the ```voice``` property
	- an implmentation of the ```play``` method that takes in a song instance and does the following...
		- 	this method will create a runtime instance with the following code ```Runtime r = Runtime.getRuntime();```
		-  a command can be issued from Java to the terminal using ```r.exec()``` and passing in a string that will be executed by the terminal (this will require handling a checked exception; please use a try-catch for this)
		-  you can make your MacBook say text aloud by simply running a command in the terminal using the ```say``` command. For example, you can make your computer say "hello world" by typing into the terminal ```say hello world```
		-  using the knowledge in the previous bullet points, this method should issue a say command to the terminal for each lyric in the list of song ```lyrics```
		-  to avoid saying multiple words at once, issue include a pause after saying "now playing...SONG_TITLE by SONG_ARTIST" using the ```sleep()``` method and passing in the ```INTRO_PAUSE``` constant (this is the number of milliseconds to wait) and include a ```sleep()``` command after each lyric reading command is issued, passing in the constant ```WORD_CADENCE```
		- for each say command, you can also pass in a ```-v``` flag and include the name of the computer voice you would like the say command to be spoken with (you can use the ```voice``` property for this)
		- if you get stuck on these steps, an example of a possible implementation of the ```play(Song s)``` method is further below
	- an implementation of the ```play``` method that takes in an album instance and invokes the ```play(Song s)``` method for each song in the album
1. add a ```LyricsPlayer``` class that extends ```Player``` and includes the following...
	- add the following static constants:
	
        ```
         public static final String RESET = "\u001B[0m";
         public static final String RED = "\u001B[31m";
         public static final String GREEN = "\u001B[32m";
         public static final String YELLOW = "\u001B[33m";
         public static final String BLUE = "\u001B[34m";
         public static final String PURPLE = "\u001B[35m";
         public static final String CYAN = "\u001B[36m";
        ``` 
	- a private string instance property for ```textColor``` set to the value ```"default"```
	- an empty constructor
	- a constructor that sets the ```textColor``` value
	- getter and setter for ```textColor```
	- copy and paste the following ```displayText``` method:

        ```
        private void displayText(String string) {
            String colorCode = RESET;
            switch(textColor.toLowerCase()) {
                case "red":
                    colorCode = RED;
                    break;
                case "green":
                    colorCode = GREEN;
                    break;
                case "yellow":
                    colorCode = YELLOW;
                    break;
                case "blue":
                    colorCode = BLUE;
                    break;
                case "purple":
                    colorCode = PURPLE;
                    break;
                case "cyan":
                    colorCode = CYAN;
                    break;
            }
            System.out.printf("%s%s", colorCode, string);
        }
        ```
	- using the ```play``` method implementations in the ```MusicPlayer``` class as a reference, implement the ```play``` methods in the ```LyricsPlayer``` class to behave similarly but instead of saying the lyrics, it should print them out in a timed way. First, sout out ```RESET + "Now playing... SONG-TITLE by SONG-ARTIST"``` message before each song and using the ```displayText``` method to display each lyric. Remember to use the ```sleep``` method and the ```INTRO_PAUSE``` and ```WORD_CADENCE``` constants to handle timing. 


In total, you should have the following files inside your ```src``` folder upon completion:

```
Album
KaraokeApp
LyricsPlayer
MusicPlayer
Playable
Player
Song
```

## Hint

***Skip over the following code example to avoid seeing an example solution of the play(Song s) method from the MusicPlayer class***
	
Here is what a possible ```play(Song s)``` might look like in the ```MusicPlayer``` class...
	
```
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
```

## Solution Branch

While it is preferable to build your own working solution of this app first, at any point, you can checkout to the ```solution``` branch to review an existing solution.
