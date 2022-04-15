package lib;

import java.util.Arrays;

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
  private static double testInputs[] = {10};

  // Test Settings:
  private static int networks = 10, inputLength = inputs[0].length, hiddenLength = 0, 
    outputLength = outputs[0].length, epochs = 1;
  private static double mutMin = 0, mutMax = 2;
  private static Functions activation = Functions.SIGMOID;

  /* TEST METHODS */

  // Test Algorithm Method:
  public static String testAlgorithm() throws Exception {
    // Object Instantiation:
    Dimension dimension = new Dimension(networks, inputLength, hiddenLength, outputLength, mutMin, 
      mutMax, activation);

    // Training:
    Network best = dimension.train(inputs, outputs, epochs);
    return Arrays.toString(best.runNetwork(testInputs));
  }
}