package me.devnatan.komprimido

import kotlinx.io.Buffer

// https://tools.ietf.org/html/rfc1952
internal expect fun gzip(data: Buffer)