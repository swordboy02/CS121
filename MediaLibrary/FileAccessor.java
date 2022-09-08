import java.util.Scanner;
import java.io.*;

public abstract class FileAccessor{
  protected String fileName; 
  Scanner scan;
  
  public FileAccessor(String fName) throws IOException{
    fileName = fName;
    scan = new Scanner(new FileReader(fileName));
  }
  
  public void processFile() { 
    while(scan.hasNext()){
      processLine(scan.nextLine());
    }
    scan.close();
  }
  
  public abstract void processLine(String line);
  
  public void writeToFile(String data, String fileName) throws IOException{
		PrintWriter pw = new PrintWriter(fileName);
      pw.print(data);
      pw.close();
   }
   
}
