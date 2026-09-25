import java.util.Arrays;

public class Playlist {
    // Private fields to encapsulate the data
    private String[] songs;
    private int count;

    // Constructor to initialize the playlist with a fixed maximum size
    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    // Method to add a song to the playlist
    public void addSong(String songTitle) {
        if (count < songs.length) {
            songs[count] = songTitle;
            count++;
        } else {
            System.out.println("Playlist is full!");
        }
    }

    // Returns a defensive copy of only the songs added so far
    public String[] getSongs() {
        return Arrays.copyOf(this.songs, this.count);
    }

    // Read-only getter for the current song count
    public int getSongCount() {
        return this.count;
    }
}