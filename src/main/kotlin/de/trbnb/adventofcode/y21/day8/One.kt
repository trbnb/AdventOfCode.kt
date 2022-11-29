package de.trbnb.adventofcode.y21.day8

import de.trbnb.adventofcode.utils.input

fun main() {
    input()
        .map { it.split("|").last().trim() }
        .flatMap { line -> line.split(" ").map(String::length) }
        .count { it == 2 || it == 4 || it == 3 || it == 7 }
        .let(::println)
}