package ua.edu.znu.app.database.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentDateTime
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object LogsTable : Table("logs") {
    val id = integer("id").autoIncrement()
    val endpoint = varchar("endpoint", 255).nullable()
    val method = varchar("method", 255).nullable()
    val log = text("log").nullable()
    val status = integer("status").nullable()
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime)

    override val primaryKey = PrimaryKey(id)
}