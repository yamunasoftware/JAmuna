package lib;

public class Utilities {
  /* UTILITY METHODS */

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
}
