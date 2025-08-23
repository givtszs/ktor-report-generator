package ua.edu.znu.bootstrap

import io.ktor.server.application.*
import ua.edu.znu.app.plugins.*

fun Application.module() {
    configureDependencyInjection()
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureRouting()
}
