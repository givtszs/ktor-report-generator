package ua.edu.znu.app.plugins

import io.ktor.server.application.Application
import org.jetbrains.exposed.sql.Database
import ua.edu.znu.app.database.factories.DatabaseFactory

fun Application.configureSqliteDatabase() {
    val dbName = environment.config.property("ktor.database.db_name").getString()
    val dbPath = environment.config.property("ktor.database.db_path").getString()

    Database.connect("jdbc:sqlite:${dbPath}/${dbName}", "org.sqlite.JDBC")

    DatabaseFactory.init()
}