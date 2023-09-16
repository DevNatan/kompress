package me.devnatan.kompress

import kotlinx.io.Buffer
import kotlinx.io.RawSource
import kotlinx.io.files.Path

internal expect suspend fun readTarImpl(input: RawSource): Buffer

internal expect suspend fun createTarImpl(from: Path, to: Path)

internal expect suspend fun extractTarImpl(from: Path, to: Path)