package lib;

@SuppressWarnings("unused")
public class Tests {
  /* TEST VARIABLES */

  // Test Arrays:
  private static double inputs[][] = {
    {10, 10, 10},
    {20, 20, 20},
    {10, 10, 10}
  };
  private static double outputs[][] = {
    {0, 1},
    {1, 0},
    {0, 1}
  };
  private static double testInputs[] = {10, 10, 10};

  // Test Settings:
  private static int networks = 3, inputLength = inputs[0].length, hiddenLength = 3, 
    outputLength = outputs[0].length;
  private static double mutMin = 0.9, mutMax = 1.1;
  private static Functions activation = Functions.SIGMOID;

  /* TEST METHODS */

  // Test Algorithm Method:
  public static double[] testAlgorithm() throws Exception {
    // Object Instantiation:
    Dimension dimension = new Dimension(networks, inputLength, hiddenLength, outputLength, mutMin, 
      mutMax, activation);

    // Training:
    Network best = dimension.train(inputs, outputs);
    return best.runNetwork(testInputs);
  }
}