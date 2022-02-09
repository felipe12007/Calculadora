package Torres.Felipe.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    var num1: Double = 0.0
    lateinit var txt_num1: TextView
    lateinit var txt_num2: TextView
    var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt_num1 = findViewById(R.id.Text_Respuesta)
        txt_num2 = findViewById(R.id.Text_Calcular)

        val button_resultado: Button = findViewById(R.id.btn_Resultado)
        val button_borrar: Button = findViewById(R.id.btn_Borrar)

        button_resultado.setOnClickListener{
            var num2: Double = txt_num2.text.toString().toDouble()
            var resultado: Double = 0.0

            when(operacion){
                1 -> resultado = num1 + num2
                2 -> resultado = num1 - num2
                3 -> resultado = num1 * num2
                4 -> resultado = num1 / num2
            }

            txt_num1.setText(resultado.toString())
            txt_num1.setText("")
        }

        button_borrar.setOnClickListener{
            txt_num1.setText("")
            txt_num2.setText("")
            num1 = 0.0
            operacion = 0

        }


    }

    fun numeroPresionado(view: View){

        var num2: String = txt_num2.text.toString()

        when(view.id) {
            R.id.btn_Numero0 -> txt_num2.setText(num2 + "0")
            R.id.btn_Numero1-> txt_num2.setText(num2 + "1")
            R.id.btn_Numero2 -> txt_num2.setText(num2 + "2")
            R.id.btn_Numero3 -> txt_num2.setText(num2 + "3")
            R.id.btn_Numero4 -> txt_num2.setText(num2 + "4")
            R.id.btn_Numero5 -> txt_num2.setText(num2 + "5")
            R.id.btn_Numero6 -> txt_num2.setText(num2 + "6")
            R.id.btn_Numero7 -> txt_num2.setText(num2 + "7")
            R.id.btn_Numero8 -> txt_num2.setText(num2 + "8")
            R.id.btn_Numero9 -> txt_num2.setText(num2 + "9")


        }

    }

    fun operacionPresionada(view: View) {

        num1 = txt_num2.text.toString().toDouble()
        var numero2: String = txt_num2.text.toString()
        txt_num2.setText("")
        when (view.id) {

            R.id.btn_Sumar -> {
                txt_num2.setText(numero2 + "+")
                operacion = SUMA
            }
            R.id.btn_Restar -> {
                txt_num2.setText(numero2 + "-")
                operacion = RESTA
            }
            R.id.btn_Multiplicar -> {
                txt_num2.setText(numero2 + "*")
                operacion = MULTIPLICACION
            }
            R.id.btn_Dividir -> {
                txt_num2.setText(numero2 + "/")
                operacion = DIVISION
            }

        }
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }
    }