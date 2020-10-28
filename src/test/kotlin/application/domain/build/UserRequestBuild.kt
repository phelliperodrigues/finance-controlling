package application.domain.build

import application.api.domain.UserRequest
import com.github.javafaker.Faker

class UserRequestBuild {
    private var faker = Faker()

    private val id = faker.internet().uuid()
    private val email = faker.internet().emailAddress().toString()
    private val name = faker.name().fullName().toString()
    private val password = faker.lorem().characters(6).toString()
    private val passwordConfirmation = password
    private val bio = faker.lorem().paragraph().toString()

    companion object {
        fun build(user: UserRequestBuild = UserRequestBuild()): UserRequest =
            UserRequest(
                id = user.id,
                name = user.name,
                email = user.email,
                password = user.password,
                passwordConfirmation = user.passwordConfirmation
            )
    }
}