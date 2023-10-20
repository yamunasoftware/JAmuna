package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Network {
  // Network Setup Variables:
  private int inputSize, outputSize, epochs;
  private double learningRate;
  private int hiddenSizes[];

  // Network Arrays:
  private ArrayList<ArrayList<Neuron>> hiddenLayers = new ArrayList<ArrayList<Neuron>>();
  private ArrayList<Neuron> outputLayer = new ArrayList<Neuron>();

  /* EXTERNAL METHODS */

  // Main Constructor:
  public Network(int inputSize, int hiddenSizes[], int outputSize, double learningRate, int epochs) {
    // Sets the Constructor Values:
    this.inputSize = inputSize;
    this.hiddenSizes = hiddenSizes;
    this.outputSize = outputSize;
    this.learningRate = learningRate;
    this.epochs = epochs;
    initialize();
  }

  // Default Constructor:
  public Network() {}

  /* INTERNAL METHODS */

  // Initialize Network Method:
  private void initialize() {
    
  }
}
