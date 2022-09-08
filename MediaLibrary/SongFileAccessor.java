import java.io.*;
import java.util.ArrayList;

public class SongFileAccessor extends FileAccessor{

   SongList songs;
   public SongFileAccessor(String f) throws IOException{
      super(f);
      songs = new SongList();
   }
  
   public void processLine(String line){
      String[] temp = line.split(",");
      Song obj;
      double pt = Double.parseDouble(temp[3]);
      if(temp[1].length()==0 || temp[1].equals(" ")){
         obj = new Song(temp[0],temp[2],pt);
      }
      else{
         obj = new Song(temp[0],temp[1],temp[2],pt);
      }
      songs.addSong(obj);
   }
  
   public String songToCSVString(Song song){
      if(song.getAlbum().equals(" ")){
         return song.getTitle()+",,"+song.getArtist()+","+song.getPlayTime();
      }else{
         return song.getTitle()+","+song.getAlbum()+","+song.getArtist()+","+song.getPlayTime();
      }
   }
  
   public String getSongsAsCSV(SongList songList){
      ArrayList<Song> tempArr = new ArrayList<Song>();
      tempArr.addAll(songList.getSongList());
      String songCSV = "";
      for(int i=0;i<tempArr.size();i++){
         songCSV += songToCSVString(tempArr.get(i))+"\n";
      }
      return songCSV;
   }
   
   public SongList getSongList(){
      return songs;
   }
   
   public void writeSongsToFile(SongList songs) throws IOException{
      writeToFile(getSongsAsCSV(songs), fileName);
   }
  
   public static void main(String[] args)throws IOException{
      String dataFile = "songfiles/test0songs.txt";
      SongFileAccessor sfa = new SongFileAccessor(dataFile);
      Song song1 = new Song("Kashmir", "Physical Graffiti", "Led Zepplin", 8.37);
      System.out.println("****** Test songToCSVString ******");
      String songCSVstr = sfa.songToCSVString(song1);
      System.out.println("songToCSVString output: "+ songCSVstr); 
      System.out.println("correct output:  Kashmir,Physical Graffiti,Led Zepplin,8.37");
      System.out.println(" ");
      System.out.println("****** Test getSongsAsCSV ******");
      SongList songList = new SongList();
      songList.addSong(new Song("What About Us", "Beautiful Trauma", "P!nk", 4.31));
      String songsCSVstr = sfa.getSongsAsCSV(songList);
      System.out.println("songToCSVString output:  "+ songsCSVstr);
      System.out.println("correct output:  What About Us,Beautiful Trauma,P!nk,4.31");
      System.out.println("-note: should see a space between the above because a line break is added in getSongsAsCSV.");
      System.out.println(" ");
      System.out.println("****** Test processLine ******");
      String csvLine = "Like It Is,The Blue,Yusef Lateef,7.36";
      sfa.processLine(csvLine);
      SongList songs = sfa.getSongList();
      ArrayList<Song> songArrayList = songs.getSongList();
      Song testSong = songArrayList.get(0);
      System.out.println("title test: "+"Like It Is"+ " - "+testSong.getTitle());
      System.out.println("album test: "+"The Blue"+ " - "+testSong.getAlbum());
      System.out.println("artist test: "+"Yusef Lateef"+ " - "+testSong.getArtist());
      System.out.println("playtime test: 7.36"+ " - "+testSong.getPlayTime());
   }
}