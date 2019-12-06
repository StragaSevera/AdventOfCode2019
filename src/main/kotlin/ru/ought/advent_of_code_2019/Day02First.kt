package ru.ought.advent_of_code_2019

object Day02First {
    private const val OP_SIZE = 4
    fun calculate(programInput: List<Int>): List<Int> {
        val program = programInput.toMutableList()
        loop@ for (i in 0 until program.size step OP_SIZE) {
            when (program[i]) {
                1 -> mutateListAt(program, i) { a, b -> a + b }
                2 -> mutateListAt(program, i) { a, b -> a * b }
                else -> break@loop
            }
        }
        return program
    }

    private fun mutateListAt(program: MutableList<Int>, address: Int, operation: (Int, Int) -> Int) {
        program.apply {
            setValueAt(
                address + 3,
                operation(getValueAt(address + 1), getValueAt(address + 2))
            )
        }
    }

    private fun MutableList<Int>.getValueAt(address: Int): Int {
        return this[this[address]]
    }

    private fun MutableList<Int>.setValueAt(address: Int, value: Int) {
        this[this[address]] = value
    }
}