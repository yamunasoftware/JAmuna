package lib;

@SuppressWarnings("unused")
public class Tests {
  /* TEST VARIABLES */

  // Test Arrays:
  private static double inputs[][] = {
    {0, 10}, {0, 10}, {0, 10}, {0, 10}, {0, 10},
    {100, 0}, {100, 0}, {100, 0}, {100, 0}, {100, 0}
  };
  private static double outputs[] = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2};
  private static double testInputs[] = {0, 10};

  // Algorithm Setup Variables:
  private static int inputLength = inputs[0].length, nodes = 100, epochs = 100;
  private static double outputLength = outputs[outputs.length-1];

  /* TEST METHODS */

  // Test Algorithm Method:
  public static double testAlgorithm() throws Exception {
    // Gets Output::
    Training training = new Training(inputLength, nodes, epochs, outputLength);
    Algorithm best = training.train(inputs, outputs);
    return best.getOutput(testInputs);
  }
}
