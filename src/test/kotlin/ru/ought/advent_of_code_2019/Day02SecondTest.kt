package ru.ought.advent_of_code_2019

import ch.tutteli.atrium.api.fluent.en_GB.isGreaterOrEquals
import ch.tutteli.atrium.api.fluent.en_GB.isGreaterThan
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ch.tutteli.atrium.api.verbs.expect

object Day02SecondTest : Spek({
    describe("Day 02 Second Task") {
        // This challenge is not fit to the unit-testing pattern
        it("calculates a good output") {
            val input = listOf(1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,2,9,19,23,2,13,23,27,1,6,27,31,2,6,31,35,2,13,35,39,1,39,10,43,2,43,13,47,1,9,47,51,1,51,13,55,1,55,13,59,2,59,13,63,1,63,6,67,2,6,67,71,1,5,71,75,2,6,75,79,1,5,79,83,2,83,6,87,1,5,87,91,1,6,91,95,2,95,6,99,1,5,99,103,1,6,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0
            )
            val output = 19690720
            val result = Day02Second.findMatchingInputs(input, output)

            println(result)
            expect(result).isGreaterOrEquals(0)
        }
    }
})
