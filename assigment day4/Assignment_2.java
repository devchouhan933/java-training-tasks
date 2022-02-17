package com.company.day4;

import java.util.*;

/*
    Suppose you are given a List of songs.
    genre = pop, rock,
    write a function that returns for each genre the song that is played
    the maximum number of times.
    song = {"title-1", 5 , ["pop","rock"]}, {"title-2",6,["pop"]}, {"title-3",4,["rock"]}
    output:
    pop -> title-2,6
    rock -> title-1, 5
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
    public static void main(String[] args) {
        Song song_1 = new Song("title_1", 2, Arrays.asList("pop", "rock"));
        Song song_2 = new Song("title_2", 3, Arrays.asList("rock"));
        Song song_3 = new Song("title_3", 5, Arrays.asList("pop"));
        Song song_4 = new Song("title_4", 3, Arrays.asList("pop"));
        List<Song> songs = Arrays.asList(song_1, song_2, song_3, song_4);
        genreMaxPlayedSong(songs);
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
        return "Song{" +
                "title='" + title + '\'' +
                ", playCount=" + playCount +
                ", genre=" + genre +
                '}';
    }

}

