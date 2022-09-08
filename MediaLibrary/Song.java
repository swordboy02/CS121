public class Song {

   private String title;
   private String album;
   private String artist;
   private double playTime;
   
   public Song(String title, String artist, double playTime){
      this.title = title;
      this.album = "";
      this.artist = artist; 
      this.playTime = playTime;
   }
   
   public Song(String title, String album, String artist, double playTime){
      this.title = title;
      this.album = album;
      this.artist = artist; 
      this.playTime = playTime;
   }
   
   public String getTitle(){
      return title;
   }
   
   public String getAlbum(){
      return album;
   }
   
   public String getArtist(){
      return artist;
   }
   
   public double getPlayTime(){
      return playTime;
   }

   public String toString(){
      return title+", "+album+", "+artist+", "+playTime;
   }
}