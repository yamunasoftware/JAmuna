package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Network {
  /* NETWORK SETUP */

  // Layer Variables:
  private ArrayList<Node> outputLayer = new ArrayList<Node>();
  private ArrayList<ArrayList<Node>> hiddenLayers = new ArrayList<ArrayList<Node>>();
  
  // Default Constructor:
  public Network() {}
  
  // Constructor:
  public Network(int inputs, int hidden[], int outputs) {
    // Last Hidden Layer:
    int last = 0;
    
    // Loops through Hidden Layers:
    for (int i = 0; i < hidden.length; i++) {
      // Layer Variable:
      ArrayList<Node> layer = new ArrayList<Node>();

      // Loops through Layer:
      for (int j = 0; j < hidden[i]; j++) {
        // Checks the Case:
        if (i == 0) {
          // Sets the Node:
          layer.add(new Node(inputs));
        }

        else {
          // Sets the Node:
          layer.add(new Node(hidden[i-1]));
        }
      }

      // Sets the Values:
      hiddenLayers.add(layer);
      last = hidden[i];
    }

    // Loops through Outputs:
    for (int i = 0; i < outputs; i++) {
      // Adds to the List:
      outputLayer.add(new Node(last));
    }
  }

  /* NETWORK METHODS */

  // Run Network Method:
  public ArrayList<Double> runNetwork(double inputs[]) throws Exception {
    // Layer Lists:
    ArrayList<Double> outputs = new ArrayList<Double>();
    ArrayList<Double> layerInput = new ArrayList<Double>();
    ArrayList<Double> layerOutput = new ArrayList<Double>();
      
    // Converts Inputs:
    for (int i = 0; i < inputs.length; i++) {
      // Adds to the Layers:
      layerInput.add(inputs[i]);
    }
      
    // Loops through Layers:
    for (int i = 0; i < hiddenLayers.size(); i++) {
      // Gets the Layer Output:
      layerOutput = getHiddenLayerOutputs(layerInput, i);
      layerInput = layerOutput;
    }

    // Return the Outputs:
    outputs = getOutputLayerOutputs(layerOutput);
    return outputs;
  }

  // Get Error Method:
  public double getError(ArrayList<Double> outputs, double expected[]) throws Exception {
    // Error Variable:
    double error = 0;
    
    // Checks the Case:
    if (expected.length == outputs.size()) {
      // Loops through Outputs:
      for (int i = 0; i < outputs.size(); i++) {
        // Sums:
        error += Math.abs(expected[i] - outputs.get(i));
      }

      // Returns the Error:
      return error;
    }

    else {
      // Returns the Error:
      return error;
    }
  }

  // Transfer Derivative Method:
  private double transferDerivative(double output) throws Exception {
    // Returns:
    return output * (1-output);
  }

  /* NETWORK LAYER METHODS */

  // Get Hidden Layer Outputs Method:
  private ArrayList<Double> getHiddenLayerOutputs(ArrayList<Double> inputs, int index) throws Exception {
    // Outputs List:
    ArrayList<Double> outputs = new ArrayList<Double>();
    double local[] = new double[inputs.size()];

    // Loops through Inputs:
    for (int i = 0; i < inputs.size(); i++) {
      // Sets the Local:
      local[i] = inputs.get(i);
    }
    
    // Loops through Layer:
    for (int i = 0; i < hiddenLayers.get(index).size(); i++) {
      // Gets the Outputs:
      outputs.add(hiddenLayers.get(index).get(i).getOutput(local));
    }

    // Returns the Outputs:
    return outputs;
  }

  // Get Output Layer Outputs Method:
  private ArrayList<Double> getOutputLayerOutputs(ArrayList<Double> inputs) throws Exception {
    // Outputs List:
    ArrayList<Double> outputs = new ArrayList<Double>();
    double local[] = new double[inputs.size()];

    // Loops through Inputs:
    for (int i = 0; i < inputs.size(); i++) {
      // Sets the Local:
      local[i] = inputs.get(i);
    }

    // Loops through Layer:
    for (int i = 0; i < outputLayer.size(); i++) {
      // Gets the Outputs:
      outputs.add(outputLayer.get(i).getOutput(local));
    }

    // Returns the Outputs:
    return outputs;
  }

  /* NETWORK UTILITY METHODS */

  // Get Output Layer Method:
  public ArrayList<Node> getOutputLayer() throws Exception {
    // Returns:
    return outputLayer;
  }

  // Set Output Layer Method:
  public void setOutputLayer(ArrayList<Node> layer) throws Exception {
    // Sets:
    outputLayer = layer;
  }

  // Get Hidden Layers Method:
  public ArrayList<ArrayList<Node>> getHiddenLayers() throws Exception {
    // Returns:
    return hiddenLayers;
  }

  // Set Hidden Layers Method:
  public void setHiddenLayers(ArrayList<ArrayList<Node>> layers) throws Exception {
    // Sets:
    hiddenLayers = layers;
  }
}