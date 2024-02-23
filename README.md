# Perlin Noise Generator

This Java program generates Perlin noise, a type of gradient noise used in computer graphics and procedural content generation.

## Overview

The Perlin Noise algorithm creates smooth, natural-looking random patterns. It's commonly used for terrain generation, texture synthesis, and other visual effects.

## Usage

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/perlin-noise.git
   cd perlin-noise
2. **Compile and Run:**
   `javac PerlinNoise.java`
   `java PerlinNoise`
3. **Adjust Parameters:**
   `seed`: Set the random seed for consistent noise patterns.
   `octaves`: Control the number of octaves (layers) in the noise.
   `persistence`: Adjust the persistence (amplitude decay) between octaves.
4. **Interpret the Output:**
The program generates Perlin noise values for specified (x, y) coordinates. You can use these values for various purposes, such as terrain heightmaps or procedural textures.
