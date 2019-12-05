package ru.ought.advent_of_code_2019

object Day01First {
    fun fuel(mass: Int): Int {
        return mass / 3 - 2
    }

    fun fuelFor(str: String): Int {
        return str.trim().split("\\s+".toRegex())
            .map { it.toInt() }.map(::fuel)
            .sum()
    }
}