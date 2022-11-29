package de.trbnb.adventofcode.utils

import java.io.File

fun input(
    filename: String = "input.txt"
): List<String> {
    val packagePath = Thread.currentThread().stackTrace.last().packageNameComponents.joinToString(separator = "/")
    return File("./src/main/kotlin/$packagePath/$filename").canonicalFile.readLines()
}

fun <T> List<T>.removeLast() = filterIndexed { index, _ -> index < lastIndex }

val StackTraceElement.packageNameComponents: List<String>
    get() = className.split(".").removeLast()