package de.trbnb.adventofcode.y21.day2

import java.io.File

fun main() {
    val (hSteps, vSteps) = File("C:\\Users\\Thorben\\Documents\\source\\personal\\AdventOfCode\\src\\main\\resources\\2021_two_one.txt")
        .readSteps()
        .partition { it.direction == Direction.FORWARD }

    val hPosition = hSteps.sumOf { it.factor }
    val vPosition = vSteps.sumOf { step ->
        when (step.direction) {
            Direction.UP -> -step.factor
            else -> step.factor
        }
    }

    val result = hPosition * vPosition
    println("hPosition: $hPosition, vPosition: $vPosition, result: $result")
}

enum class Direction {
    FORWARD, UP, DOWN
}

data class Step(val direction: Direction, val factor: Int)

fun File.readSteps() =
    readLines()
    .map { line ->
        val (direction, factor) = line.split(" ")
        Step(Direction.values().first { it.name.equals(direction, ignoreCase = true) }, factor.toInt())
    }