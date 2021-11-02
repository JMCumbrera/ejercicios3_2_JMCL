import kotlin.math.pow

class Persona(var DNI: String) {
    private var nombre: String = ""
    private var edad: Int = 0
    private var sexo: String = "H"
    private var peso: Double = 0.0
    private var altura:Double = 0.0
    private var res: Int = 0
    private var imc: Double = 0.0
    private var pesoideal: String = ""

    fun name(n: String) {
        nombre = n
    }

    fun age(a:Int) {
        edad = a
    }

    fun checkSex(s:String) {
        sexo = s
        if (sexo != "H" && sexo != "M" || sexo == "") {
            sexo = "H"
        }
    }

    fun genDNI() {
        val number = (11111111..99999999).random().toString()
        val letter = (('A'..'Z') + 'Z').random()
        DNI = number + letter
    }

    fun calcIMC(ps:Double,alt:Double) {
        peso = ps
        altura = alt

        imc = peso / (altura.pow(2.0))

        when {
            imc < 20.0 -> res = -1
            imc in 20.0..25.0 -> res = 0
            imc > 25.0 -> res = 1
        }
        when (res) {
            0 -> {
                pesoideal = "está vd. en su peso ideal"
            }
            1 -> {
                pesoideal = "tiene vd. sobrepeso"
            }
            -1 -> {
                pesoideal = "está vd. por debajo de su peso ideal"
            }
        }
    }

    fun esMayordeEdad(ed:Int): Boolean {
        edad = ed
        return edad >= 18
    }

    override fun toString(): String {
        val sex:String = if (sexo == "H") {
            "hombre"
        } else {
            "mujer"
        }

        return ("Vd. es $nombre, de género $sex, tiene $edad años, pesa $peso kg, mide $altura metros, su DNI es $DNI y $pesoideal y $imc")
    }
}

fun main() {
    val p = Persona("49078667W")
    p.name("Juan Manuel Cumbrera López")
    p.age(26)
    p.checkSex("H")
    p.genDNI()
    p.calcIMC(73.0,1.72)
    p.esMayordeEdad(26)
    println(p.toString())
}