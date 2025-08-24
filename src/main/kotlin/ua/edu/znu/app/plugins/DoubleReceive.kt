package ua.edu.znu.app.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.doublereceive.DoubleReceive

fun Application.configureDoubleReceive() {
    install(DoubleReceive)
}