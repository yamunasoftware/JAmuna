package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Node {
  /* NODE SETUP */

  // Weights List:
  private ArrayList<Double> weights = new ArrayList<Double>();
  private double bias = 0, delta = 0;
  
  // Constructor:
  public Node(int inputs) {
    // Setup:
    this.bias = Math.random();
    
    // Loops through Inputs:
    for (int i = 0; i < inputs; i++) {
      // Sets the Weight:
      weights.add(Math.random());
    }
  }

  /* NODE METHODS */

  // Get Output Method:
  public double getOutput(double inputs[]) throws Exception {    
    // Checks the Case:
    if (inputs.length == weights.size()) {
      // Loop Variable:
      int turns = 0;
      double summation = 0;

      // Loops through Array:
      mainLoop: while (turns < inputs.length) {
        // Sets the Summation:
        summation += (inputs[turns] * weights.get(turns));

        turns++;
      }

      // Returns the Output:
      return sigmoid((summation += bias));
    }

    else {
      // Returns the Default:
      return 0;
    }
  }

  // Sigmoid Method:
  private double sigmoid(double input) throws Exception {
    // Sigmoid Activation:
    return 1 / (1 + Math.pow(Math.E, -input));
  }

  /* NODE UTILITY METHODS */

  // Get Weights Method:
  public ArrayList<Double> getWeights() throws Exception {
    // Returns the Weights:
    return weights;
  }

  // Get Bias Method:
  public double getBias() throws Exception {
    // Returns the Bias:
    return bias;
  }

  // Get Delta Method:
  public double getDelta() throws Exception {
    // Returns the Delta:
    return delta;
  }

  // Set Weights Method:
  public void setWeights(ArrayList<Double> newWeights) throws Exception {
    // Sets the Weights:
    weights = newWeights;
  }

  // Set Bias Method:
  public void setBias(double newBias) throws Exception {
    // Sets the Bias:
    bias = newBias;
  }

  // Set Delta Method:
  public void setDelta(double newDelta) throws Exception {
    // Sets the Bias:
    delta = newDelta;
  }
}