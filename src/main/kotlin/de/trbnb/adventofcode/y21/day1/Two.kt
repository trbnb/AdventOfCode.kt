package de.trbnb.adventofcode.y21.day1

import de.trbnb.adventofcode.y21.resourceFile

fun main() {
    val numbers = resourceFile("2021_one_one.txt")
        .readLines()
        .mapNotNull { it.toIntOrNull() }

    numbers.windowed(3) { it.sum() }
        .countIncrements()
        .let { print(it) }
}