package me.devnatan.kompress

import kotlin.test.Test
import kotlin.test.assertEquals

class ZLIB {
    @Test
    fun `zlib inflate and deflate`() {
        val text = "Hello, this is a test string."
        val compressed = zlibDeflate(text.encodeToByteArray())

        assertEquals(
            expected = "[31, -117, 8, 0, 0, 0, 0, 0, 0, 19, -13, 72, -51, -55, -55, -41, 81, 40, -55, -56, 44, 86, 0, -94, 68, -123, -110, -44, -30, 18, -123, -30, -110, -94, -52, -68, 116, 61, 0, 20, -121, -54]",
            actual = compressed.contentToString(),
        )

        val decompressed = zlibInflate(compressed)
        assertEquals(
            expected = text,
            actual = decompressed.decodeToString(),
        )
    }
}
