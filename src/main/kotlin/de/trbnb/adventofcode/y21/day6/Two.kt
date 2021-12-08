package de.trbnb.adventofcode.y21.day6

import de.trbnb.adventofcode.y21.resourceFile

fun main() {
    val initial = resourceFile("2021_six.txt")
        .readLines()
        .first()
        .split(",")
        .map { it.toInt() }

    val fishAtDay = LongArray(9) { index -> initial.count { it == index }.toLong() }
    (1..256).forEach { _ ->
        val zeros = fishAtDay[0]
        (1..8).forEach { fishAtDay[it - 1] = fishAtDay[it] }
        fishAtDay[6] += zeros
        fishAtDay[8] = zeros
    }
    println(fishAtDay.sum())
}