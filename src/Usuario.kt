data class Usuario(
    val nombre: String,
    val edad: Int,
    val altura: Double,
    val peso: Double,
    val email: String,
    val ciudad: String
)
{
    fun calcularIMC(): Double = peso / (altura * altura)

    fun esMayorEdad(): Boolean = edad >= 18

    fun obtenerDominioEmail(): String = email.substringAfter("@")

    fun resumenUsuario(): String = """
        ➤ Resumen de Usuario:
        Nombre: $nombre
        Edad: $edad años
        Altura: $altura m
        Peso: $peso kg
        IMC: ${"%.2f".format(calcularIMC())}
        Email: $email
        Ciudad: $ciudad
        Mayor de edad: ${esMayorEdad()}
        Dominio Email: ${obtenerDominioEmail()}
    """.trimIndent()
}