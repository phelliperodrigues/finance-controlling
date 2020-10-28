package application

import application.api.Init
import application.config.ModulesConfig
import io.javalin.Javalin
import org.koin.core.context.startKoin


object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        startApplication(7000)
    }

    fun startApplication(port: Int): Javalin {
        startKoin {
            modules(ModulesConfig.allModules)
        }

        return Init.start(port)
    }
}