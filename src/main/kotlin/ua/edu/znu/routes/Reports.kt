package ua.edu.znu.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import ua.edu.znu.app.controllers.ReportsController
import ua.edu.znu.app.request_payloads.SettlementReportPayload

fun Application.configureReportsRoutes() {
    val reportsController by inject<ReportsController>()

    routing {
        route("/reports") {
            get("health") {
                call.respondText("OK")
            }

            post("/settlement-report") {
                try {
                    val payload = call.receive<SettlementReportPayload>()
                    val reportBytes = reportsController.getSettlementReport(payload)

                    call.response.header(
                        HttpHeaders.ContentDisposition,
                        "attachment; filename=\"placement_order.pdf\"" // file name will primarily come from the backend
                    )

                    call.respondBytes(
                        reportBytes,
                        contentType = ContentType.Application.Pdf,
                        status = HttpStatusCode.OK
                    )
                } catch (exception: Exception) {
                    call.respondText(
                        text = "Error 500: ${exception.message}",
                        status = HttpStatusCode.InternalServerError
                    )
                }
            }
        }
    }
}
