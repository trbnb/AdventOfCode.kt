package de.trbnb.adventofcode.y21.day4

import de.trbnb.adventofcode.utils.input

fun main() {
    val lines = input()

    val numbers = lines.first().split(",").map(String::toInt)

    val (first, last) = lines.asSequence()
        .filterIndexed { index, _ -> index > 1 }
        .chunked(6)
        .map { matrix ->
            matrix.filterNot(String::isBlank)
                .map { line ->
                    line.split(" ")
                        .mapNotNull(String::toIntOrNull)
                        .map { it to false }
                }
        }
        .mapNotNull { initialMatrix ->
            numbers.foldIndexed(initialMatrix) { index, matrix, drawnNumber ->
                val newMatrix = matrix.map { line ->
                    line.map { numberField ->
                        when (numberField.first) {
                            drawnNumber -> drawnNumber to true
                            else -> numberField
                        }
                    }
                }

                if (newMatrix.hasWon()) {
                    return@mapNotNull Triple(index, drawnNumber, matrix.score)
                }

                newMatrix
            }
            null
        }
        .sortedBy { it.first }
        .toList()
        .let { it.first() to it.last() }

    println("First: ${first.finalScore}")
    println("Last: ${last.finalScore}")
}

typealias WinningResult = Triple<Int, Int, Int>
val WinningResult.finalScore: Int
    get() = second * third

typealias Matrix = List<MatrixLine>
typealias MatrixLine = List<Pair<Int, Boolean>>

fun MatrixLine.isChecked() = all { it.second }

fun Matrix.hasWon(): Boolean {
    return any(MatrixLine::isChecked) || columns.any(MatrixLine::isChecked)
}

val Matrix.columns: List<MatrixLine>
    get() = (0..first().lastIndex).map { column ->
        this@columns.map { it[column] }
    }

val Matrix.score: Int
    get() = flatten().filter { !it.second }.sumOf { it.first }