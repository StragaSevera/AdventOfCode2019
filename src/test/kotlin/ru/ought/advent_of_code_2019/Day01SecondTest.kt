package ru.ought.advent_of_code_2019

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect


object Day01SecondTest : Spek({
    describe("Day 01 Second Task") {
        context("gets valid fuel") {
            listOf(
                14 to 2,
                1969 to 966,
                100756 to 50346
            ).forEach {
                it(it.toString()) {
                    val (mass, fuel) = it
                    expect(Day01Second.fuel(mass)).toBe(fuel)
                }
            }
        }

        it("gets valid fuel for all values") {
            val str = "14\r\n1969\r\n100756\r\n"
            val result = 51314
            expect(Day01Second.fuelFor(str)).toBe(result)
        }
    }
})
