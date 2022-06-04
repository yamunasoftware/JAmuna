package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Training {
  /* TRAINING VARIABLES */

  // Training Algorithms Array:
  private ArrayList<Algorithm> algorithms = new ArrayList<Algorithm>();
  private int loops = 0;
  private double mutationMin = 0, mutationMax = 2;

  /* TRAINING METHODS */

  // Constructor:
  public Training(int inputLength, int nodes, int epochs, double outputLength, double mutMin, double mutMax) {
    // Loop Setup:
    loops = epochs;
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < nodes) {
      // Adds New Algorithms:
      algorithms.add(new Algorithm(inputLength, outputLength));

      turns++;
    }

    // Sets the Mutation Values:
    mutationMin = mutMin;
    mutationMax = mutMax;
  }

  // Training Method:
  public Algorithm train(double inputs[][], double expected[]) throws Exception {
    // Loop Variable:
    Algorithm best = new Algorithm();
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < inputs.length) {
      // Loop Variables:
      int counts = 0;

      // Loops through Array:
      secondLoop: while (counts < loops) {
        // Gets the Error:
        ArrayList<Double> errors = getError(inputs[turns], expected[turns]);
        best = getBest(errors);

        // Mutates:
        mutation(best);

        counts++;
      }

      turns++;
    }

    // Returns the Algorithm:
    return best;
  }

  /* TRAINING UTILITY METHODS */

  // Get Best Algorithm Method:
  private Algorithm getBest(ArrayList<Double> errors) throws Exception {
    // Checks the Case:
    if (errors.size() == algorithms.size()) {
      // Loop Variable:
      int turns = 0;
      int worstIndex = 0;
      double worstValue = 0;

      mainLoop: while (turns < errors.size()) {
        // Checks the Case:
        if (turns == 0) {
          // Sets the Worsts:
          worstIndex = turns;
          worstValue = errors.get(turns);
        }

        else {
          // Checks the Case:
          if (errors.get(turns) < worstValue) {
            // Sets the Worsts:
            worstIndex = turns;
            worstValue = errors.get(turns);
          }
        }

        turns++;
      }

      // Returns the Best Algorithm:
      return algorithms.get(worstIndex);
    }

    else {
      // Returns Default Algorithm:
      return new Algorithm();
    }
  }

  // Get Error Method:
  private ArrayList<Double> getError(double inputs[], double expected) throws Exception {
    // Loop Variables:
    ArrayList<Double> errors = new ArrayList<Double>();
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < algorithms.size()) {
      // Gets the Error:
      errors.add(Math.abs(expected - algorithms.get(turns).getOutput(inputs)));

      turns++;
    }

    // Returns the Errors:
    return errors;
  }

  // Mutation Method:
  private void mutation(Algorithm reference) throws Exception {
    // Loop Variable:
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < algorithms.size()) {
      // Checks the Case:
      if (turns == 0) {
        // Sets the Algorithm:
        algorithms.set(turns, reference);
      }

      else {
        // Sets the Algorithm:
        algorithms.set(turns, new Algorithm(reference.mutateWeights(mutationMin, mutationMax)));
      }

      turns++;
    }
  }

  /* TRAINING SETTINGS METHODS */

  // Set Mutation Minimum Method:
  public void setMutationMin(double min) throws Exception {
    // Sets the Value:
    mutationMin = min;
  }

  // Set Mutation Maximum Method:
  public void setMutationMax(double max) throws Exception {
    // Sets the Value:
    mutationMax = max;
  }
}
