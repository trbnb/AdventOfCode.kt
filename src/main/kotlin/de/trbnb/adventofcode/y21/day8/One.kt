package de.trbnb.adventofcode.y21.day8

import de.trbnb.adventofcode.y21.resourceFile

fun main() {
    resourceFile("2021_eight.txt")
        .readLines()
        .map { it.split("|").last().trim() }
        .flatMap { line -> line.split(" ").map(String::length) }
        .count { it == 2 || it == 4 || it == 3 || it == 7 }
        .let(::println)
}