package me.devnatan.komprimido

import kotlinx.coroutines.test.runTest
import kotlinx.io.asSource
import java.io.File
import kotlin.test.Test

class ExtractTarTest {

    @Test
    fun extractTar() {
        val input = Komprimido::class.java.getResourceAsStream("/test.tar.gz")

        runTest {
            Komprimido.extractTar(input)
        }
    }

}