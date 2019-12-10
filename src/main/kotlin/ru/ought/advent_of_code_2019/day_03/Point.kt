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