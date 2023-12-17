package me.devnatan.kompress

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.refTo
import kotlinx.cinterop.value
import platform.posix.size_tVar
import platform.zlib.compress
import platform.zlib.compressBound
import platform.zlib.uncompress

@OptIn(ExperimentalForeignApi::class)
internal actual fun zlibInflate(input: ByteArray): ByteArray = memScoped {
    val size = compressBound(input.size.toULong()).toInt()
    val output = ByteArray(size)

    compress(
        dest = output.asUByteArray().refTo(0),
        destLen = alloc<size_tVar> {
            value = size.toULong()
        }.ptr,
        source = input.asUByteArray().refTo(0),
        sourceLen = input.size.toULong(),
    )

    output.copyOf(size)
}

@OptIn(ExperimentalForeignApi::class)
internal actual fun zlibDeflate(input: ByteArray): ByteArray = memScoped {
    val size = input.size * 2
    val output = ByteArray(size)

    uncompress(
        dest = output.asUByteArray().refTo(0),
        destLen = alloc<size_tVar> {
            value = size.toULong()
        }.ptr,
        source = input.asUByteArray().refTo(0),
        sourceLen = input.size.toULong()
    )

    output.copyOf(size)
}