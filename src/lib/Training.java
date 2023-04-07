package lib;

import java.util.ArrayList;
import lib.Node.Activation;

@SuppressWarnings("unused")
public class Training {
  /* TRAINING SETUP */

  // Training Variables:
  private ArrayList<Network> networks = new ArrayList<Network>();
  private int loops = 0;
  private double min = 0, max = 0; 

  // Constructor:
  public Training(int inputs, int hidden[], int outputs, int children, int epochs, double min, double max, Activation function) {
    // Setup:
    loops = epochs;
    this.min = min;
    this.max = max;

    // Loops through Children:
    for (int i = 0; i < children; i++) {
      // Adds to List:
      networks.add(new Network(inputs, hidden, outputs, function));
    }
  }

  /* TRAINING METHODS */

  // Training Method:
  public Network train(double inputs[][], double expected[][]) throws Exception {
    // Loop Variable:
    Network best = new Network();
    
    // Loops through Training:
    for (int i = 0; i < inputs.length; i++) {
      for (int j = 0; j < loops; j++) {
        // Error and Mutation:
        ArrayList<Double> errors = getErrors(inputs[i], expected[i]);
        best = getBest(errors);
        mutation(best);
      }
    }

    // Returns the Algorithm:
    return best;
  }

  // Get Error Method:
  private ArrayList<Double> getErrors(double inputs[], double expected[]) throws Exception {
    // Error List:
    ArrayList<Double> errors = new ArrayList<Double>();
    
    for (int i = 0; i < networks.size(); i++) {
      // Gets the Error:
      errors.add(networks.get(i).getError(networks.get(i).runNetwork(inputs), expected));
    }

    // Returns the Errors:
    return errors;
  }

  // Get Best Algorithm Method:
  private Network getBest(ArrayList<Double> errors) throws Exception {
    // Checks the Case:
    if (errors.size() == networks.size()) {
      // Index Variables:
      int worstIndex = 0;
      double worstValue = 0;

      for (int i = 0; i < errors.size(); i++) {
        // Checks the Case:
        if (i == 0) {
          // Sets the Worsts:
          worstIndex = i;
          worstValue = errors.get(i);
        }

        else {
          // Checks the Case:
          if (errors.get(i) < worstValue) {
            // Sets the Worsts:
            worstIndex = i;
            worstValue = errors.get(i);
          }
        }
      }

      // Returns the Best:
      return networks.get(worstIndex);
    }

    else {
      // Returns Default:
      return new Network();
    }
  }

  // Mutation Method:
  private void mutation(Network reference) throws Exception {
    // Mutation Loop:
    for (int i = 0; i < networks.size(); i++) {
      // Sets Network:
      networks.set(i, reference);

      // Checks the Case:
      if (i != 0) {
        // Sets the Mutation:
        networks.get(i).mutateNetwork(min, max);
      }
    }
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

  // Get Mutation Data Method:
  public double[] getMutationData() throws Exception {
    // Returns:
    double data[] = {min, max};
    return data;
  }

  // Set Mutation Data Method:
  public void setMutationData(double min, double max) throws Exception {
    // Sets:
    this.min = min;
    this.max = max;
  }

  // Get Networks Method:
  public ArrayList<Network> getNetworks() throws Exception {
    // Returns:
    return networks;
  }

  // Set Networks Method:
  public void setNetworks(ArrayList<Network> networks) throws Exception {
    // Sets:
    this.networks = networks;
  }
}
