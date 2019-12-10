package ru.ought.advent_of_code_2019.day_03

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect
import java.lang.IllegalArgumentException


object WireTest : Spek({
    describe("Wire") {
        it("parses segments to list") {
            val wire = Wire("R8,U5,L5,D3")
            expect(wire.segments).toBe(listOf(
                Segment(Point(0, 0), Point(8, 0)),
                Segment(Point(8, 0), Point(8, 5)),
                Segment(Point(8, 5), Point(3, 5)),
                Segment(Point(3, 5), Point(3, 2))
            ))
        }
    }
})
