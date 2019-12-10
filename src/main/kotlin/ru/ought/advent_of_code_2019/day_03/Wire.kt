package ru.ought.advent_of_code_2019.day_03


fun parseWire(segmentString: String): List<Segment> {
    var currentPoint = Point(0, 0)
    return segmentString.split(',').map { str ->
        Segment(currentPoint, currentPoint.move(str).also { currentPoint = it })
    }
}