package application.domain.repositories

import application.domain.build.UserRequestBuild
import application.domain.repositories.config.RepositoryBase
import application.domain.repositories.imp.UserRepositoryImp
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class UserRepositoryTest : RepositoryBase() {

    private val userBuild = UserRequestBuild.build().toModel()

    private val userRepository = UserRepositoryImp()
    @Test
    fun `Should save a user`() {
        val response = userRepository.save(userBuild)
        assertNotNull(response)
    }
}
