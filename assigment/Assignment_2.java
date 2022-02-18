package com.company.day4;

import java.util.*;
import java.util.stream.Collectors;

/*
Suppose you are given a List of songs.
genre = pop, rock,
write a function that returns for each genre the song that is played
the maximum number of times.
song = {"title-1", 5 , ["pop","rock"]}, {"title-2",6,["pop"]}, {"title-3",4,["rock"]},
{"title-4",4,["pop","rock","classical"]},{"title-5",10,["jazz","pop"],
{"title-6",1,["jazz"]}, {"title-7",6,["jazz"]}
}
output:
pop -> title-2,6
rock -> title-1, 5
}
k=2
Map<String, List<>> function(songList, int k){
output:
pop ->  title-2 , 6 | title-5 , 10
rock -> title-1 ,5 | title-3 , 4
classical -> title-4 , 4
jazz -> title-5 , 10 |title-7,  6
}
 */
 public class Assignment_2 {


    public static void genreMaxPlayedSong(List<Song> songs) {
        HashMap<String, Song> map = new HashMap<>();
        for (Song song : songs) {
            List<String> genres = song.getGenre();
            for (String genre : genres) {
                if (map.containsKey(genre)) {
                    Song preSong = map.get(genre);
                    if (preSong.getPlayCount() < song.getPlayCount()) {
                        map.put(genre, song);
                    }
                } else {
                    map.put(genre, song);
                }
            }
        }
        Set<Map.Entry<String, Song>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            Song song = (Song) entry.getValue();
            System.out.println(entry.getKey() + " -> " + song.getTitle() + "," + song.getPlayCount());
        }
    }

    private static HashMap<String, List<Song>> genreN_MaxPlayedSong(List<Song> songs, long n) {
        HashMap<String, List<Song>> genreSongsMap = new HashMap<>();
        for (Song song : songs) {
            List<String> genres = song.getGenre();
            for (String genre : genres) {
                if (genreSongsMap.containsKey(genre)) {
                    List<Song> songs1 = new ArrayList<>(genreSongsMap.get(genre));
                    songs1.add(song);
                    genreSongsMap.put(genre, songs1.stream().sorted((s1, s2) -> s2.getPlayCount() - s1.getPlayCount()).limit(n).collect(Collectors.toList()));
                } else {
                    genreSongsMap.put(genre, Arrays.asList(song));
                }
            }
        }
        return genreSongsMap;
    }

    public static void main(String[] args) {
        Song song_1 = new Song("title_1", 1, Arrays.asList("pop"));
        Song song_2 = new Song("title_2", 2, Arrays.asList("rock"));
        Song song_3 = new Song("title_3", 8, Arrays.asList("pop"));
        Song song_4 = new Song("title_4", 9, Arrays.asList("pop"));
        Song song_5 = new Song("title_5", 6, Arrays.asList("rock"));
        Song song_6 = new Song("title_5", 10, Arrays.asList("rock", "classic", "pop"));
        List<Song> songs = Arrays.asList(song_1, song_2, song_3, song_4, song_5, song_6);
        HashMap<String, List<Song>> map = genreN_MaxPlayedSong(songs, 3);
        Set<Map.Entry<String, List<Song>>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            List<Song> value = (List<Song>) entry.getValue();
            String key = (String) entry.getKey();
            System.out.print(" " + key + " ->");
            for (Song song : value) {
                System.out.print(" " + song.getTitle() + "  " + song.getPlayCount() + " |");
            }
            System.out.println();
        }
    }
}

class Song {
    private String title;
    private int playCount;
    private List<String> genre;

    public Song() {
    }

    public Song(String title, int playCount, List<String> genre) {
        this.title = title;
        this.playCount = playCount;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song{" + "title='" + title + '\'' + ", playCount=" + playCount + ", genre=" + genre + '}';
    }

}

