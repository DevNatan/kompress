package me.devnatan.kompress

import kotlinx.coroutines.flow.Flow

public object Kompress {

    public suspend fun compress(algorithm: CompressionAlgorithm): Flow<ByteArray> = TODO()

    public suspend fun decompress(algorithm: CompressionAlgorithm): Flow<ByteArray> = TODO()
}

public enum class CompressionAlgorithm {
    ZLIB,
    GZIP
}