# ConwayGame

# As this is an Android position the code was done using Kotlin.

Rules of the Game (per generation):

For each generation: 
  * Every cell has 8 neighbors (up, down, left, right, and diagonals). 
  * A live cell: 
    - Survives if it has 2 or 3 live neighbors.
    - Dies otherwise (underpopulation or overpopulation).
  * A dead cell:
    - Becomes alive if it has exactly 3 live neighbors (reproduction).
    
What did I do:

  * Read the input (list of live cell coordinates).
  * Simulate the system for 10 generations using the rules above.
  * Output the final state (after 10 generations) in Life 1.06 format:

The code has comments clarifying what each block is doing.

I used the Android Studio scratch file to run the code with the initial state provided by email. Below you can see an image of the code result running it on my Android Studio.

![Screenshot 2025-05-05 at 14 20 47](https://github.com/user-attachments/assets/0b7201a7-2a41-4302-8c5c-c0ab368734c9)
