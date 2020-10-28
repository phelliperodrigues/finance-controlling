package application.api.domain

import application.domain.entity.User
import org.joda.time.DateTime

data class UserRequest(
    val id: String? = null,
    val email: String? = null,
    val name: String? = null,
    val password: String? = null,
    val passwordConfirmation: String? = null,
    val token: String? = null
) {
    constructor() : this(email = "", name = "", password = "", passwordConfirmation = "")

    fun toModel(): User = User(
        name = this.name,
        email = this.email!!,
        password = this.password,
        passwordConfirmation = this.passwordConfirmation,
        createDate = DateTime.now()
    )
}
