package application.domain.entity

import org.joda.time.DateTime
import java.util.UUID

data class User(
    val id: UUID? = null,
    val email: String,
    var token: String? = null,
    val name: String? = null,
    val password: String? = null,
    val passwordConfirmation: String? = null,
    val createDate: DateTime? = null
)
