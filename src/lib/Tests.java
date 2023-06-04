package lib;

@SuppressWarnings("unused")
public class Tests {
  /* TEST VARIABLES */

  // Test Arrays:
  private static double inputs[][] = {
    {1, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0},
    {0, 1}, {0, 1}, {0, 1}, {0, 1}, {0, 1}
  };
  private static double outputs[][] = {
    {1, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0}, 
    {0, 1}, {0, 1}, {0, 1}, {0, 1}, {0, 1}
  };
  private static double testInputs[] = {1, 0};

  // Training Setup Variables:
  private static int hiddenLayers[] = {2};
  private static int epochs = 5;
  private static double learningRate = 0.5;

  /* TEST METHODS */

  // Test Algorithm Method:
  public static double[] testAlgorithm() throws Exception {
    Network network = new Network(inputs[0].length, hiddenLayers, outputs[0].length, learningRate);
    network.train(inputs, outputs);
    return network.run(testInputs);
  }
}