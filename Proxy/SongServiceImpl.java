package Proxy;

import java.util.ArrayList;
import java.util.List;

public class SongServiceImpl implements SongService {
    private final List<Song> songs;

    public SongServiceImpl() {
        this.songs = new ArrayList<>();
        // Songs
        songs.add(new Song("Montero (Call Me By Your Name)", "Lil Nas X", "Montero", 181));
        songs.add(new Song("Levitating (feat. DaBaby)", "Dua Lipa", "Future Nostalgia", 203));
        songs.add(new Song("Peaches (feat. Daniel Caesar & Giveon)", "Justin Bieber", "Justice", 198));
        songs.add(new Song("Save Your Tears", "The Weeknd", "After Hours", 215));
        songs.add(new Song("drivers license", "Olivia Rodrigo", "SOUR", 242));
        songs.add(new Song("Blinding Lights", "The Weeknd", "After Hours", 200));
        songs.add(new Song("good 4 u", "Olivia Rodrigo", "SOUR", 178));
        songs.add(new Song("Leave The Door Open", "Silk Sonic", "An Evening with Silk Sonic", 242));
        songs.add(new Song("Without You", "The Kid LAROI", "F*CK LOVE (SAVAGE)", 171));
        songs.add(new Song("Up", "Cardi B", "Up", 174));
    }

    @Override
    public Song searchById(Integer songID) {
        // Simulate delay for realistic representation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Dummy implementation for demonstration, could retrieve song from database
        return songs.get(songID - 1); // Assuming songID starts from 1
    }

    @Override
    public List<Song> searchByTitle(String title) {
        // Simulate delay for realistic representation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Dummy implementation for demonstration, could search songs in database
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        // Simulate delay for realistic representation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Dummy implementation for demonstration, could search songs in database
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().toLowerCase().contains(album.toLowerCase())) {
                result.add(song);
            }
        }
        return result;
    }
}
