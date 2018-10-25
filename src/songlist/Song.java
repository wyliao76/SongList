/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songlist;

/**
 *
 * @author Wei-Yu Liao (Will)
 */
public class Song {
    private String title, artist, album;
    private int year;
    private double duration;
    Song(){
        title = "";
        artist = "";
        album = "";
        year = 0;
        duration = 0.0;
}
    Song(String t, String a, String al, int y, double d){
        title = t;
        artist = a;
        album= al;
        year = y;
        duration = d;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }
    public String getAlbum(){
        return album;
    }
    public int getYear(){
        return year;
    }
    public double getDuration(){
        return duration;
    }
     public void setTitle(String t) {
        title = t;
    }
     public void setArtist(String a){
        artist = a ;
    }
     public void setAlbum(String al){
        album = al;
    }
     public void setYear(int y){
        year = y;
    }
     public void setDuration(double d){
        duration = d;
    }
      public void printSong() {
       System.out.println("%%%%%%%%%%%%%");
	System.out.println("Title: " + title);
       System.out.println("Artist: " + artist);
       System.out.println("Album: " + album);
	System.out.println("Year: " + year);
       System.out.println("Duration: " + duration);
       System.out.println("%%%%%%%%%%%%%");
    }
}
