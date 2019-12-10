package ru.ought.advent_of_code_2019.day_01

object Day01Second {
    fun fuel(mass: Int): Int {
        val fuelValues = generateSequence(mass) {
            fuelIteration(
                it
            )
        }
        return fuelValues.drop(1).takeWhile { it > 0 }.sum()
    }

    private fun fuelIteration(mass: Int): Int {
        return mass / 3 - 2
    }

    fun fuelFor(str: String): Int {
        return str.trim().split("\\s+".toRegex())
            .map { it.toInt() }.map(Day01Second::fuel)
            .sum()
    }
}
