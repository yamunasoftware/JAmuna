package lib;

import java.util.ArrayList;
import java.util.Arrays;

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
  private static double testInputs[] = {0, 1};

  // Training Setup Variables:
  private static int hiddenLayers[] = {5, 7, 5};
  private static int epochs = 5;

  /* TEST METHODS */

  public static void main(String args[]) throws Exception {
    System.out.println(Arrays.toString(testAlgorithm().toArray()));
  }

  // Test Algorithm Method:
  public static ArrayList<Double> testAlgorithm() throws Exception {
    // Gets Output:
    Training training = new Training(inputs[0].length, hiddenLayers, outputs[0].length, epochs);
    training.train(inputs, outputs);
    return training.getNetwork().runNetwork(testInputs);
  }
}