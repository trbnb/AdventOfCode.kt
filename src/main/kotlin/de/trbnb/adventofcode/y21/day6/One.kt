package de.trbnb.adventofcode.y21.day6

import de.trbnb.adventofcode.y21.resourceFile

fun main() {
    (1..256).fold(
        resourceFile("2021_six.txt")
            .readText()
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