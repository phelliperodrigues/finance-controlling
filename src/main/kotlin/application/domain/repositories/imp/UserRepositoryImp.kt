package application.domain.repositories.imp

import application.domain.entity.User
import application.domain.repositories.UserRepository

class UserRepositoryImp : UserRepository<User> {
    override fun save(user: User): User? {
        return null
    }
}
