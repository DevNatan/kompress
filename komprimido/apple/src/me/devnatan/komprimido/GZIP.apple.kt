package me.devnatan.komprimido

import kotlinx.io.Buffer

private const val DEFLATE: UInt = 8u // 0x08
private const val NO_FLAGS: UInt = 0u // 0x00

// https://tools.ietf.org/html/rfc1952
internal actual fun gzip(data: Buffer) {
    val header = uintArrayOf(
        31u /* 0x1f */,
        139u /* 0x8b */,
        DEFLATE,
        NO_FLAGS
    )

    TODO()
}