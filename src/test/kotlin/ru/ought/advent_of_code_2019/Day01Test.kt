package ru.ought.advent_of_code_2019

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec
import io.kotlintest.tables.row


class Day01Test : DescribeSpec({
    describe("Day 01") {
        it("gets valid fuel") {
            forall(
                row(12, 2),
                row(14, 2),
                row(1969, 654),
                row(100756, 33583)
            ) { mass: Int, fuel: Int ->
                fuel(mass) shouldBe fuel
            }
        }

        it("gets valid fuel for all values") {
            val str = "12\r\n14\r\n1969\r\n100756\r\n"
            val result = 34241
            fuelFor(str) shouldBe result
        }
    }
})
