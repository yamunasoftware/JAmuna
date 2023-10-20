package lib;

@SuppressWarnings("unused")
public class Neuron {
  // Learning Arrays:
  private double weights[];
  private double bias;

  /* NEURON METHODS */
  
  // Constructor:
  public Neuron(int size) {
    weights = new double[size];
    init();
  }

  // Output Method:
  public double output(int inputs[]) {
    // Propagation Loop:
    double summation = bias;
    for (int i = 0; i < weights.length; i++) {
      summation += (weights[i] * inputs[i]);
    }
    return sigmoid(summation);
  }

  // Initialization Method:
  private void init() {
    // Init Loop:
    for (int i = 0; i < weights.length; i++) {
      weights[i] = Math.random();
    }
    bias = Math.random();
  }

  /* ACTIVATION FUNCTIONS */

  // Sigmoid Function:
  private double sigmoid(double x) {
    // Returns Activation:
    return 1 / (1 + Math.exp(-x));
  }

  // Sigmoid Derivative:
  private double sigmoidDerivative(double x) {
    // Returns Derivative:
    return sigmoid(x) * (1 - sigmoid(x));
  }
}
