package me.devnatan.kompress

import kotlinx.io.Buffer
import kotlinx.io.RawSource
import kotlinx.io.asInputStream
import kotlinx.io.asSource
import kotlinx.io.buffered
import kotlinx.io.files.Path
import org.apache.commons.compress.archivers.tar.TarArchiveEntry
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream
import java.io.InputStream
import java.util.zip.GZIPInputStream

internal actual suspend fun readTarImpl(input: RawSource): Buffer {
    val tar = TarArchiveInputStream(GZIPInputStream(input.buffered().asInputStream()))

    tar.use {
        var archive: TarArchiveEntry

        while (tar.getNextTarEntry().also { archive = it } != null) {
            TODO()
        }
    }

    TODO()
}

internal actual suspend fun createTarImpl(from: Path, to: Path) {
}

internal actual suspend fun extractTarImpl(from: Path, to: Path) {
}