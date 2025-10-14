package media;

public class Music1 {
    private String title;
    private String artist;

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    // Constructor (sets values immediately)
    public Music1(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void playMusic() {
        System.out.println("Playing music...");
    }
}
