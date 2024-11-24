package diss.vali.testms.user

data class RegisterDTO(
    val username: String,
    val email: String,
    val password: String
) {
    override fun toString(): String {
        return "RegisterDTO(username='$username', email='$email', password='$password')"
    }
}