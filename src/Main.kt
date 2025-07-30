fun main() {
    println("Registro de Usuarios")

    val usuarios = mutableListOf<Usuario>()

    var i = 1
    repeat(3) {
        println("Ingrese los datos del Usuario #$i")

        print("Nombre completo: ")
        val nombre = readLine()!!.trim()

        print("Edad: ")
        val edad = readLine()!!.toIntOrNull()
        if (edad == null || edad <= 0) {
            println("Edad inválida. Debe ser mayor que 0.")
            return@repeat
        }

        print("Altura (m): ")
        val altura = readLine()!!.toDoubleOrNull()
        if (altura == null || altura <= 0.0) {
            println("Altura inválida. Debe ser mayor que 0.")
            return@repeat
        }

        print("Peso (kg): ")
        val peso = readLine()!!.toDoubleOrNull()
        if (peso == null || peso <= 0.0) {
            println("Peso inválido. Debe ser mayor que 0.")
            return@repeat
        }

        print("Email: ")
        val email = readLine()!!.trim()
        if (!email.contains("@") || !email.contains(".")) {
            println("Email inválido. Debe contener '@' y '.'")
            return@repeat
        }

        print("Ciudad de residencia: ")
        val ciudad = readLine()!!.trim()

        val usuario = Usuario(nombre, edad, altura, peso, email, ciudad)
        usuarios.add(usuario)

        i++
    }

    println("Información de Usuarios Registrados:")

    usuarios.forEachIndexed { index, u ->
        println("Usuario #${index + 1}")
        println("Nombre (original): ${u.nombre}")
        println("Nombre en MAYÚSCULAS: ${u.nombre.uppercase()}")
        println("Nombre en minúsculas: ${u.nombre.lowercase()}")
        println("Edad: ${u.edad} años - ${if (u.esMayorEdad()) "Mayor de edad" else "Menor de edad"}")
        println("Altura: ${u.altura} m")
        println("Peso: ${u.peso} kg")
        println("IMC: ${"%.2f".format(u.calcularIMC())}")
        println("Email: ${u.email} - Dominio: ${u.obtenerDominioEmail()}")
        println("Ciudad: ${u.ciudad}")
        println("Resumen: ${u.resumenUsuario()}")
        println("─────────────────────────────")
    }
}
