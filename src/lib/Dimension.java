package lib;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Dimension {
  /* DIMENSION VARIABLES */

  // Dimension Variables:
  private ArrayList<Network> networks = new ArrayList<Network>();
  private Network bestNetwork = new Network();

  /* DIMENSION METHODS */

  // Constructor:
  public Dimension(int networksLength, int inputsLength, int hiddenLength, int outputsLength, 
    double mutationMin, double mutationMax, Functions activation) {
    // Loop Variable:
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < networksLength) {
      // Adds the Network:
      networks.add(new Network(inputsLength, hiddenLength, outputsLength, mutationMin, mutationMax, activation));

      turns++;
    }
  }

  // Constructor:
  public Dimension() {
    // Instantiated!
  }

  // Train Method:
  public Network train(double allInputs[][], double allExpectedResults[][]) throws Exception {
    // Loop Variables:
    int turns = 0;

    // Checks the Case:
    if (bestNetwork.getHiddenLayer().size() != 0 
      && bestNetwork.getOutputLayer().size() != 0) {
      // Loop Variable:
      int loops = 0;

      // Loops through Array:
      mainLoop: while (loops < networks.size()) {
        // Mutates:
        networks.get(loops).mutation(bestNetwork.getHiddenLayer(), bestNetwork.getOutputLayer());

        loops++;
      }
    }

    // Loops through Array:
    mainLoop: while (turns < allInputs.length) {
      // Loop Variables:
      int counts = 0;
      int moves = 0;
      double errors[] = new double[networks.size()];

      // Loops through Array:
      secondLoop: while (counts < networks.size()) {
        // Sets the Error:
        double outputs[] = networks.get(counts).runNetwork(allInputs[turns]);
        double error = networks.get(counts).getError(outputs, allExpectedResults[turns]);
        errors[counts] = error;

        counts++;
      }

      // Gets the Best Network:
      bestNetwork = getBest(errors);

      // Loops through Array:
      thirdLoop: while (moves < networks.size()) {
        // Mutates the Array:
        networks.get(moves).mutation(bestNetwork.getHiddenLayer(), bestNetwork.getOutputLayer());

        moves++;
      }
      
      turns++;
    }

    // Returns the Best Network:
    return bestNetwork;
  }

  // Get Best Network Method:
  private Network getBest(double errors[]) throws Exception {
    // Loop Variables:
    int turns = 0, worstIndex = 0;
    double worstError = 0;

    // Loops through Array:
    mainLoop: while (turns < errors.length) {
      // Checks the Case:
      if (turns == 0) {
        // Sets the Worsts:
        worstError = errors[turns];
      }

      else {
        // Checks the Case:
        if (errors[turns] <= worstError) {
          // Sets the Worsts:
          worstError = errors[turns];
          worstIndex = turns;
        }
      }
      
      turns++;
    }

    // Returns the Network:
    return networks.get(worstIndex);
  }

  /* DIMENSION UTILITY METHODS */

  // Get Best Network Method:
  public Network getBestNetwork() throws Exception {
    // Returns the Network:
    return bestNetwork;
  }

  // Set Best Network Method:
  public void setBestNetwork(Network network) throws Exception {
    // Sets the Best Network:
    bestNetwork = network;
  }
}