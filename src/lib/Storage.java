package lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SuppressWarnings("unused")
public class Storage {
  /* STORAGE METHODS */

  // Store Network Method:
  public static void storeNetwork(Algorithm storeAlgorithm, String file) throws Exception {
    try {
      // Starts the Output Stream:
      FileOutputStream outputStream = new FileOutputStream(file);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

      // Writes to File:
      objectOutputStream.writeObject(storeAlgorithm);
      objectOutputStream.close();
    } 

    catch (IOException exception) {
      // Do Nothing!
    }
  }

  // Get Network Method:
  public static Algorithm getNetwork(String file) throws Exception {
    // Main Network:
    Algorithm storeAlgorithm = new Algorithm();
    
    try {
      // Starts the Input Stream:
      FileInputStream inputStream = new FileInputStream(file);
      ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

      // Reads the File:
      storeAlgorithm = (Algorithm)(objectInputStream.readObject());
      objectInputStream.close();
    }

    catch (IOException exception) {
      // Do Nothing!
    }

    // Returns the Network:
    return storeAlgorithm;
  }
}
