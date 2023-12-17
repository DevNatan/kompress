package me.devnatan.kompress

import java.util.zip.Deflater
import java.util.zip.Inflater

internal actual fun zlibInflate(input: ByteArray): ByteArray {
    val deflater = Deflater().apply {
        setInput(input)
        finish()
    }

    val output = ByteArray(input.size)
    val compressed = deflater.deflate(output)
    deflater.end()

    return output.copyOf(compressed)
}

internal actual fun zlibDeflate(input: ByteArray): ByteArray {
    val inflater = Inflater().apply {
        setInput(input)
    }
    val output = ByteArray(input.size * 2)
    val decompressed = inflater.inflate(output)
    inflater.end()

    return output.copyOf(decompressed)
}