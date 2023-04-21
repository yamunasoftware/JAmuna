package lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SuppressWarnings("unused")
public class Storage {
  /* STORAGE METHODS */
  
  // Constructor:
  public Storage() {}

  // Store Network Method:
  public static void storeNetwork(Network store, String file) throws Exception {
    try {
      // Starts the Output Stream:
      FileOutputStream outputStream = new FileOutputStream(file);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

      // Writes to File:
      objectOutputStream.writeObject(store);
      objectOutputStream.close();
    } 

    catch (IOException exception) {
      // Print:
      exception.printStackTrace();
    }
  }

  // Get Network Method:
  public static Network getNetwork(String file) throws Exception {
    // Main Network:
    Network store = new Network();
    
    try {
      // Starts the Input Stream:
      FileInputStream inputStream = new FileInputStream(file);
      ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

      // Reads the File:
      store = (Network)(objectInputStream.readObject());
      objectInputStream.close();
    }

    catch (IOException exception) {
      // Print:
      exception.printStackTrace();
    }

    // Returns the Network:
    return store;
  }
}