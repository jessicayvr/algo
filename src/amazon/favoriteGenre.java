package amazon;

import java.util.*;

public class favoriteGenre {

    public static void main(String[] args) {

        Map<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));


        HashMap<String, List<String>> favorite = findFavorite(userSongs, songGenres);
        System.out.println("First test: " + favorite);

        Map<String, List<String>> userSongs2 = new HashMap<>();

        userSongs2.put("David", Arrays.asList("song1", "song2"));
        userSongs2.put("Emma", Arrays.asList("song3", "song4"));

        Map<String, List<String>> songGenres2 = new HashMap<>();
        HashMap<String, List<String>> favorite2 = findFavorite(userSongs2, songGenres2);
        System.out.println("Second test: " + favorite2);
    }

    private static HashMap<String, List<String>> findFavorite(Map<String, List<String>> userSongs, Map<String, List<String>> genreSongs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, List<String>> userSong : userSongs.entrySet()) {
            // for each PERSON get persons song
            List<String> songs = userSong.getValue();
            Map<String, Integer> genreNum = new HashMap<>();
            // for each song find song genre and create the persons genreNumber map;
            for (String song : songs) {
                for (Map.Entry<String, List<String>> genreSong : genreSongs.entrySet()) {
                    if (genreSong.getValue().contains(song)) {
                        if (genreNum.containsKey(genreSong.getKey())) {
                            genreNum.computeIfPresent(genreSong.getKey(), (k, v) -> v + 1);
                        } else {
                            genreNum.putIfAbsent(genreSong.getKey(), 1);
                        }
                    }
                }
            }

            int max = 0;
            for (Map.Entry<String, Integer> GenreCount : genreNum.entrySet()) {
                Integer value = GenreCount.getValue();

                if (value > max) {
                    max = value;
                }
            }

            List<String> userGenrs = new ArrayList<>();
            for (Map.Entry<String, Integer> genraInt : genreNum.entrySet()) {
                Integer integer = genraInt.getValue();
                if (integer == max) {
                    userGenrs.add(genraInt.getKey());
                }

            }
            result.put(userSong.getKey(), userGenrs);

        }
        return result;
    }
}
