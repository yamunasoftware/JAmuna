package lib;

import java.util.ArrayList;
import java.util.Arrays;

import lib.Node.Activation;

@SuppressWarnings("unused")
public class Tests {
  /* TEST VARIABLES */

  // Test Arrays:
  private static double inputs[][] = {
    {1, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0},
    {0, 1}, {0, 1}, {0, 1}, {0, 1}, {0, 1}
  };
  private static double outputs[][] = {{1, 0}, {1, 0}, {1, 0}, {1, 0}, {1, 0}, {0, 1}, {0, 1}, {0, 1}, {0, 1}, {0, 1}};
  private static double testInputs[] = {0, 1};

  // Training Setup Variables:
  private static int hiddenLayers[] = {5, 7, 5};
  private static int inputLength = inputs[0].length, outputLength = outputs[0].length, children = 100, epochs = 1;
  private static double min = 0.9, max = 1.1;
  private static Activation function = Activation.RELU;

  /* TEST METHODS */

  public static void main(String args[]) throws Exception {
    System.out.println(Arrays.toString(testTraining().toArray()));
  }

  // Test Training Method:
  public static ArrayList<Double> testTraining() throws Exception {
    // Gets Output:
    Training training = new Training(inputLength, hiddenLayers, outputLength, children, epochs, min, max, function);
    Network best = training.train(inputs, outputs);
    return best.runNetwork(testInputs);
  }
}
