package ua.edu.znu.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import ua.edu.znu.app.controllers.ReportsController
import ua.edu.znu.app.dto.CreateLogDto
import ua.edu.znu.app.repositories.LogRepository
import ua.edu.znu.app.request_payloads.EnvelopePayload
import ua.edu.znu.app.request_payloads.SettlementAgreementReportPayload
import ua.edu.znu.app.request_payloads.SettlementReportPayload
import ua.edu.znu.app.request_payloads.TemporaryPassPayload

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
                    val data = payload.data.metadata
                    val reportBytes = reportsController.getSettlementReport(payload)

                    call.response.header(
                        HttpHeaders.ContentDisposition,
                        // file name will primarily come from the backend
                        "attachment; filename=\"Направлення на поселення - ${data.secondName} ${data.firstName} ${data.lastName}.pdf\""
                    )

                    LogRepository.createLog(
                        CreateLogDto(
                            endpoint = "reports/settlement-report",
                            method = "POST",
                            log = payload.toString(),
                            status = 200
                        )
                    )

                    call.respondBytes(
                        reportBytes,
                        contentType = ContentType.Application.Pdf,
                        status = HttpStatusCode.OK
                    )
                } catch (exception: Exception) {
                    LogRepository.createLog(
                        CreateLogDto(
                            endpoint = "reports/settlement-report",
                            method = "POST",
                            log = call.receive<String>(),
                            status = 500
                        )
                    )

                    call.respondText(
                        text = "Error 500: ${exception.message}",
                        status = HttpStatusCode.InternalServerError
                    )
                }
            }

            post("/settlement-agreement-report") {
                try {
                    val payload = call.receive<SettlementAgreementReportPayload>()
                    val data = payload.data.metadata
                    val reportBytes = reportsController.getSettlementAgreementReport(payload)

                    call.response.header(
                        HttpHeaders.ContentDisposition,
                        // file name will primarily come from the backend
                        "attachment; filename=\"Договір - ${data.secondName} ${data.firstName} ${data.lastName}.pdf\""
                    )

                    LogRepository.createLog(
                        CreateLogDto(
                            endpoint = "reports/settlement-agreement-report",
                            method = "POST",
                            log = payload.toString(),
                            status = 200
                        )
                    )

                    call.respondBytes(
                        reportBytes,
                        contentType = ContentType.Application.Pdf,
                        status = HttpStatusCode.OK
                    )
                } catch (exception: Exception) {
                    LogRepository.createLog(
                        CreateLogDto(
                            endpoint = "reports/settlement-agreement-report",
                            method = "POST",
                            log = call.receive<String>(),
                            status = 500
                        )
                    )

                    call.respondText(
                        text = "Error 500: ${exception.message}",
                        status = HttpStatusCode.InternalServerError
                    )
                }
            }

            post("/envelope") {
                try {
                    val payload = call.receive<EnvelopePayload>()
                    val data = payload.data.metadata
                    val reportBytes = reportsController.getEnvelope(payload)

                    call.response.header(
                        HttpHeaders.ContentDisposition,
                        // file name will primarily come from the backend
                        "attachment; filename=\"Конверт - ${data.secondName} ${data.firstName} ${data.lastName}.pdf\""
                    )

                    LogRepository.createLog(
                        CreateLogDto(
                            endpoint = "reports/envelope",
                            method = "POST",
                            log = payload.toString(),
                            status = 200
                        )
                    )

                    call.respondBytes(
                        reportBytes,
                        contentType = ContentType.Application.Pdf,
                        status = HttpStatusCode.OK
                    )
                } catch (exception: Exception) {
                    LogRepository.createLog(
                        CreateLogDto(
                            endpoint = "reports/envelope",
                            method = "POST",
                            log = call.receive<String>(),
                            status = 500
                        )
                    )

                    call.respondText(
                        text = "Error 500: ${exception.message}",
                        status = HttpStatusCode.InternalServerError
                    )
                }
            }

            post("/temporary-pass") {
                try {
                    val payload = call.receive<TemporaryPassPayload>()
                    val data = payload.data.metadata
                    val reportBytes = reportsController.getTemporaryPass(payload)

                    call.response.header(
                        HttpHeaders.ContentDisposition,
                        // file name will primarily come from the backend
                        "attachment; filename=\"Тимчасова перепустка - ${data.secondName} ${data.firstName} ${data.lastName}.pdf\""
                    )

                    LogRepository.createLog(
                        CreateLogDto(
                            endpoint = "reports/temporary-pass",
                            method = "POST",
                            log = payload.toString(),
                            status = 200
                        )
                    )

                    call.respondBytes(
                        reportBytes,
                        contentType = ContentType.Application.Pdf,
                        status = HttpStatusCode.OK
                    )
                } catch (exception: Exception) {
                    LogRepository.createLog(
                        CreateLogDto(
                            endpoint = "reports/temporary-pass",
                            method = "POST",
                            log = call.receive<String>(),
                            status = 500
                        )
                    )

                    call.respondText(
                        text = "Error 500: ${exception.message}",
                        status = HttpStatusCode.InternalServerError
                    )
                }
            }
        }
    }
}
