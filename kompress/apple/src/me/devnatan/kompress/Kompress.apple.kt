package me.devnatan.kompress

import kotlinx.io.Buffer
import kotlinx.io.RawSource
import kotlinx.io.files.Path
import platform.Foundation.NSInputStream

internal actual suspend fun readTarImpl(input: RawSource): Buffer {
    TODO()
}

internal actual suspend fun createTarImpl(from: Path, to: Path) {
}

internal actual suspend fun extractTarImpl(from: Path, to: Path) {
}