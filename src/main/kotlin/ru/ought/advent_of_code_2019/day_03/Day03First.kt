package ru.ought.advent_of_code_2019.day_03

import kotlin.math.abs

data class Point(val x: Int, val y: Int) {
    fun move(vector: String): Point {
        val (direction, distance) = vector[0] to vector.drop(1).toInt()
        return when (direction) {
            'R' -> Point(x + distance, y)
            'L' -> Point(x - distance, y)
            'U' -> Point(x, y + distance)
            'D' -> Point(x, y - distance)
            else -> throw IllegalArgumentException()
        }
    }

    operator fun plus(p: Point): Point =
        Point(x + p.x, y + p.y)
    operator fun minus(p: Point): Point =
        Point(x - p.x, y - p.y)

    val dist: Int
        get() = abs(x) + abs(y)

}

data class Segment(val p1: Point, val p2: Point) {
    private val isVertical: Boolean
        get() = p2.x - p1.x == 0
    private val isHorizontal: Boolean
        get() = p2.y - p1.y == 0

    private val xRange: IntRange
        get() = minOf(p1.x, p2.x)..maxOf(p1.x, p2.x)
    private val yRange: IntRange
        get() = minOf(p1.y, p2.y)..maxOf(p1.y, p2.y)

    init {
        if (!isVertical && !isHorizontal)
            throw IllegalArgumentException()
    }

    fun getIntersection(segment: Segment): Point? {
        if ((isVertical && segment.isVertical) ||
            (isHorizontal && segment.isHorizontal)
        ) {
            // Don't know how to handle intersecting when parallel
            return null
        }

        val horizontal: Segment
        val vertical: Segment
        if (isHorizontal) {
            horizontal = this
            vertical = segment
        } else {
            horizontal = segment
            vertical = this
        }

        if ((horizontal.p1.y in vertical.yRange) &&
            (vertical.p1.x in horizontal.xRange)
        ) {
            val result = Point(vertical.p1.x, horizontal.p1.y)
            if (result.x != 0 || result.y != 0)
                return result
        }
        return null

    }
}

object Day03First {
    fun nearestIntersectionDistance(firstStr: String, secondStr: String): Int {
        val first = firstStr.split(',').toWires()
        val second = secondStr.split(',').toWires()
        require(first.isNotEmpty())
        require(second.isNotEmpty())
        return first.map { a ->
            second.map { b ->
                a.getIntersection(b)?.dist ?: Int.MAX_VALUE
            }.min()!!
        }.min()!!
    }


    private fun List<String>.toWires(): List<Segment> {
        var currentPoint = Point(0, 0)
        return map { str ->
            Segment(
                currentPoint,
                currentPoint.move(str).also { currentPoint = it })
        }
    }

}
