package de.trbnb.adventofcode.y21.day8

import de.trbnb.adventofcode.utils.input

fun main() {
    input()
        .map { it.replace("| ", "") }
        .map { line -> line.split(" ").map { it.toList().sorted().string() } }
        .map { line ->
            val one = line.first { it.length == 2 }
            val four = line.first { it.length == 4 }
            val seven = line.first { it.length == 3 }
            val eight = line.first { it.length == 7 }
            val allChars = 'a'..'g'
            val sixers = line.filter { it.length == 6 }
            val fivers = line.filter { it.length == 5 }

            val top = seven.first { it !in one }
            val topRightOrCenterOrBottomLeft = allChars.filterNot { char -> sixers.all { char in it } }
            val two = fivers.first { fiver -> topRightOrCenterOrBottomLeft.all { it in fiver } }
            val bottom = two.first { it != top && it !in topRightOrCenterOrBottomLeft }
            val bottomLeft = eight.first { it !in one && it !in four && it !in seven && it != bottom }
            val centerOrTopRight = two.filter { it != bottomLeft && it != top && it != bottom }
            val center = centerOrTopRight.first { it !in one }
            Segment(
                topLeft = four.first { it !in one && it != center },
                topRight = centerOrTopRight.first { it != center },
                center = center,
                bottomLeft = bottomLeft
            ) to line.takeLast(4)
        }
        .sumOf { (segment, digits) -> digits.map { it.readDigit(segment) }.string().toInt() }
        .let(::println)
}

class Segment(
    val topLeft: Char,
    val topRight: Char,
    val center: Char,
    val bottomLeft: Char
)

fun String.readDigit(segment: Segment) = when (length) {
    2 -> '1'
    4 -> '4'
    3 -> '7'
    7 -> '8'
    6 -> when {
        segment.topRight in this && segment.center in this -> '9'
        segment.topRight in this && segment.bottomLeft in this -> '0'
        else -> '6'
    }
    5 -> when {
        segment.bottomLeft in this -> '2'
        segment.topLeft in this -> '5'
        else -> '3'
    }
    else -> throw IllegalArgumentException(this)
}

fun List<Char>.string() = joinToString(separator = "")