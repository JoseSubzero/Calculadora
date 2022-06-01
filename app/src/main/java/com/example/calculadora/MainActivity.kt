package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calculadora.databinding.ActivityMainBinding
import kotlin.math.atan2

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var n1 = 0
    private var n2 = 0
    private var op = NO_OP
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        binding.tvPantalla.text = "0"

        binding.buttonClear.setOnClickListener {
            binding.tvPantalla.text = "0"
            n1 = 0
            n2 = 0
        }
        binding.opSum.setOnClickListener {
            n1 = binding.tvPantalla.text.toString().toInt()
            op = SUMA
            binding.tvPantalla.text = "0"
        }
        binding.opRest.setOnClickListener {
            n1 = binding.tvPantalla.text.toString().toInt()
            op = RESTA
            binding.tvPantalla.text = "0"
        }
        binding.opMult.setOnClickListener {
            n1 = binding.tvPantalla.text.toString().toInt()
            op = MULTIPLICACION
            binding.tvPantalla.text = "0"
        }
        binding.opDiv.setOnClickListener {
            n1 = binding.tvPantalla.text.toString().toInt()
            op = DIVISION
            binding.tvPantalla.text = "0"
        }

        binding.buttonIgual.setOnClickListener {
            n2 = binding.tvPantalla.text.toString().toInt()
            val result = when(op){
                SUMA -> n1 + n2
                RESTA -> n1 - n2
                MULTIPLICACION -> n1 * n2
                DIVISION -> n1 / n2
                else -> 0
            }
            binding.tvPantalla.text = result.toString()
        }

        binding.button0.setOnClickListener {
            pressNum("0")
        }
        binding.button1.setOnClickListener {
            pressNum("1")
        }
        binding.button2.setOnClickListener {
            pressNum("2")
        }
        binding.button3.setOnClickListener {
            pressNum("3")
        }
        binding.button4.setOnClickListener {
            pressNum("4")
        }
        binding.button5.setOnClickListener {
            pressNum("5")
        }
        binding.button6.setOnClickListener {
            pressNum("6")
        }
        binding.button7.setOnClickListener {
            pressNum("7")
        }
        binding.button8.setOnClickListener {
            pressNum("8")
        }
        binding.button9.setOnClickListener {
            pressNum("9")
        }
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OP = 0
    }

    fun pressNum(n:String){
        if (binding.tvPantalla.text.length < 9)
        binding.tvPantalla.text = binding.tvPantalla.text.toString().plus(n).toInt().toString()
    }
}