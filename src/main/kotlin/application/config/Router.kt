package application.config

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.core.security.SecurityUtil
import io.javalin.http.Context
import org.koin.core.KoinComponent

class Router(
) : KoinComponent {

    fun register(app: Javalin) {
        val rolesOptionalAuthenticated = SecurityUtil.roles(Roles.ANYONE, Roles.AUTHENTICATED)

        app.routes {
            path("/") {
                get(this::helloWorld, SecurityUtil.roles(Roles.ANYONE))
            }
        }
    }
    private fun helloWorld(ctx: Context) {
        ctx.result("Hello World")
    }
}


