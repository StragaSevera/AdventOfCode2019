package ru.ought.advent_of_code_2019.day_03

class Wire(segmentString: String) {
    val segments: List<Segment>

    init {
        if (segmentString.isNotBlank()) {
            var currentPoint = Point(0, 0)
            segments = segmentString.split(',').map { str ->
                Segment(currentPoint, currentPoint.move(str).also { currentPoint = it })
            }
        } else {
            segments = listOf()
        }
    }
}