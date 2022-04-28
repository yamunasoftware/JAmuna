# JAmuna

Java Supervised Machine Learning Library Using Genetic Algorithms to Learn

## Overview

The JAmuna library is a machine learning library that is built from using neural networks to get better results from you testing. The library uses a special method to learn where it creates multiple neural networks and evolves to a better and better network with added data. The more that the data is aggregated and used to train this system, the better the resulting network will be. This method is a little more computationally expensive when compared to the traditional Back-Propagation Learning; however, the resulting training process is much easier to visualize and achieve great performance as well.

The key is to keep all of your inputs as arrays with the same length to avoid any bugs during the testing process, and for further details you can see our "Tests.java" class for how to train and run the network. The library is modular and each piece of the library combines into a bigger whole, which is only possible because of the segmented Object-Oriented approach that we took to build this library. To start with, the "Functions.java" class is just an enum containing some key activation methods that are used in the training and running process. The "Storage.java" class is used to save and open stored networks that are trained and used for future running or training.

The base of the whole system is the "Neuron.java" class which is a single node in the network, and this class includes basic neural network methods such as activation and summation methods. Furthermore, this class feeds into the "Network.java" class which uses the individual neurons to take the input layer and feed it into neurons in the hidden and output layers. This produces a much cleaner and faster implementation for this library. Finally, the "Dimension.java" class is a class that has a "dimension" of planar networks which can be evaluated and mutated to achieve the best network possible.

The output of this machine learning algorithm is a binary detector. This means that the output node can only distinguish between two different classes of data. While this is a limitation of the system, the usage of a few different networks can solve this problem by comparing between multiple classes in sets of two. This is more computationally expensive, but we added this feature to make the system more responsive and accurate.

## Installation

The installation for this library is listed below either using the Maven or Gradle build tools. Both of these tools are ubiquitous in the Jaa build environment world. The other option for using this library in your code is to use this as a module or use the included jar file found in the repository. This can be used locally, but updating to newer versions is much harder in build environments without using the Maven or Gradle implementation. Lastly, it is important to us that you pay attention to the version number when building your project with our library.

Maven:
```XML
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>com.github.yamunasoftware</groupId>
    <artifactId>JAmuna</artifactId>
    <version>Tag</version>
  </dependency>
</dependencies>
```

Gradle:
```Java
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}

dependencies {
  implementation 'com.github.yamunasoftware:JAmuna:Tag'
}
```