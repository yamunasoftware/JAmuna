package lib;

@SuppressWarnings("unused")
public class Tests {
  /* TEST VARIABLES */

  // Test Arrays:
  private static double inputs[][] = {
    {10, 10}, {10, 10}, {10, 10}, {10, 10}, {10, 10},
    {10, 20}, {10, 20}, {10, 20}, {10, 20}, {10, 20}
  };
  private static double outputs[] = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2};
  private static double testInputs[] = {10, 20};

  // Algorithm Setup Variables:
  private static int inputLength = inputs[0].length;
  private static int nodes = 1000, epochs = 10;

  // Algorithm Output Variables:
  private static double outputLength = outputs[outputs.length-1];
  private static double mutMin = 0.95, mutMax = 1.05;

  /* TEST METHODS */

  // Test Algorithm Method:
  public static double testAlgorithm() throws Exception {
    // Setup Training:
    Training training = new Training(inputLength, nodes, epochs, outputLength, mutMin, mutMax);
    Algorithm best = training.train(inputs, outputs);
    return best.getOutput(testInputs);
  }
}
