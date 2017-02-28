import java.io.*;
import java.util.*;

class CSVTOJSON {
  public static ArrayList<String> linesRead = new ArrayList<String>();

  public static String getInput(String aMessage) {
    System.out.print(aMessage);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String returnString = null;
    try {
      returnString = br.readLine();
    } catch(IOException e) {
      System.out.println("Error 10X: IOException Error - bad input.");
    }
    return returnString;
  }

  public static void readFile(String aFileName) {
    String line = null;
    try {
      BufferedReader br  = new BufferedReader(new FileReader(aFileName));
      while((line = br.readLine()) != null) {
        linesRead.add(line);
      }
    } catch(FileNotFoundException e) {
      System.out.println("Bad error.");
    } catch(IOException e) {
      System.out.println("File not found error.");
    }
  }

  public static String toJSON() {
    String content = null;
    String[] headers = linesRead.get(0).split(",");
    int end = linesRead.size();
    content = "[";
    for(int i = 1; i < end; i++) {
      String[] currentLineContents = linesRead.get(i).split(",");
      content += "{";
      for(int j = 0; j < headers.length; j++) {
        content += "\"" + headers[j] + "\"" + ": " + "\"" + currentLineContents[j] + "\"";
        if(j != currentLineContents.length - 1) {
          content += ", ";
        }
      }
      content += "}";
      if(i != end - 1) {
        content += ",";
      }
    }
    content += "]";
    return content;
  }

  public static void writeToFile(String jsonString, String exportName) {
    try {
      PrintStream out = new PrintStream(new FileOutputStream(exportName));
      out.print(jsonString);
    } catch(IOException e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    readFile(args[0]);
    writeToFile(toJSON(), args[1]);
    System.out.println("Conversion completed. File saved as " + args[1]);
  }
}
