import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    kotlin("multiplatform") version "1.9.10"
}

group = "me.devnatan"
version = "0.1.0"

repositories {
    mavenCentral()
}

kotlin {
    explicitApi()

    jvm()
    linuxX64()
    macosArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.3.0")
            }
        }
        val nativeMain by creating { dependsOn(commonMain) }

        // Android and Linux targets
        val nixMain by creating { dependsOn(nativeMain) }
        val linuxX64Main by getting { dependsOn(nixMain) }

        // macOS and iOS targets
        val appleMain by creating { dependsOn(nativeMain) }
        val macosArm64Main by getting { dependsOn(appleMain) }
    }

    sourceSets.configureEach {
        configureSourceSet()
    }
}

fun KotlinSourceSet.configureSourceSet() {
    val srcDir = if (name.endsWith("Main")) "src" else "test"
    val platform = name.dropLast(4)
    kotlin.srcDir("$platform/$srcDir".also(::println))

    when (name) {
        "jvmMain" -> resources.srcDir("$platform/resources")
        "jvmTest" -> resources.srcDir("$platform/test-resources")
    }

    languageSettings {
        progressiveMode = true
    }
}