package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Network {
  /* NETWORK VARIABLES */

  // Network Variables:
  private ArrayList<Neuron> hiddenLayer = new ArrayList<Neuron>();
  private ArrayList<Neuron> outputLayer = new ArrayList<Neuron>();

  /* NETWORK METHODS */

  // Constructor:
  public Network(int inputsLength, int hiddenLength, double mutationMin,
      double mutationMax, Functions activation) {
    try {
      // Loop Variables:
      int turns = 0;
      int counts = 0;

      // Loops through Array:
      mainLoop: while (turns < hiddenLength) {
        // Sets the Hidden Layers:
        hiddenLayer.add(new Neuron(inputsLength, mutationMin, mutationMax, activation));

        turns++;
      }

      // Checks the Case:
      if (hiddenLength != 0) {
        // Sets the Output Layer:
        outputLayer.add(new Neuron(hiddenLength, mutationMin, mutationMax, activation));
      }

      else {
        // Sets the Output Layer:
        outputLayer.add(new Neuron(inputsLength, mutationMin, mutationMax, activation));
      }
    }

    catch (Exception e) {
      // Do Nothing!
    }
  }

  // Constructor:
  public Network() {
    // Instantiated!
  }

  // Mutation Method:
  public void mutation(ArrayList<Neuron> referenceHiddenLayer, ArrayList<Neuron> referenceOutputLayer)
      throws Exception {
    // Loop Variables:
    int turns = 0;
    int counts = 0;

    // Loops through Array:
    mainLoop: while (turns < hiddenLayer.size()) {
      // Mutates:
      hiddenLayer.get(turns).mutateWeights(referenceHiddenLayer.get(turns).getWeights());

      turns++;
    }

    // Loops through Array:
    secondLoop: while (counts < outputLayer.size()) {
      // Mutates:
      outputLayer.get(counts).mutateWeights(referenceOutputLayer.get(counts).getWeights());

      counts++;
    }
  }

  // Get Error Method:
  public double getError(double outputs[], double expectedResults[]) throws Exception {
    // Loop Variables:
    double error = 0;
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < outputs.length) {
      // Gets the Errors:
      error += Math.pow((Math.abs(expectedResults[turns] - outputs[turns])), 2);

      turns++;
    }

    // Returns the Error:
    return error;
  }

  // Final Step Method:
  public double finalStep(double networkOutput[]) throws Exception {
    // Checks the Case:
    if (networkOutput[0] >= 0.5) {
      // Returns the Step Activation:
      return 1;
    }

    else {
      // Returns the Step Activation:
      return 0;
    }
  }

  // Run Network Method:
  public double[] runNetwork(double inputs[]) throws Exception {
    // Array Variables:
    double hiddenOutputs[] = new double[hiddenLayer.size()];
    double outputOutputs[] = new double[outputLayer.size()];

    // Loop Variables:
    int turns = 0;
    int counts = 0;

    // Checks the Case:
    if (hiddenLayer.size() != 0) {
      // Loops through Array:
      mainLoop: while (turns < hiddenOutputs.length) {
        // Gets the Outputs:
        hiddenOutputs[turns] = hiddenLayer.get(turns).getOutput(inputs);

        turns++;
      }
    }

    else {
      // Sets the Hidden Outputs:
      hiddenOutputs = inputs;
    }

    // Loops through Array:
    secondLoop: while (counts < outputOutputs.length) {
      // Gets the Outputs:
      outputOutputs[counts] = outputLayer.get(counts).getOutput(hiddenOutputs);

      counts++;
    }

    // Returns the Outputs:
    return outputOutputs;
  }

  // Transform Inputs Method:
  public double[] transformInputs(double inputs[], double max) throws Exception {
    // Loop Variables:
    double localInputs[] = inputs;
    int turns = 0;

    // Checks the Case:
    if (max != 0) {
      // Loops through Array:
      mainLoop: while (turns < localInputs.length) {
        // Transforms Inputs:
        localInputs[turns] /= max;

        turns++;
      }
    }

    // Returns the Inputs:
    return localInputs;
  }

  /* NETWORK UTILITY METHODS */

  // Get Hidden Layer Method:
  public ArrayList<Neuron> getHiddenLayer() throws Exception {
    // Returns the Hidden Layer:
    return hiddenLayer;
  }

  // Set Hidden Layer Method:
  public void setHiddenLayer(ArrayList<Neuron> newHiddenLayer) throws Exception {
    // Sets the Hidden Layer:
    hiddenLayer = newHiddenLayer;
  }

  // Get Output Layer Method:
  public ArrayList<Neuron> getOutputLayer() throws Exception {
    // Returns the Output Layer:
    return outputLayer;
  }

  // Set Output Layer Method:
  public void setOutputLayer(ArrayList<Neuron> newOutputLayer) throws Exception {
    // Sets the Output Layer:
    outputLayer = newOutputLayer;
  }
}