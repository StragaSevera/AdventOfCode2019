package ru.ought.advent_of_code_2019

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect


object Day01FirstTest : Spek({
    describe("Day 01 First Task") {
        context("gets valid fuel") {
            listOf(
                12 to 2,
                14 to 2,
                1969 to 654,
                100756 to 33583
            ).forEach { case ->
                it(case.toString()) {
                    val (mass, fuel) = case
                    expect(Day01First.fuel(mass)).toBe(fuel)
                }
            }
        }

        it("gets valid fuel for all values") {
            val str = "12\r\n14\r\n1969\r\n100756\r\n"
            val result = 34241
            expect(Day01First.fuelFor(str)).toBe(result)
        }
    }
})
