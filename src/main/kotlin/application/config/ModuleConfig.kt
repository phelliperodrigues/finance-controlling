package application.config;

import application.domain.entity.User
import application.domain.repositories.UserRepository
import application.domain.repositories.imp.UserRepositoryImp
import org.koin.core.context.GlobalContext.get
import org.koin.core.qualifier.named
import org.koin.dsl.module

object ModulesConfig {

    private val configModule = module {
        single { JwtProvider() }
        single { AuthConfig(get()) }
        single { Router() }
    }
    private val userModule = module {
        single<UserRepository<User>>(named("user_repository")) { UserRepositoryImp() }

//        single { UserController(get()) }
//        single { UserServiceImp(get(), get(named("user_repository"))) }
    }

    internal val allModules = listOf(ModulesConfig.configModule, ModulesConfig.userModule)
}
