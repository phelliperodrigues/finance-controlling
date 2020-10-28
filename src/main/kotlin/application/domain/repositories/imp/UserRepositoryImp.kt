package application.domain.repositories.imp

import application.db.schema.UserSchema
import application.domain.entity.User
import application.domain.repositories.UserRepository
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.core.KoinApplication.Companion.logger
import java.util.UUID

class UserRepositoryImp : UserRepository<User> {

    override fun save(entity: User): User = transaction {
        val result = UserSchema.insert {
            it[id] = UUID.randomUUID()
            it[name] = entity.name!!
            it[email] = entity.email
            it[password] = entity.password!!
            it[passwordConfirmation] = entity.passwordConfirmation!!
            it[token] = entity.token
            it[createDate] = entity.createDate!!
        }
        logger.info("Save user with success! With ID: $UserSchema.id ")
        entity.copy(id = result[UserSchema.id])
    }
}
