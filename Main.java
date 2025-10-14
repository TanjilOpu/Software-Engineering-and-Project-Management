//package media;

import media.Music;
import media.Music1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Music object ...set with setter\n");

        // Using setters
        Music music = new Music();
        music.setTitle("Shape of You");
        music.setArtist("Ed Sheeran");

        System.out.println("Title: " + music.getTitle());
        System.out.println("Artist: " + music.getArtist());
        music.playMusic();

        System.out.println("\nMusic1 object ...set with constructor\n");

        // Using constructor
        Music1 music1 = new Music1("Blinding Lights", "The Weeknd");

        System.out.println("Title: " + music1.getTitle());
        System.out.println("Artist: " + music1.getArtist());
        music1.playMusic();
    }
}
