package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Algorithm {
  /* ALGORITHM VARIABLES */

  // Weights Array:
  private ArrayList<Double> weights = new ArrayList<Double>();
  private double outputs = 0;

  /* ALGORITHM SETUP METHODS */

  // Inputs Constructor:
  public Algorithm(int inputLength, double outputLength) {
    // Loop Variable:
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < inputLength) {
      // Adds to the Weights:
      weights.add(Math.random());

      turns++;
    }

    // Sets the Outputs:
    outputs = outputLength;
  }

  // Weights Constructor:
  public Algorithm(ArrayList<Double> newWeights) {
    // Sets the Weights:
    weights = newWeights;
  }

  // Object Constructor:
  public Algorithm(Algorithm existing) {
    try {
      // Sets the Values:
      weights = existing.getWeights();
      outputs = existing.getOutputs();
    }

    catch (Exception e) {
      // Prints Error:
      e.printStackTrace();
    }
  }

  // Constructor:
  public Algorithm() {
    // Setup!
  }

  /* ALGORITHM METHODS */

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
      return (activation(summation) * outputs);
    }

    else {
      // Returns the Default:
      return 0;
    }
  }

  // Mutate Weights Method:
  public ArrayList<Double> mutateWeights(double mutMin, double mutMax) throws Exception {
    // Loop Variables:
    ArrayList<Double> newWeights = new ArrayList<Double>();
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < weights.size()) {
      // Adds to the New Weights:
      double mutagen = ((Math.random() * (mutMax - mutMin)) + mutMin);
      newWeights.add(turns, (weights.get(turns) * mutagen));
      
      turns++;
    }

    // Returns the New Weights:
    return newWeights;
  }

  // Activation Method:
  private double activation(double input) throws Exception {
    // Sigmoid Activation:
    return 1 / (1 + Math.pow(Math.E, -input));
  }

  /* ALGORITHM UTILITY METHODS */

  // Get Weights Method:
  public ArrayList<Double> getWeights() throws Exception {
    // Returns the Weights:
    return weights;
  }

  // Set Weights Method:
  public void setWeights(ArrayList<Double> newWeights) throws Exception {
    // Sets the Weights:
    weights = newWeights;
  }

  // Get Outputs Method:
  public double getOutputs() throws Exception {
    // Returns the Outputs:
    return outputs;
  }

  // Set Outputs Method:
  public void setOutputs(double length) throws Exception {
    // Sets the Value:
    outputs = length;
  }
}