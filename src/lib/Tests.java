package lib;

@SuppressWarnings("unused")
public class Tests {
  /* TEST VARIABLES */

  // Test Arrays:
  private static double inputs[][] = {
    {35}, {22}, {41}, {15}, {29}, {11}, {37}, {48},
    {92}, {80}, {77}, {62}, {53}, {64}, {55}, {97}
  };
  private static double outputs[][] = {
    {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0},
    {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}
  };
  private static double testInputs[] = {40};

  // Test Settings:
  private static int networks = 10000, inputLength = inputs[0].length, hiddenLength = 0, 
    outputLength = outputs[0].length, epochs = 100;
  private static double mutMin = 0.95, mutMax = 1.05, outThreshold = 0.6, max = 100;
  private static Functions activation = Functions.SIGMOID;

  /* TEST METHODS */

  // Test Algorithm Method:
  public static double[] testAlgorithm() throws Exception {
    // Object Instantiation:
    Dimension dimension = new Dimension(networks, inputLength, hiddenLength, outputLength, mutMin, 
      mutMax, outThreshold, activation);

    // Training:
    Network best = dimension.train(dimension.transformInputs(inputs, max), outputs, epochs);
    return best.runNetwork(best.transformInputs(testInputs, max));
  }
}