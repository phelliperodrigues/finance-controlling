package application.domain.repositories

import application.domain.entity.User

interface UserRepository<T> {

    fun save(user: User): User?
}
