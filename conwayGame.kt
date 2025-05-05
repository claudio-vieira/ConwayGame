main()
fun main() {

    //Create a live cells list that's going to receive the initial state
    val liveCells = mutableSetOf<Pair<Long, Long>>()

    //Sample of input 1.06 format
    val input = """
        #Life 1.06
        0 1
        1 2
        2 0
        2 1
        2 2
        -2000000000000 -2000000000000
        -2000000000001 -2000000000001
        -2000000000000 -2000000000001
    """.trimIndent().lines()

    //Prepare input from multiline string by initializing the liveCells list
    for (line in input) {
        val trimmed = line.trim()

        //Ignoring the unecessary first line
        if (trimmed.isEmpty() || trimmed.startsWith("#")) continue
        val (x, y) = trimmed.split(" ").map { it.toLong() }
        liveCells.add(Pair(x, y))
    }

    //Run 10 generations
    repeat(10) {

        //Creating a neighborCounts that is going to hold the neighbors with the
        //number of alive cells each neighbour has
        val neighborCounts = mutableMapOf<Pair<Long, Long>, Int>()
        
        //Iterating all alive cells
        for ((x, y) in liveCells) {
            
            //Going through all their neighbours
            for (dx in -1L..1L) {
                for (dy in -1L..1L) {
                    //Ignore the given cell
                    if (dx == 0L && dy == 0L) continue
                    
                    //Increment +1 to every neighbour that has an alive cell
                    val neighbor = Pair(x + dx, y + dy)
                    neighborCounts[neighbor] = neighborCounts.getOrDefault(neighbor, 0) + 1
                }
            }
        }

        //Creating a temporary newLiveCells to replace the current liveCells with new values
        val newLiveCells = mutableSetOf<Pair<Long, Long>>()

        //Apply the rules to turn alive or dead a cell by checking the count of each neighbour
        for ((cell, count) in neighborCounts) {
            if (count == 3 || (count == 2 && cell in liveCells)) {
                newLiveCells.add(cell)
            }
        }

        //Clearing the current liveCells to add the new generation of alive cells
        liveCells.clear()
        liveCells.addAll(newLiveCells)
    }

    // Output a sorted list of alive cells after 10 generations in a 1.06 format
    println("#Life 1.06")
    liveCells.sortedWith(compareBy({ it.first }, { it.second })).forEach {
        println("${it.first} ${it.second}")
    }
}
