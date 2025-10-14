package media;

public class Music {
    private String title;
    private String artist;

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Method to display music info
    public void playMusic() {
        System.out.println("Playing music...");
    }
}
