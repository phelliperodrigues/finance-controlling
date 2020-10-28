package application.db.schema

import org.jetbrains.exposed.sql.Table

object UserSchema : Table() {
    val id = uuid("id").primaryKey()
    val email = varchar("email", 100)
    val token = varchar("token", 3000).nullable()
    val name = varchar("name", 100)
    val password = varchar("password", 200)
    val passwordConfirmation = varchar("password_confirmation", 200)
    val createDate = datetime("create_date")
}
