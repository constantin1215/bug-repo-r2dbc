package diss.vali.testms.user

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("appUser")
data class User(
    @Id
    val id: String = UUID.randomUUID().toString(),

    @Size(min = 8, max = 24)
    val username: String,

    @Email
    val email: String,

    @NotBlank
    val password: String
) {
    override fun toString(): String {
        return "User(id=$id, username='$username', email='$email')"
    }
}