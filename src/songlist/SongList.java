/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songlist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Wei-Yu Liao (Will)
 */
public class SongList {
 static Scanner input = new Scanner(System.in);
 static ArrayList<Song> songlist= new ArrayList<>();
 static int count = 0 ;
 public static void printMenu(){
     System.out.println("***** SongList App *****"+"\n"
                    +"Welcome to SongList App"+"\n"
                    +"1. Print song(within a rang of years)"+"\n"
                    +"2. Print album"+"\n"
                    +"3. Add a song"+"\n"
                    +"4. Update a song"+"\n"
                    +"5. Delete a song"+"\n"
                    +"6. Quit");
 }
 public static void updateMenu(){
     System.out.println("1. Update title"+"\n"
                    +"2. Update artist"+"\n"
                    +"3. Update album"+"\n"
                    +"4. Update year"+"\n"
                    +"5. Update duration"+"\n"
                    +"6. end");
 }
 public static int getChoice(int lo, int hi) {
	int choice=0;
        do {
            printMenu();
            choice = input.nextInt();
            input.nextLine();
        } while(choice > hi || choice < lo); 
   //  System.out.println("Please re-enter a number from" + 1 + " to "+ 6 +":");
        return choice;
    }
 static int getUpdateChoice(int lo, int hi){
     int choice=0;
        do {
            updateMenu();
            choice = input.nextInt();
            input.nextLine();
        } while(choice > hi || choice < lo); 
        return choice;
    }
 static void upDate(){
    
     System.out.println("Please enter the title of a song : ");
     String title = input.next();
       int idx = findSongIndex(title);
       if(idx == -1) {
            System.out.println("Cant find title.");
            return;
        }
      Song  s = songlist.get(idx);
     boolean end = false;
     do{
     switch (getUpdateChoice(1,6)){
         case 1: getNewTitle(s); break;
         case 2: getNewArtist(s); break;
         case 3: getNewAlbum(s); break;
         case 4: getNewYear(s); break;
         case 5: getNewDuration(s) ; break;
         case 6: end = true ; break; 
     }
     }while(!end);
     return ;
     
 }
 
    static Song getNewSongInfo(){
            Song s = new Song();
            String newtitle = "";
            while(newtitle.isEmpty()){
            System.out.println("Please enter title: ");
            newtitle = input.nextLine();
        }
        s.setTitle(newtitle);
            String newartist = "";
            while(newartist.isEmpty()){
            System.out.println("Please enter artist: ");
            newartist = input.nextLine();
        }
        s.setArtist(newartist);
            String newalbum = "";
            while(newalbum.isEmpty()){
            System.out.println("Please enter album: ");
            newalbum = input.nextLine();
        }
        s.setAlbum(newalbum);
        {
            int newyear = 0;
            while(newyear < 1920 || newyear > 2016) {
            System.out.print("Enter year: ");
            newyear = input.nextInt();
        }
        s.setYear(newyear);
        }
            double newduration = 0.0;
            while(newduration <= 0.0){
            System.out.println("Please enter duration: ");
            newduration = input.nextDouble();
        }
        s.setDuration(newduration);
        return s;
  }
 static Song getNewTitle(Song s){
           
            System.out.println("Please enter title: ");
            s.setTitle(input.nextLine());
            return s;
 }
 static Song getNewArtist(Song s){
            String newartist = "";
            while(newartist.isEmpty()){
            System.out.println("Please enter artist: ");
            newartist = input.nextLine();
        }
            s.setArtist(newartist);
            return s;
 }
 static Song getNewAlbum(Song s){
            String newalbum = "";
            while(newalbum.isEmpty()){
            System.out.println("Please enter album: ");
            newalbum = input.nextLine();
        }
            s.setAlbum(newalbum);
            return s;
 }
 static Song getNewYear(Song s){
            int newyear = 0;
            while(newyear < 1920 || newyear > 2016) {
            System.out.print("Enter year: ");
            newyear = input.nextInt();
            }
            s.setYear(newyear);
            return s;
 }
  static Song getNewDuration(Song s){
            double newduration = 0.0;
            while(newduration <= 0.0){
            System.out.println("Please enter duration: ");
            newduration = input.nextDouble();
        }
        s.setDuration(newduration);
        return s;
  }
  
  static void addSong()
    {
         Song s = getNewSongInfo() ;
         songlist.add(s);  
    }
   static void printSongs(){
    ArrayList<Song> songYear= new ArrayList<>();
    System.out.println("Would you like to limit the range of years? (y/n?) ");
    String rangeYes = input.next();
    if (rangeYes.equalsIgnoreCase("y") || rangeYes.equalsIgnoreCase("yes")){   
     System.out.println("Please enter begin year: ");
     int range = input.nextInt();
     System.out.println("Please enter end year: ");
     int range2 =input.nextInt();
     for(Song s: songlist) {
            if(s.getYear() >= range && s.getYear() <= range2 )
             songYear.add(s);
            }
     for(Song s: songYear) {
            s.printSong();
            } 
    }
    else {
     for(Song s: songlist) {
            s.printSong();
            }
         }
   }
   static void printAlbum(){
       ArrayList<Song> printalbum= new ArrayList<>();
       System.out.println("Please enter an album");
       String album = input.nextLine();
       for (Song s: songlist){
           if(s.getAlbum().equalsIgnoreCase(album))
             printalbum.add(s);
       }
       for(Song s: printalbum) {
            s.printSong();
       }
       double durationSum = 0.0;
       for(Song s: printalbum){
           durationSum += s.getDuration();
       }
       System.out.println("The total duration is "+durationSum+ " mintues");
   }
   
    static int findSongIndex(String title) {
        int idx= -1;
	for(Song s: songlist) {
            if(s.getTitle().equals(title)) {
                idx = songlist.indexOf(s);
                break;
            }
        }
        return idx;
    }
   static void deleteSong(){
       System.out.println("Please enter a song to be deleted: ");
       String delete = input.next();
       int idx = findSongIndex(delete);
       if(idx == -1) {
            System.out.println("Cant find title.");
            return;
        }
         songlist.remove(idx);
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int choice;
       do { choice = getChoice(1,6);
	    switch(choice) {
	        case 1: printSongs();break;
               case 2: printAlbum();break;
	        case 3: addSong();break;
               case 4: upDate(); break;
               case 5: deleteSong();break;      
		 case 6: System.out.println("Thank you for using SongList App");
                      System.exit(0);
            }
       }while (choice !=6);
}
}
