package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Node {
  /* NODE SETUP */

  // Activation Enum:
  public enum Activation {
    SIGMOID,
    RELU
  }

  // Weights List:
  private ArrayList<Double> weights = new ArrayList<Double>();
  private double bias = 0;
  private Activation function = Activation.RELU;
  
  // Constructor:
  public Node(int inputs, double bias, Activation function) {
    // Setup:
    this.function = function;
    this.bias = bias;
    
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

      // Checks the Case:
      if (function == Activation.RELU) {
        // Returns the Output:
        return relu((summation + bias));
      }

      else {
        // Returns the Output:
        return sigmoid((summation + bias));
      }
    }

    else {
      // Returns the Default:
      return 0;
    }
  }

  // Mutate Weights Method:
  public ArrayList<Double> mutateWeights(double min, double max) throws Exception {
    // Loop Variables:
    ArrayList<Double> newWeights = new ArrayList<Double>();
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < weights.size()) {
      // Adds to the New Weights:
      double mutagen = ((Math.random() * (max - min)) + min);
      bias *= ((Math.random() * (max - min)) + min);
      newWeights.add(turns, (weights.get(turns) * mutagen));
      
      turns++;
    }

    // Returns the New Weights:
    return newWeights;
  }

  /* ACTIVATION FUNCTIONS */

  // Sigmoid Method:
  private double sigmoid(double input) throws Exception {
    // Sigmoid Activation:
    return 1 / (1 + Math.pow(Math.E, -input));
  }

  // ReLU Method:
  private double relu(double input) throws Exception {
    // ReLU Activation:
    return Math.max(0, input);
  }

  /* NODE UTILITY METHODS */

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
}