package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Neuron {
  /* NEURON VARIABLES */

  // Neuron Variables:
  private ArrayList<Double> weights = new ArrayList<Double>();
  private Functions activationFunction = Functions.SIGMOID;
  private double mutationMinimum = 0, mutationMaximum = 1;

  /* NEURON METHODS */

  // Constructor:
  public Neuron(int inputsLength, double mutationMin, double mutationMax, Functions activation) {
    // Loop Variable:
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < inputsLength) {
      // Sets the Weight:
      weights.add(Math.random());
      
      turns++;
    }

    // Sets the Values:
    activationFunction = activation;
    mutationMinimum = mutationMin;
    mutationMaximum = mutationMax;
  }

  // Constructor:
  public Neuron() {
    // Instantiated!
  }

  // Mutate Weights Method:
  public void mutateWeights(ArrayList<Double> referenceWeights) throws Exception {
    // Loop Variable:
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < weights.size()) {
      // Mutates the Weight:
      double mutant = ((Math.random() * Math.abs(mutationMaximum - mutationMinimum)) + mutationMinimum);
      weights.set(turns, step(referenceWeights.get(turns) * mutant));
      
      turns++;
    }
  }

  // Get Output Method:
  public double getOutput(double inputs[]) throws Exception {
    // Loop Variables:
    double output = 0;
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < inputs.length) {
      // Gets the Summation:
      output += (weights.get(turns) * inputs[turns]);
      
      turns++;
    }

    // Checks the Case:
    if (activationFunction == Functions.SIGMOID) {
      // Returns the Activation:
      return sigmoid(output);
    }

    else if (activationFunction == Functions.RELU) {
      // Returns the Activation:
      return relu(output);
    }

    else {
      // Returns the Activation:
      return step(output);
    }
  }

  /* NEURON UTILITY METHODS */

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

  // Sigmoid Method:
  private double sigmoid(double input) throws Exception {
    // Returns the Sigmoid Activation:
    return 1 / (1 + (Math.pow(Math.E, -input)));
  }

  // ReLU Method:
  private double relu(double input) throws Exception {
    // Returns the ReLU Activation:
    return Math.max(0, input);
  }

  // Step Method:
  private double step(double input) throws Exception {
    // Checks the Case:
    if (input >= 1) {
      // Returns the Value:
      return 1;
    }

    else if (input < 1 && input > 0) {
      // Returns the Value:
      return input;
    }

    else {
      // Returns the Value:
      return 0;
    }
  }
}
