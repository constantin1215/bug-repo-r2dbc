package diss.vali.testms.user

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class UserHandler(private val userRepository: UserRepository) {
    fun register(request: ServerRequest): Mono<ServerResponse> {
        return request.bodyToMono(RegisterDTO::class.java)
            .flatMap { registerDTO ->
                userRepository.save(
                    User(
                        username = registerDTO.username,
                        email = registerDTO.email,
                        password = registerDTO.password
                    )
                )
            }
            .flatMap { ServerResponse.status(201).bodyValue(it) }
    }
}