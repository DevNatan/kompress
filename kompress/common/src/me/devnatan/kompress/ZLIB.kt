package me.devnatan.kompress

internal expect fun zlibInflate(input: ByteArray): ByteArray

internal expect fun zlibDeflate(input: ByteArray): ByteArray