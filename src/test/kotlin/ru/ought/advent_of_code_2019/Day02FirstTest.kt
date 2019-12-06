package ru.ought.advent_of_code_2019

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect


object Day02FirstTest : Spek({
    describe("Day 02 First Task") {
        context("calculates a program") {
            listOf(
                Pair(listOf(1, 0, 0, 0, 99), listOf(2, 0, 0, 0, 99)),
                Pair(listOf(2, 3, 0, 3, 99), listOf(2, 3, 0, 6, 99)),
                Pair(listOf(2, 4, 4, 5, 99, 0), listOf(2, 4, 4, 5, 99, 9801)),
                Pair(
                    listOf(1, 1, 1, 4, 99, 5, 6, 0, 99),
                    listOf(30, 1, 1, 4, 2, 5, 6, 0, 99)
                ),
                Pair(
                    listOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50),
                    listOf(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50)
                )
            ).forEach { (program: List<Int>, correctResult: List<Int>) ->
                it(program.toString()) {
                    val result = Day02First.calculate(program)
                    expect(result).toBe(correctResult)
                }
            }
        }
    }
})
