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
    mainClass = "ua.edu.znu.MainKt"
}

dependencies {
    // Ktor server
    implementation("io.ktor:ktor-server-cors")
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-host-common")
    implementation("io.ktor:ktor-server-status-pages")
    implementation("io.ktor:ktor-server-call-logging")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-server-netty")
    implementation("io.ktor:ktor-server-double-receive")

    // Kotlinx Serialization
    implementation("io.ktor:ktor-serialization-kotlinx-json")
    implementation("io.ktor:ktor-serialization-jackson")

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.19.+")

    // Koin
    implementation("io.insert-koin:koin-ktor:4.0.3")

    // Jasper Reports
    implementation("net.sf.jasperreports:jasperreports:6.21.5") {
        // Exclude problematic transitive dependencies
        exclude(group = "com.lowagie", module = "itext")
        exclude(group = "eclipse")
    }

    // Database
    implementation("org.xerial:sqlite-jdbc:3.49.1.0")
    implementation("org.jetbrains.exposed:exposed-core:0.61.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.61.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.61.0")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:0.61.0")

    // Fonts
    implementation(files("fonts/jasperreports-fonts.jar"))

    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
