package ru.ought.advent_of_code_2019.day_03

object Day03First {
    fun nearestIntersectionDistance(wires: String): Int {
        val (firstWire, secondWire) = wires.split('\n').map(::Wire).map(Wire::segments)
        require(firstWire.isNotEmpty())
        require(secondWire.isNotEmpty())

        return firstWire.map { a ->
            secondWire.map { b ->
                a.getIntersection(b)?.dist ?: Int.MAX_VALUE
            }.min()!!
        }.min()!!
    }
}
