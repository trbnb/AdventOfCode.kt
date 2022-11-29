package de.trbnb.adventofcode.y21.day1

import de.trbnb.adventofcode.utils.input

fun main() {
    val numbers = input()
        .mapNotNull { it.toIntOrNull() }

    numbers.windowed(3) { it.sum() }
        .countIncrements()
        .let { print(it) }
}