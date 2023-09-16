package me.devnatan.kompress

import kotlinx.coroutines.test.runTest
import kotlinx.io.asSource
import java.io.File
import kotlin.test.Test

class ExtractTarTest {

    @Test
    fun extractTar() {
        val input = Kompress::class.java.getResourceAsStream("/test.tar.gz")

        runTest {
            Kompress.extractTar(input)
        }
    }

}