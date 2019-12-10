package ru.ought.advent_of_code_2019.day_03

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect
import java.lang.IllegalArgumentException


object SegmentTest : Spek({
    describe("Segment") {
        it("cannot be initialized by an angled segment") {
            expect { Segment(Point(1, 1), Point(2, 2)) }.toThrow<IllegalArgumentException>()
        }

        context("can find correct intersection") {
            listOf(
                Triple(Segment(Point(3, 1), Point(3, 9)), Segment(Point(1, 5), Point(9, 5)), Point(3, 5)),
                Triple(Segment(Point(3, 1), Point(3, 9)), Segment(Point(4, 5), Point(9, 5)), null)
            ).forEach {
                it(it.toString()) {
                    val (seg1, seg2, distance) = it
                    val result = seg1.getIntersection(seg2)
                    expect(result).toBe(distance)
                }
            }
        }

        it("parses segments to list") {
            val list = parseSegments("R8,U5,L5,D3")
            expect(list).toBe(listOf(
                Segment(Point(0, 0), Point(8, 0)),
                Segment(Point(8, 0), Point(8, 5)),
                Segment(Point(8, 5), Point(3, 5)),
                Segment(Point(3, 5), Point(3, 2))
            ))
        }
    }
})
