package application.domain.repositories

import application.domain.build.UserRequestBuild
import application.domain.repositories.config.RepositoryBase
import application.domain.repositories.imp.UserRepositoryImp
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class UserRepositoryTest : RepositoryBase() {

    private val userBuild = UserRequestBuild.build().toModel()

    private val userRepository = UserRepositoryImp()

    @Test
    fun `Should save a user`() {
        val response = userRepository.save(userBuild)
        assertNotNull(response)
    }

    @Test
    fun `Should return a user by email`() {
        userRepository.save(userBuild)
        val response = userRepository.findByEmail(userBuild.email)
        assertNotNull(response)
    }

    @Test
    fun `Should dont return a user by email`() {
        val response = userRepository.findByEmail(userBuild.email)
        assertNull(response)
    }
}
