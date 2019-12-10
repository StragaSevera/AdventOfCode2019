package ru.ought.advent_of_code_2019.day_03

import kotlin.math.abs

data class Segment(val p1: Point, val p2: Point) {
    init {
        if (!isVertical && !isHorizontal)
            throw IllegalArgumentException()
    }

    val length: Int
        get() = abs(p2.x - p1.x) + abs(p2.y - p1.y)

    private val isVertical: Boolean
        get() = p2.x - p1.x == 0

    private val isHorizontal: Boolean
        get() = p2.y - p1.y == 0
    private val xRange: IntRange
        get() = minOf(p1.x, p2.x)..maxOf(p1.x, p2.x)

    private val yRange: IntRange
        get() = minOf(p1.y, p2.y)..maxOf(p1.y, p2.y)

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

    fun distanceFromStartTo(point: Point): Int {
        return Segment(p1, point).length
    }
}
