package Proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongProxy implements SongService {
    private final SongService songService;
    private final Map<Integer, Song> cache;

    public SongProxy(SongService songService) {
        this.songService = songService;
        this.cache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (cache.containsKey(songID)) {
            System.out.println("Retrieving song metadata from cache...");
            return cache.get(songID);
        } else {
            Song song = songService.searchById(songID);
            cache.put(songID, song);
            return song;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        System.out.println("Retrieving songs metadata from cache...");
        return songService.searchByTitle(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        System.out.println("Retrieving songs metadata from cache...");
        return songService.searchByAlbum(album);
    }
}
