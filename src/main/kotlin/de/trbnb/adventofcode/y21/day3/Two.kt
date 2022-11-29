package de.trbnb.adventofcode.y21.day3

import de.trbnb.adventofcode.utils.input

fun main() {
    input()
        .map { line -> line.map { it == '1' } }
        .let { lines -> findExtreme(lines, true) to findExtreme(lines, false) }
        .let { (first, second) -> first * second }
        .let(::println)
}

fun findExtreme(allLines: List<List<Boolean>>, max: Boolean): Int {
    var allowedIndices = allLines.indices.toList()
    var column = 0

    while(allowedIndices.size > 1) {
        val rowNumbersAndValues = allLines.mapIndexed { index, list -> index to list[column] }
            .filterIndexed { index, _ -> index in allowedIndices }

        val extreme = rowNumbersAndValues.groupBy { it.second }
            .map { (key, value) -> key to value.size }
            .let { pairs ->
                val zeros = pairs.firstOrNull { !it.first }?.second ?: 0
                val ones = pairs.firstOrNull { it.first }?.second ?: 0
                if (max) {
                    zeros <= ones
                } else {
                    zeros > ones
                }
            }

        allowedIndices = rowNumbersAndValues.filter { (_, value) -> value != extreme }
            .map { (row, _) -> row }

        column++
    }

    return allLines[allowedIndices.first()].joinToString().toInt(radix = 2)
}