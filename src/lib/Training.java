package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Training {
  /* TRAINING SETUP */

  // Training Variables:
  private Network network = new Network();
  private int loops = 0;

  // Constructor:
  public Training(int inputs, int hidden[], int outputs, int epochs) {
    // Setup:
    loops = epochs;
    network = new Network(inputs, hidden, outputs);
  }

  /* TRAINING METHODS */

  // Training Method:
  public void train(double inputs[][], double expected[][]) throws Exception {
    // Loops through Training:
    for (int i = 0; i < loops; i++) {
      for (int j = 0; j < inputs.length; j++) {
      
      }
    }
  }

  // Update Weights Method:
  private void updateWeights() throws Exception {

  }

  /* TRAINING UTILITY METHODS */

  // Get Loops Method:
  public int getLoops() throws Exception {
    // Returns:
    return loops;
  }

  // Set Loops Method:
  public void setLoops(int epochs) throws Exception {
    // Sets:
    loops = epochs; 
  }

  // Get Network Method:
  public Network getNetwork() throws Exception {
    // Returns:
    return network;
  }

  // Set Network Method:
  public void setNetwork(Network network) throws Exception {
    // Sets:
    this.network = network;
  }
}