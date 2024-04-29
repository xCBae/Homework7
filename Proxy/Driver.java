package Proxy;

import java.util.List;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        // Create a proxy song service
        SongService songService = new ProxySongService(new SongServiceImpl());

        // Print some random songs without needing to search
        System.out.println("Here are some random Popular songs:");
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomSongId = random.nextInt(10) + 1; // Assuming 10 songs are added
            
            // Simulate delay for realistic representation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Song randomSong = songService.searchById(randomSongId);
            System.out.println(formatSong(randomSong));
        }

        // Search for songs
        System.out.println("\nSearch by ID:");
        Song songById = songService.searchById(1);
        System.out.println(formatSong(songById));

        System.out.println("\nSearch by Title:");
        List<Song> songsByTitle = songService.searchByTitle("Levitating");
        for (Song song : songsByTitle) {
            System.out.println(formatSong(song));
        }

        System.out.println("\nSearch by Album:");
        List<Song> songsByAlbum = songService.searchByAlbum("Montero");
        for (Song song : songsByAlbum) {
            System.out.println(formatSong(song));
        }

        // Search for the same song again to test caching
        System.out.println("\nSearch by ID (Cached):");
        Song cachedSongById = songService.searchById(1);
        System.out.println(formatSong(cachedSongById));
    }

    private static String formatSong(Song song) {
        return "\"" + song.getTitle() + "\" by \"" + song.getArtist() + "\", Album: " +
                song.getAlbum() + ", Duration: " + song.getDuration() + "s";
    }
}
