package lib;

@SuppressWarnings("unused")
public class Tests {
  /* TEST VARIABLES */

  // Test Arrays:
  private static double inputs[][] = {
    {35}, {22}, {41}, {15}, {29}, {11}, {37}, {48},
    {102}, {110}, {125}, {100}, {107}, {122}, {118}, {116}
  };
  private static double outputs[][] = {
    {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0},
    {1}, {1}, {1}, {1}, {1}, {1}, {1}, {1}
  };
  private static double testInputs[] = {110};

  // Test Settings:
  private static int networks = 10000, inputLength = inputs[0].length, hiddenLength = 0, epochs = 100;
  private static double mutMin = 0.95, mutMax = 1.05, max = 100;
  private static Functions activation = Functions.SIGMOID;

  /* TEST METHODS */

  // Test Algorithm Method:
  public static double testAlgorithm() throws Exception {
    // Training Test:
    Dimension dimension = new Dimension(networks, inputLength, hiddenLength, mutMin, 
      mutMax, activation);
    Network best = dimension.train(dimension.transformInputs(inputs, max), outputs, epochs);
    return best.finalStep(best.runNetwork(best.transformInputs(testInputs, max)));
  }
}