/**
 * Burak Aslan and Eli Abidor
 * Amortized.java
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Amortized {
  public static void main(String [] args) {
    ArrayList<Long> array = new ArrayList<>(2);
    long start, end = 0;
    start = System.nanoTime();
    array.add(System.nanoTime() - start);
    for (int x = 1; x < 3000000; x++) {
      array.add(System.nanoTime() - start);
    }

    try {
      FileWriter writer = new FileWriter("./data.csv");
      for (int x = 0; x < 3000000; x++) {
        if (x % 3000 == 0) {
          writer.append(x + ", " + array.get(x) + "\n");
        }
      }
      writer.flush();
  	  writer.close();
    }
    catch (IOException e) {
      System.out.println("Error");
    }

  }
}
