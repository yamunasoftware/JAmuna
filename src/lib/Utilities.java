package lib;

public class Utilities {
  /* CALCULATION METHODS */

  // Step Outputs Method:
  public double[] stepOutputs(double outputs[]) {
    // Steps Outputs:
    double newOutputs[] = new double[outputs.length];
    for (int i = 0; i < outputs.length; i++) {
      if (outputs[i] >= 0.5) {
        newOutputs[i] = 1;
      }

      else {
        newOutputs[i] = 0;
      }
    }
    return newOutputs;
  }
  
  /* ARRAY METHODS */

  // Add to Double Array:
  public double[] add(double[] array, double element) {
    // Adds the Element:
    double newArray[] = new double[array.length+1];
    for (int i = 0; i < array.length; i++) {
      newArray[i] = array[i];
    }
    newArray[newArray.length-1] = element;
    return newArray;
  }

  // Add to 2-D Double Array:
  public double[][] add(double[][] array, double[] element) {
    // Adds the Element:
    double newArray[][] = new double[array.length+1][];
    for (int i = 0; i < array.length; i++) {
      newArray[i] = array[i];
    }
    newArray[newArray.length-1] = element;
    return newArray;
  }

  // Add to 3-D Double Array:
  public double[][][] add(double[][][] array, double[][] element) {
    // Adds the Element:
    double newArray[][][] = new double[array.length+1][][];
    for (int i = 0; i < array.length; i++) {
      newArray[i] = array[i];
    }
    newArray[newArray.length-1] = element;
    return newArray;
  }

  // Remove from Double Array:
  public double[] remove(double[] array, int index) {
    // Removes Element:
    double newArray[] = new double[array.length-1];
    for (int i = 0; i < array.length; i++) {
      if (i < index) {
        newArray[i] = array[i];
      }

      else if (i > index) {
        newArray[i-1] = array[i];
      }
    }
    return newArray;
  }

  // Remove from 2-D Double Array:
  public double[][] remove(double[][] array, int index) {
    // Removes Element:
    double newArray[][] = new double[array.length-1][];
    for (int i = 0; i < array.length; i++) {
      if (i < index) {
        newArray[i] = array[i];
      }

      else if (i > index) {
        newArray[i-1] = array[i];
      }
    }
    return newArray;
  }

  // Remove from 3-D Double Array:
  public double[][][] remove(double[][][] array, int index) {
    // Removes Element:
    double newArray[][][] = new double[array.length-1][][];
    for (int i = 0; i < array.length; i++) {
      if (i < index) {
        newArray[i] = array[i];
      }

      else if (i > index) {
        newArray[i-1] = array[i];
      }
    }
    return newArray;
  }
}