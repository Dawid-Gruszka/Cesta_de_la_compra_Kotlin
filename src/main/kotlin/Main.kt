import java.text.SimpleDateFormat
import java.util.Calendar

fun main() {
    menuPrincipal()
}

fun menuPrincipal() {
    do {
        println("----------------------------------------------")
        println("¿Que desea hacer?")
        println("1-Realizar Compra")
        println("2-Imprimir Factura")
        println("3-Salir")
        println("----------------------------------------------")
        val seleccion = readln().toIntOrNull()?: -1
        when (seleccion) {
            1-> menuFactura(menuCompra())
            2-> {println("Error, primero debe realizar una compra")
                menuPrincipal()}
            3-> salir()
            else -> println("Error debe introducir un numero entre 1 y 3")
        }
    } while (seleccion !in 1..3)
}

fun menuCompra(): Compra {
    val cart = Compra()
    println("Cargando menu de compra .... ")
    Thread.sleep(1000)
    do {
        do {
        println("----------------------------------------------")
        println("¿Que desea añadir a la cesta de la compra?")
        println("1-Pan Precio:0,5€/u")
        println("2-Agua Precio:0,3€/u")
        println("3-Azúcar Precio:2,4€/u")
        println("4-Leche Precio:1,5€/u")
        println("5-Salir")
        println("----------------------------------------------")
        println("¿Que opción eliges?")
        val item = readln().toIntOrNull()?: -1
        var unidad: Int
        do {
        println("¿Cuantas unidades quieres?")
        unidad = readln().toIntOrNull()?: -1
        } while (unidad < 1)
        when (item) {
            1 -> cart.addItem("Pan", 0.5 * unidad)
            2 -> cart.addItem("Agua", 0.3 * unidad)
            3 -> cart.addItem("Azúcar", 2.4 * unidad)
            4 -> cart.addItem("Leche", 1.5 * unidad)
            5 -> salir()
            else -> println("Error debe introducir un numero entre 1-5")
        }
        } while (item !in 1..5)
        println("¿Quieres añadir algo mas? (si/no)")
        val respuesta = readln().uppercase()
    } while (respuesta == "SI")
    println(cart.getItems())
    println("El precio total es:${cart.getTotalPrice()}")
    do {
        println("¿Quieres eliminar algún objeto? (si/no)")
        val respuesta = readln().uppercase()
        if (respuesta == "SI") {
            println(cart.getItems())
            println("¿Que quieres quitar?")
            val borrar = readln()
            println("¿Cuantos quieres quitar?")
            val cant = readln().toIntOrNull()?: 0
                cart.removeItem(borrar,cant)
            println(cart.getItems())
        }
    } while (respuesta == "SI")


    println("El precio total es:${cart.getTotalPrice()}")
    return cart
}

fun currentDate(): String {
    val current = Calendar.getInstance().time
    val formatter = SimpleDateFormat("dd/MM/yyyy")
    return formatter.format(current)
}

fun menuFactura(menuCompra: Compra) {
    var pago = ""
        println("¿Como quieres pagar?")
        println("1-Con Tarjeta")
        println("2-En efectivo")
    var dinero = 0.0
    var positivo = false
    do {
        val eleccion = readln().toIntOrNull() ?: -1
        if (eleccion == 2) {
            do {
            println("¿Cuanto dinero me das?")
            dinero = readln().toDoubleOrNull()?: 0.0
                if (dinero >= menuCompra.getTotalPrice()) {
                    dinero = (dinero - menuCompra.getTotalPrice())
                    positivo = true
                } else {
                    println("Me tienes que dar mas dinero")
                }
            }while (!positivo)
        }
        when (eleccion) {
            1 -> {
                println("Introduzca el código PIN, ...... Gracias por la compra")
                pago = "Tarjeta"
            }
            2 -> {
                println("Gracias por la compra, aquí tiene su cambio")
                pago = "Efectivo"
            }
            else -> println("Error, introduce un número entre el uno y el 2")
        }
    } while (eleccion !in 1..2)
    println("Imprimiendo Factura")
    Thread.sleep(1000)
    println("---------------------------------------")
    println("Nombre de la Empresa: Food Store")
    println("Numero de Teléfono: 683552178")
    println("Fecha de la compra: ${currentDate()}")
    println("Productos comprados: ${menuCompra.getItems()}")
    println("Método de pago utilizado $pago")
    println("Cambio Recibido: $dinero€")
    println("Aceptamos devoluciones hasta 14 dias naturales, a excepción de productos abiertos")
    println("Gracias por su confianza")
    println("---------------------------------------")
    salir()
}

fun salir() {
    println("Gracias por utilizar este programa")
}
