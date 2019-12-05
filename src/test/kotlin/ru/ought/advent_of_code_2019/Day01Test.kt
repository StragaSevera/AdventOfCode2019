package ru.ought.advent_of_code_2019

import io.kotlintest.IsolationMode
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.specs.DescribeSpec

class Day01Test : DescribeSpec() {
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerLeaf

    private val sut = Day01()

    init {
        describe("day 01") {
            it("exists") {
                sut.shouldBeTypeOf<Day01>()
            }
        }
    }
}