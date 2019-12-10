package ru.ought.advent_of_code_2019.day_03

object Day03Second {
    fun nearestIntersectionSteps(wires: String): Int {
        val (firstWire, secondWire) = wires.split('\n').map(::parseWire)
        require(firstWire.isNotEmpty())
        require(secondWire.isNotEmpty())

        var minSteps = Int.MAX_VALUE
        var firstSum = 0
        for (i in firstWire.indices) {
            var secondSum = 0
            for (j in secondWire.indices) {
                firstWire[i].getIntersection(secondWire[j])?.let { intersection ->
                    val steps = firstSum + firstWire[i].distanceFromStartTo(intersection) +
                            secondSum + secondWire[j].distanceFromStartTo(intersection)
                    minSteps = minOf(minSteps, steps)
                }
                secondSum += secondWire[j].length
            }
            firstSum += firstWire[i].length
        }

        return minSteps
    }
}
