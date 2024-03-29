package de.trbnb.adventofcode.y21.day7

import de.trbnb.adventofcode.utils.input

fun main() {
    fun calcFuel(crabs: List<Int>, alignPosition: Int): Int {
        return crabs.fold(0) { acc, i ->
            val steps = maxOf(i, alignPosition) - minOf(i, alignPosition)
            acc + (1..steps).sum()
        }
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
