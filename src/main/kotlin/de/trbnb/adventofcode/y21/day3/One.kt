package de.trbnb.adventofcode.y21.day3

import de.trbnb.adventofcode.utils.input

fun main() {
    input()
        .map(String::toList)
        .rotate { it == '1' }
        .map { column -> mapOf(false to column.count { !it }, true to column.count { it }) }
        .map { column -> column.maxByOrNull { it.value }?.key ?: false }
        .let { list -> listOf(list.joinToString(), list.map { !it }.joinToString()) }
        .map { it.toInt(radix = 2) }
        .let { (most, least) -> most * least }
        .let { println(it) }
}

fun Boolean.toInt() = if (this) 1 else 0
fun List<Boolean>.joinToString() = joinToString(separator = "") { it.toInt().toString() }

fun <T, R> List<List<T>>.rotate(transform: (T) -> R): List<List<R>> {
    return List(first().size) { index -> map { transform(it[index]) } }
}
