package application.domain.repositories

import application.domain.entity.User

interface UserRepository<T> {

    fun save(entity: User): User?
}
