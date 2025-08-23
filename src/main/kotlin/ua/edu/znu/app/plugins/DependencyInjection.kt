package ua.edu.znu.app.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import ua.edu.znu.app.controllers.ReportsController
import ua.edu.znu.app.services.JasperReportsService
import ua.edu.znu.app.services.ReportsGeneratorService

fun Application.configureDependencyInjection() {
    install(Koin) {
        modules(appModule)
    }
}

val appModule = module {
    single { JasperReportsService() }
    single { ReportsGeneratorService(get()) } // Inject JasperReportsService
    single { ReportsController(get()) } // Inject ReportsGeneratorService
}
