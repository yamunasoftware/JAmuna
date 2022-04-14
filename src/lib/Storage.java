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
  public static void storeNetwork(Network storeNetwork, String file) throws Exception {
    try {
      // Starts the Output Stream:
      FileOutputStream outputStream = new FileOutputStream(file);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

      // Writes to File:
      objectOutputStream.writeObject(storeNetwork);
      objectOutputStream.close();
    } 

    catch (IOException exception) {
      // Do Nothing!
    }
  }

  // Get Network Method:
  public static Network getNetwork(String file) throws Exception {
    // Main Network:
    Network storeNetwork = new Network();
    
    try {
      // Starts the Input Stream:
      FileInputStream inputStream = new FileInputStream(file);
      ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

      // Reads the File:
      storeNetwork = (Network)(objectInputStream.readObject());
      objectInputStream.close();
    }

    catch (IOException exception) {
      // Do Nothing!
    }

    // Returns the Network:
    return storeNetwork;
  }
}