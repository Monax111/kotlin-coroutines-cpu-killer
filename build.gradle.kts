plugins {
    kotlin("jvm") version "1.7.10"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "io.github.microutils", name = "kotlin-logging", version = "2.1.23")
    val coroutinesVersion = "1.6.4"
    implementation(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-coroutines-core",
        version = coroutinesVersion
    )
    implementation(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-coroutines-core-jvm",
        version = coroutinesVersion
    )
    implementation(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-coroutines-reactor",
        version = coroutinesVersion
    )
    implementation(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-coroutines-debug",
        version = coroutinesVersion
    )
}
