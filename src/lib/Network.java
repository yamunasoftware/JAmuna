package lib;

public class Network {
  // Network Setup Variables:
  private int inputSize, outputSize, epochs;
  private double learningRate;
  private int[] hiddenSizes;

  // Network Arrays:
  private double[] outputLayer;
  private double[][][] weights;
  private double[][] biases, hiddenLayers;

  /* EXTERNAL METHODS */

  // Default Constructor:
  public Network() {}

  // Main Constructor:
  public Network(int inputSize, int[] hiddenSizes, int outputSize, double learningRate, int epochs) {
    // Sets the Constructor Values:
    this.inputSize = inputSize;
    this.hiddenSizes = hiddenSizes;
    this.outputSize = outputSize;
    this.learningRate = learningRate;
    this.epochs = epochs;
    this.weights = new double[hiddenSizes.length + 1][][];
    this.biases = new double[hiddenSizes.length + 1][];
    this.hiddenLayers = new double[hiddenSizes.length][];
    this.outputLayer = new double[outputSize];
    initialize();
  }

  // Train Network Method:
  public void train(double inputs[][], double targets[][]) {
    // Loops through Epochs:
    for (int i = 0; i < epochs; i++) {
      for (int j = 0; j < inputs.length; j++) {
        // Training Process:
        double[] input = inputs[j];
        double[] target = targets[j];
        forwardPropagation(input);
        backwardPropagation(input, target);
      }
    }
  }

  // Runs the Network:
  public double[] run(double[] inputs) {
    // Returns Output:
    return forwardPropagation(inputs);
  }

  /* INTERNAL METHODS */

  // Initialize Network Method:
  private void initialize() {
    // Input Layer Initialization:
    weights[0] = new double[inputSize][hiddenSizes[0]];
    biases[0] = new double[hiddenSizes[0]];
    for (int i = 0; i < inputSize; i++) {
      for (int j = 0; j < hiddenSizes[0]; j++) {
        weights[0][i][j] = Math.random();
      }
    }
    for (int j = 0; j < hiddenSizes[0]; j++) {
      biases[0][j] = Math.random();
    }

    // Hidden Layers Loop:
    for (int k = 1; k < hiddenSizes.length; k++) {
      weights[k] = new double[hiddenSizes[k - 1]][hiddenSizes[k]];
      biases[k] = new double[hiddenSizes[k]];
      for (int i = 0; i < hiddenSizes[k - 1]; i++) {
        for (int j = 0; j < hiddenSizes[k]; j++) {
          weights[k][i][j] = Math.random();
        }
      }
      for (int j = 0; j < hiddenSizes[k]; j++) {
        biases[k][j] = Math.random();
      }
    }

    // Output Layer Initialization:
    weights[hiddenSizes.length] = new double[hiddenSizes[hiddenSizes.length - 1]][outputSize];
    biases[hiddenSizes.length] = new double[outputSize];
    for (int i = 0; i < hiddenSizes[hiddenSizes.length - 1]; i++) {
      for (int j = 0; j < outputSize; j++) {
        weights[hiddenSizes.length][i][j] = Math.random();
      }
    }
    for (int j = 0; j < outputSize; j++) {
      biases[hiddenSizes.length][j] = Math.random();
    }
  }

  // Forward Propagation Method:
  private double[] forwardPropagation(double[] inputs) {
    for (int k = 0; k < hiddenSizes.length; k++) {
      hiddenLayers[k] = new double[hiddenSizes[k]];
      if (k == 0) {
        for (int j = 0; j < hiddenSizes[k]; j++) {
          double sum = biases[k][j];
          for (int i = 0; i < inputSize; i++) {
            sum += inputs[i] * weights[k][i][j];
          }
          hiddenLayers[k][j] = sigmoid(sum);
        }
      } 
      
      else {
        for (int j = 0; j < hiddenSizes[k]; j++) {
          double sum = biases[k][j];
          for (int i = 0; i < hiddenSizes[k - 1]; i++) {
            sum += hiddenLayers[k - 1][i] * weights[k][i][j];
          }
          hiddenLayers[k][j] = sigmoid(sum);
        }
      }
    }

    for (int j = 0; j < outputSize; j++) {
      double sum = biases[hiddenSizes.length][j];
      for (int i = 0; i < hiddenSizes[hiddenSizes.length - 1]; i++) {
        sum += hiddenLayers[hiddenSizes.length - 1][i] * weights[hiddenSizes.length][i][j];
      }
      outputLayer[j] = sigmoid(sum);
    }

    return outputLayer;
  }

  // Back Propagation Method:
  private void backwardPropagation(double[] inputs, double[] targets) {
    double[][] outputErrors = new double[hiddenSizes.length + 1][];
    double[][] hiddenErrors = new double[hiddenSizes.length][];

    outputErrors[hiddenSizes.length] = new double[outputSize];
    for (int j = 0; j < outputSize; j++) {
      double output = outputLayer[j];
      outputErrors[hiddenSizes.length][j] = (targets[j] - output) * sigmoidDerivative(output);
    }

    for (int k = hiddenSizes.length - 1; k >= 0; k--) {
      hiddenErrors[k] = new double[hiddenSizes[k]];
      for (int j = 0; j < hiddenSizes[k]; j++) {
        double error = 0.0;
        if (k == hiddenSizes.length - 1) {
          for (int i = 0; i < outputSize; i++) {
            error += outputErrors[k + 1][i] * weights[k + 1][j][i];
          }
        } else {
          for (int i = 0; i < hiddenSizes[k + 1]; i++) {
            error += hiddenErrors[k + 1][i] * weights[k + 1][j][i];
          }
        }
        hiddenErrors[k][j] = error * sigmoidDerivative(hiddenLayers[k][j]);
      }
    }

    for (int k = 0; k < hiddenSizes.length + 1; k++) {
      for (int i = 0; i < (k == 0 ? inputSize : hiddenSizes[k - 1]); i++) {
        for (int j = 0; j < (k == hiddenSizes.length ? outputSize : hiddenSizes[k]); j++) {
          double gradient = (k == hiddenSizes.length ? outputErrors[k][j] : hiddenErrors[k][j]) *
              (k == 0 ? inputs[i] : hiddenLayers[k - 1][i]);
          weights[k][i][j] += learningRate * gradient;
        }
      }
      for (int j = 0; j < (k == hiddenSizes.length ? outputSize : hiddenSizes[k]); j++) {
        double gradient = (k == hiddenSizes.length ? outputErrors[k][j] : hiddenErrors[k][j]);
        biases[k][j] += learningRate * gradient;
      }
    }
  }

  // Sigmoid Activation Function:
  private double sigmoid(double x) {
    // Returns Activation:
    return 1 / (1 + Math.exp(-x));
  }

  // Sigmoid Activation Derivative Function:
  private double sigmoidDerivative(double x) {
    // Returns Derivative:
    return sigmoid(x) * (1 - sigmoid(x));
  }
}
