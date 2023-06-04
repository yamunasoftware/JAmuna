# JAmuna

Java Supervised Machine Learning Library Using Genetic Algorithms to Learn

## Overview

The JAmuna library is a machine learning library that is built from using neural networks to get better results from you testing. This is an implementation on the traditional style of using Gradient Descent with Back Propagation to train a neural network. This library also acts as a framework for being able to create neural networks of any size to use methods like deep learning to be able to do more complex tasks.

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
