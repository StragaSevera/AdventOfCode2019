package ru.ought.advent_of_code_2019.day_03

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect
import java.lang.IllegalArgumentException


object PointTest : Spek({
    describe("Point") {
        context("can move point") {
            listOf(
                "R5" to Point(15, -5),
                "L10" to Point(0, -5),
                "U3" to Point(10, -2),
                "D6" to Point(10, -11)
            ).forEach {
                it(it.toString()) {
                    val (vector, distance) = it
                    val result = Point(10, -5).move(vector)
                    expect(result).toBe(distance)
                }
            }
        }

        context("cannot illegaly move point") {
            listOf("F5", "L1.01", "R2D2", "", " ").forEach {
                it(it) {
                    expect {Point(10, -5).move(it)}.toThrow<IllegalArgumentException>()
                }
            }
        }

        it("can add points") {
            val result = Point(5, 2) + Point(10, -7)
            expect(result).toBe(Point(15, -5))
        }

        it("can subtract points") {
            val result = Point(5, 2) - Point(10, -7)
            expect(result).toBe(Point(-5, 9))
        }

        it("can get Manhattan distance") {
            val result = Point(5, -7).dist
            expect(result).toBe(12)
        }
    }
})
