import java.util.ArrayList;
public class SongList {
   ArrayList<Song> songList;
     
   public SongList(){
      songList = new ArrayList<Song>();
   }
   
   public boolean isEmpty(){
      if(songList.size() == 0){
         return true;
      }else{
         return false;
      }
   }
   
   public void addSong(Song newSong){
      songList.add(newSong);
   }
   
   public String getSongListAsString(){
      String strSongList = "no songs";
      if(songList.size() == 0){
      }else{
         strSongList = "";
         for(int i=0;i<songList.size();i++){
            strSongList += (i+1)+" "+(songList.get(i)).toString()+"\n";
         }
      }
      return strSongList;
   }
   
   public boolean removeSongByTitle(String targetTitle){
      boolean output = false;
      String temp;
      for(int i=0;i<songList.size();i++){
         temp = songList.get(i).getTitle();
         if(temp.equals(targetTitle)){
            songList.remove(i);
            output = true;
         }
      }
      return output;
   }
   
   public ArrayList<Song> getSongList(){
      return songList;
   }
   
   public void clearSongList(){
      for(int i=(songList.size()-1);i>=0;i--){
         songList.remove(i);
      }
   }
    
}