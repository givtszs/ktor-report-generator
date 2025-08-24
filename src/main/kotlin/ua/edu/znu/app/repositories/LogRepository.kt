package ua.edu.znu.app.repositories

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync
import ua.edu.znu.app.database.tables.LogsTable
import ua.edu.znu.app.dto.CreateLogDto

object LogRepository {
    suspend fun createLog(logDto: CreateLogDto) {
        suspendedTransactionAsync {
            LogsTable.insert {
                it[LogsTable.endpoint] = logDto.endpoint
                it[LogsTable.method] = logDto.method
                it[LogsTable.log] = logDto.log
                it[LogsTable.status] = logDto.status
                it[LogsTable.createdAt] = Clock.System.now().toLocalDateTime(TimeZone.UTC)
            }
        }
    }
}