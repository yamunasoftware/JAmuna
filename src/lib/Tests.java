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
  private static int epochs = 1000;
  private static double learningRate = 0.5;

  /* TEST METHODS */

  // Test Network Method:
  public static void testNetwork() throws Exception {
    
  }
}