package de.trbnb.adventofcode.y21.day1

import java.io.File

fun main() {
    val numbers = File("C:\\Users\\Thorben\\Documents\\source\\personal\\AdventOfCode\\src\\main\\resources\\2021_one_one.txt")
        .readLines()
        .mapNotNull { it.toIntOrNull() }

    numbers.countIncrements().let(::println)
}

fun List<Int>.countIncrements() =
    mapIndexedNotNull { index, i -> getOrNull(index + 1)?.let { i to it } }
        .count { (first, second) -> second > first }