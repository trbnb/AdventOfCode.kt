package de.trbnb.adventofcode.y21.day1

import java.io.File

fun main() {
    val numbers = File("C:\\Users\\Thorben\\Documents\\source\\personal\\AdventOfCode\\src\\main\\resources\\2021_one_one.txt")
        .readLines()
        .mapNotNull { it.toIntOrNull() }

    numbers.windowed(3) { it.sum() }
        .countIncrements()
        .let { print(it) }
}