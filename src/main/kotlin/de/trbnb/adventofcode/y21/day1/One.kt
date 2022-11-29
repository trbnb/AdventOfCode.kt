package de.trbnb.adventofcode.y21.day1

import de.trbnb.adventofcode.utils.input

fun main() {
    val numbers = input()
        .mapNotNull { it.toIntOrNull() }

    numbers.countIncrements().let(::println)
}

fun List<Int>.countIncrements() = zipWithNext().count { (first, second) -> second > first }