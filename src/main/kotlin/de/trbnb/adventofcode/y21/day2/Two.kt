package de.trbnb.adventofcode.y21.day2

import de.trbnb.adventofcode.utils.input

fun main() {
    val steps = input().readSteps()

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