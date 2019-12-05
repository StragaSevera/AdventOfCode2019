package ru.ought.advent_of_code_2019

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect


object Day01FirstTest : Spek({
    describe("Day 01 First Task") {
        context("gets valid fuel") {
            data class FuelCase(val mass: Int, val fuel: Int)
            listOf(
                FuelCase(12, 2),
                FuelCase(14, 2),
                FuelCase(1969, 654),
                FuelCase(100756, 33583)
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
