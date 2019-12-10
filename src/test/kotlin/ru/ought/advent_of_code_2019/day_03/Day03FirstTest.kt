package ru.ought.advent_of_code_2019.day_03

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect


object Day03FirstTest : Spek({
    describe("Day 03 First Task") {
        listOf(
            "R8,U5,L5,D3\nU7,R6,D4,L4" to 6,
            "R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83" to 159,
            "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7" to 135
        ).forEach {
            it(it.toString()) {
                val (wires, result) = it
                val distance = Day03First.nearestIntersectionDistance(wires)
                expect(distance).toBe(result)
            }
        }
    }
})
