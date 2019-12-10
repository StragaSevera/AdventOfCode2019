package ru.ought.advent_of_code_2019.day_03

object Day03First {
    fun nearestIntersectionDistance(firstStr: String, secondStr: String): Int {
        val first = parseSegments(firstStr)
        val second = parseSegments(secondStr)
        require(first.isNotEmpty())
        require(second.isNotEmpty())
        return first.map { a ->
            second.map { b ->
                a.getIntersection(b)?.dist ?: Int.MAX_VALUE
            }.min()!!
        }.min()!!
    }
}
