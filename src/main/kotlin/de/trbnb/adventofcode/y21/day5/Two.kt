package de.trbnb.adventofcode.y21.day5

import de.trbnb.adventofcode.y21.resourceFile
import kotlin.math.absoluteValue

fun main() {
    resourceFile("2021_five.txt").readLines()
        .map { line ->
            line.split("->")
                .map { coordinates ->
                    coordinates.split(",")
                        .map { it.trim().toInt() }
                        .toPair()
                }
                .toPair()
        }
        .flatMap { (first, second) ->
            if (first.first == second.first) {
                // vertical
                (minOf(first.second, second.second)..maxOf(first.second, second.second)).map { first.first to it }
            } else if (first.second == second.second) {
                // horizontal
                (minOf(first.first, second.first)..maxOf(first.first, second.first)).map { it to first.second }
            } else {
                // diagonal
                val xDirection = second.first.compareTo(first.first)
                val yDirection = second.second.compareTo(first.second)
                (0..(second.first - first.first).absoluteValue).map { step ->
                    first.first + (xDirection * step) to first.second + (yDirection * step)
                }
            }
        }
        .groupBy { it }
        .count { it.value.size > 1 }
        .let(::println)
}