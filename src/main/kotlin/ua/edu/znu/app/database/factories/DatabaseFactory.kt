package ua.edu.znu.app.database.factories

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import ua.edu.znu.app.database.tables.LogsTable

object DatabaseFactory {
    fun init() {
        transaction {
            SchemaUtils.create(LogsTable)
        }
    }
}