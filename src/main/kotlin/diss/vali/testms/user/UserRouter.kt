package diss.vali.testms.user

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicate
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration
class UserRouter {
    private val ACCEPT_JSON: RequestPredicate = accept(MediaType.APPLICATION_JSON)

    @Bean
    fun userRoutes(userHandler: UserHandler): RouterFunction<ServerResponse> {
        return route()
            .POST("/user", ACCEPT_JSON, userHandler::register)
            .build()
    }
}