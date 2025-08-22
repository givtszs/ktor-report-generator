val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.1.10"
    id("io.ktor.plugin") version "3.2.3"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.10"
}

group = "ua.edu.znu"
version = "0.0.1"

application {
    mainClass = "ua.edu.znu.ApplicationKt"
}

dependencies {
    implementation("io.ktor:ktor-server-cors")
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-host-common")
    implementation("io.ktor:ktor-server-status-pages")
    implementation("io.ktor:ktor-server-call-logging")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-server-netty")

    // Kotlinx Serialization
    implementation("io.ktor:ktor-serialization-kotlinx-json")
    implementation("io.ktor:ktor-serialization-jackson")

    // Jasper Reports
    implementation("net.sf.jasperreports:jasperreports:6.21.5") {
        // Exclude problematic transitive dependencies
        exclude(group = "com.lowagie", module = "itext")
        exclude(group = "eclipse")
    }

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.19.+")

    // Fonts
    implementation(files("fonts/jasperreports-fonts.jar"))

    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
