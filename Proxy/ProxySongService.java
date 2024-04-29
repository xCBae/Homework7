package Proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProxySongService implements SongService {
    private final SongService songService;
    private final Map<Integer, Song> songCache;

    public ProxySongService(SongService songService) {
        this.songService = songService;
        this.songCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (songCache.containsKey(songID)) {
            System.out.println("Retrieving song from cache...");
            return songCache.get(songID);
        } else {
            System.out.println("Fetching song from server...");
            Song song = songService.searchById(songID);
            songCache.put(songID, song);
            return song;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        // Proxy does not cache search results by title
        System.out.println("Fetching song(s) by title from server...");
        return songService.searchByTitle(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        // Proxy does not cache search results by album
        System.out.println("Fetching song(s) by album from server...");
        return songService.searchByAlbum(album);
    }
}
