package Torres.Felipe.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var num1: Int = 0
    var num2: Int = 0
    var operacion: Int = 0
    val txt_calcular: TextView = findViewById(R.id.Text_Calcular)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt_respuesta: TextView = findViewById(R.id.Text_Respuesta)

        val button_numero0: Button = findViewById(R.id.btn_Numero0)
        val button_numero1: Button = findViewById(R.id.btn_Numero1)
        val button_numero2: Button = findViewById(R.id.btn_Numero2)
        val button_numero3: Button = findViewById(R.id.btn_Numero3)
        val button_numero4: Button = findViewById(R.id.btn_Numero4)
        val button_numero5: Button = findViewById(R.id.btn_Numero5)
        val button_numero6: Button = findViewById(R.id.btn_Numero6)
        val button_numero7: Button = findViewById(R.id.btn_Numero7)
        val button_numero8: Button = findViewById(R.id.btn_Numero8)
        val button_numero9: Button = findViewById(R.id.btn_Numero9)

        val button_sumar: Button = findViewById(R.id.btn_Sumar)
        val button_multiplicar: Button = findViewById(R.id.btn_Multiplicar)
        val button_restar: Button = findViewById(R.id.btn_Restar)
        val button_dividir: Button = findViewById(R.id.btn_Dividir)
        val button_resultado: Button = findViewById(R.id.btn_Resultado)
        val button_borrar: Button = findViewById(R.id.btn_Borrar)

        button_numero0.setOnClickListener(){numeroPresionado("0")}
        button_numero1.setOnClickListener(){numeroPresionado("1")}
        button_numero2.setOnClickListener(){numeroPresionado("2")}
        button_numero3.setOnClickListener(){numeroPresionado("3")}
        button_numero4.setOnClickListener(){numeroPresionado("4")}
        button_numero5.setOnClickListener(){numeroPresionado("5")}
        button_numero6.setOnClickListener(){numeroPresionado("6")}
        button_numero7.setOnClickListener(){numeroPresionado("7")}
        button_numero8.setOnClickListener(){numeroPresionado("8")}
        button_numero9.setOnClickListener(){numeroPresionado("9")}

        button_sumar.setOnClickListener(){operacionPresionada(SUMA)}
        button_restar.setOnClickListener(){operacionPresionada(RESTA)}
        button_multiplicar.setOnClickListener(){operacionPresionada(MULTIPLICACION)}
        button_dividir.setOnClickListener(){operacionPresionada(DIVISION)}

        button_borrar.setOnClickListener(){
            num1 = 0
            num2 = 0
            txt_respuesta.text = "0"
            this.operacion = NO_OPERACION
        }
        button_resultado.setOnClickListener(){
            var resultado = when(operacion){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0
            }

            txt_respuesta.text = resultado.toString()
        }
    }

    fun numeroPresionado(numero: String){
        txt_calcular.text = "${txt_calcular.text}$numero"

        if(operacion == NO_OPERACION){
            num1 = txt_calcular.text.toString().toInt()
        }else {
            num2 = txt_calcular.text.toString().toInt()
        }


    }

    fun operacionPresionada(operacion: Int){
        this.operacion = operacion

        num1 = txt_calcular.text.toString().toInt()

        txt_calcular.text = "0"
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }


}