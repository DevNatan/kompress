package me.devnatan.komprimido

import kotlinx.io.Buffer

internal expect fun tarImpl(data: Buffer): Buffer

internal expect fun untarImpl(data: Buffer): Buffer