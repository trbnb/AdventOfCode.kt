package de.trbnb.adventofcode.y21.day7

import de.trbnb.adventofcode.utils.input

fun main() {
    fun calcFuel(crabs: List<Int>, alignPosition: Int): Int {
        return crabs.fold(0) { acc, i -> acc + maxOf(i, alignPosition) - minOf(i, alignPosition) }
    }

    fun calc(crabs: List<Int>): Int {
        return (0..crabs.maxOf { it })
            .associateWith { calcFuel(crabs, it) }
            .also(::println)
            .minOf { it.value }
    }

    val crabs = input()
        .first()
        .split(",")
        .map(String::toInt)

    calc(crabs)
        .let(::println)
}