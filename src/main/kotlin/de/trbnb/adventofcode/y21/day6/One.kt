package de.trbnb.adventofcode.y21.day6

import de.trbnb.adventofcode.utils.input

fun main() {
    (1..256).fold(
        input().joinToString(separator = "\n")
            .trim()
            .split(",")
            .map(String::toInt)
    ) { allFish, day ->
        System.gc()
        println("Day #${day - 1}: ${allFish.size}\tFree memory: ${Runtime.getRuntime().freeMemory()}")
        allFish.flatMap { fish ->
            val newFish = fish - 1
            if (newFish < 0) {
                listOf(6, 8)
            } else listOf(newFish)
        }
    }.size.let(::println)
}