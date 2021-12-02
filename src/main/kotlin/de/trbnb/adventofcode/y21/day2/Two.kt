package de.trbnb.adventofcode.y21.day2

import java.io.File

fun main() {
    val steps = File("C:\\Users\\Thorben\\Documents\\source\\personal\\AdventOfCode\\src\\main\\resources\\2021_two_one.txt")
        .readSteps()

    val result = steps.fold(Result(0, 0, 0)) { result, step ->
        when (step.direction) {
            Direction.FORWARD -> result.copy(
                hPosition =  result.hPosition + step.factor,
                depth = result.depth + (result.aim * step.factor)
            )
            Direction.UP -> result.copy(aim = result.aim - step.factor)
            Direction.DOWN -> result.copy(aim = result.aim + step.factor)
        }
    }

    println(result)
    println("result: ${result.hPosition * result.depth}")
}

data class Result(val aim: Int, val hPosition: Int, val depth: Int)