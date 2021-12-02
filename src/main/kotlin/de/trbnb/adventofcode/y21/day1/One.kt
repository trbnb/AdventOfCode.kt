package de.trbnb.adventofcode.y21.day1

import de.trbnb.adventofcode.y21.resourceFile

fun main() {
    val numbers = resourceFile("2021_one_one.txt")
        .readLines()
        .mapNotNull { it.toIntOrNull() }

    numbers.countIncrements().let(::println)
}

fun List<Int>.countIncrements() =
    mapIndexedNotNull { index, i -> getOrNull(index + 1)?.let { i to it } }
        .count { (first, second) -> second > first }