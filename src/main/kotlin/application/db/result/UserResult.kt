package application.db.result

import application.db.schema.UserSchema
import application.domain.entity.User
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toUser(): User = User(
    id = get(UserSchema.id),
    name = get(UserSchema.name),
    email = get(UserSchema.email),
    password = get(UserSchema.password),
    passwordConfirmation = get(UserSchema.passwordConfirmation),
    createDate = get(UserSchema.createDate)
)