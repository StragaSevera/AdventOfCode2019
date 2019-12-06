package ru.ought.advent_of_code_2019

object Day02First {
    private const val OP_SIZE = 4
    fun calculate(program: List<Int>): List<Int> {
        val memory = program.toMutableList()
        loop@ for (i in 0 until memory.size step OP_SIZE) {
            when (memory[i]) {
                1 -> operate(memory, i) { a, b -> a + b }
                2 -> operate(memory, i) { a, b -> a * b }
                else -> break@loop
            }
        }
        return memory
    }

    private fun operate(memory: MutableList<Int>, address: Int, operation: (Int, Int) -> Int) {
        memory.apply {
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