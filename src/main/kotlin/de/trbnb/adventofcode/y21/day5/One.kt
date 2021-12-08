package de.trbnb.adventofcode.y21.day5

import de.trbnb.adventofcode.y21.resourceFile

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
        .filter { (first, second) -> first.first == second.first || first.second == second.second }
        .flatMap { (first, second) ->
            if (first.first == second.first) {
                // vertical
                (minOf(first.second, second.second)..maxOf(first.second, second.second)).map { first.first to it }
            } else if (first.second == second.second) {
                //horizontal
                (minOf(first.first, second.first)..maxOf(first.first, second.first)).map { it to first.second }
            } else emptyList<Nothing>()
        }
        .groupBy { it }
        .count { it.value.size > 1 }
        .let(::println)
}

fun <T> List<T>.toPair() = get(0) to get(1)