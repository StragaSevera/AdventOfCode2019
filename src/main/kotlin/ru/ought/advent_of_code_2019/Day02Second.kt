package ru.ought.advent_of_code_2019

object Day02Second {
    fun findMatchingInputs(input: List<Int>, output: Int): Int {
        val memory = input.toMutableList()
        for (i in 0..99) {
            for (j in 0..99) {
                memory[1] = i
                memory[2] = j
                val result = Day02First.calculate(memory)[0]
                if (result == output) {
                    return i * 100 + j
                }
            }
        }
        return -1
    }

}