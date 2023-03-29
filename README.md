# JAmuna

Java Supervised Machine Learning Library Using Genetic Algorithms to Learn

## Overview

The JAmuna library is a machine learning library that is built from using neural networks to get better results from you testing. The library uses a special method to learn where it creates multiple neural networks and evolves to a better and better network with added data. The more that the data is aggregated and used to train this system, the better the resulting network will be. This method is a little more computationally expensive when compared to the traditional Back-Propagation Learning; however, the resulting training process is much easier to visualize and achieve great performance as well. The library is designed to handle classification and class-based machine learning tasks, which is perfect for many applications of the technology.

The key is to keep all of your inputs as arrays with the same length to avoid any bugs during the testing process, and for further details you can see our "Tests.java" class for how to train and run the network. The library is modular and each piece of the library combines into a bigger whole, which is only possible because of the segmented Object-Oriented approach that we took to build this library. The "Storage.java" class is used to save and open stored networks that are trained and used for future running or training.

The main algorithmic methods can be found in the "Algorithm.java" class, which is the main code for the running of the classification system. The other class is the "Training.java" class includes the methods for the training and learning aspects of the library. The class handles the physical data processing feature of the library, which makes the development and testing process much easier.

## Installation

The installation for this library is listed below either using the Maven or Gradle build tools. Both of these tools are ubiquitous in the Java build environment world. The other option for using this library in your code is to use this as a module or use the included jar file found in the repository. This can be used locally, but updating to newer versions is much harder in build environments without using the Maven or Gradle implementation. Lastly, it is important to us that you pay attention to the version number when building your project with our library.

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
