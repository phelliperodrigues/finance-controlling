package application.api

import application.api.exceptions.ErrorExceptionMapping
import application.config.AuthConfig
import application.config.Router
import application.db.schema.UserSchema
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.javalin.Javalin
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.KoinComponent
import org.koin.core.inject

object Init : KoinComponent {
    private val router: Router by inject()
    private val authConfig: AuthConfig by inject()

    fun start(port: Int): Javalin {
        Database.connect(hikari())
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(UserSchema)
        }

        val newPort = System.getenv("PORT")?.toIntOrNull() ?: port

        val app = Javalin.create().apply {
            exception(Exception::class.java) { e, _ -> e.printStackTrace() }
            error(404) { ctx -> ctx.result("Not found") }
        }.start(newPort)

        router.register(app)
        authConfig.configure(app)
        ErrorExceptionMapping.register(app)

        return app
    }

    private fun hikari(): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.h2.Driver"
        config.jdbcUrl = "jdbc:h2:mem:app"
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.validate()

        return HikariDataSource(config)
    }
}