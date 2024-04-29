import org.junit.jupiter.api.Test;

import Proxy.Song;
import Proxy.SongServiceImpl;
import Proxy.ProxySongService;
import Proxy.SongService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyTests {

    @Test
    public void testSearchByIdWithDelay() {
        // Create a proxy song service
        SongService songService = new ProxySongService(new SongServiceImpl());

        // Search for a song by ID
        long startTime = System.currentTimeMillis();
        Song song = songService.searchById(1);
        long endTime = System.currentTimeMillis();

        // Check if the delay is at least 1000ms
        assertTrue(endTime - startTime >= 1000, "Delay is less than 1000ms");

        // Check if the song retrieved matches the expected song
        assertEquals("Montero (Call Me By Your Name)", song.getTitle());
        assertEquals("Lil Nas X", song.getArtist());
        assertEquals("Montero", song.getAlbum());
        assertEquals(181, song.getDuration());
    }

    @Test
    public void testRandomSongs() {
        // Create a proxy song service
        SongService songService = new ProxySongService(new SongServiceImpl());

        // Print some random songs without needing to search
        System.out.println("Here are some random Popular songs:");
        for (int i = 0; i < 3; i++) {
            // Fetch a random song
            Song randomSong = getRandomSong(songService);

            // Check if the random song is not null
            assertNotNull(randomSong, "Random song is null");

            // Print the random song
            System.out.println(formatSong(randomSong));
        }
    }

    @Test
    public void testSearchById() {
        // Create a proxy song service
        SongService songService = new ProxySongService(new SongServiceImpl());

        // Search for a song by ID
        Song song = songService.searchById(1);

        // Check if the song retrieved matches the expected song
        assertEquals("Montero (Call Me By Your Name)", song.getTitle());
        assertEquals("Lil Nas X", song.getArtist());
        assertEquals("Montero", song.getAlbum());
        assertEquals(181, song.getDuration());
    }

    @Test
    public void testSearchByTitle() {
        // Create a proxy song service
        SongService songService = new ProxySongService(new SongServiceImpl());

        // Search for songs by title
        List<Song> songsByTitle = songService.searchByTitle("Levitating");

        // Check if the songs retrieved match the expected songs
        assertEquals(1, songsByTitle.size());
        Song song = songsByTitle.get(0);
        assertEquals("Levitating (feat. DaBaby)", song.getTitle());
        assertEquals("Dua Lipa", song.getArtist());
        assertEquals("Future Nostalgia", song.getAlbum());
        assertEquals(203, song.getDuration());
    }

    @Test
    public void testSearchByAlbum() {
        // Create a proxy song service
        SongService songService = new ProxySongService(new SongServiceImpl());

        // Search for songs by album
        List<Song> songsByAlbum = songService.searchByAlbum("Montero");

        // Check if the songs retrieved match the expected songs
        assertEquals(1, songsByAlbum.size());
        Song song = songsByAlbum.get(0);
        assertEquals("Montero (Call Me By Your Name)", song.getTitle());
        assertEquals("Lil Nas X", song.getArtist());
        assertEquals("Montero", song.getAlbum());
        assertEquals(181, song.getDuration());
    }

    private Song getRandomSong(SongService songService) {
        // Generate a random song ID
        int randomSongId = (int) (Math.random() * 10) + 1;

        // Retrieve the song by ID
        return songService.searchById(randomSongId);
    }

    private String formatSong(Song song) {
        return "\"" + song.getTitle() + "\" by \"" + song.getArtist() + "\", Album: " +
                song.getAlbum() + ", Duration: " + song.getDuration() + "s";
    }
}
