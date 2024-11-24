package diss.vali.testms.user

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.*

@Repository
interface UserRepository : ReactiveCrudRepository<User, UUID> {

    fun findByEmail(email: String): Mono<User>

    fun findByUsername(username: String): Mono<User>
}