package com.gm.jokenpo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var ganhoHumano = 0
    private var ganhoCPU = 0

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPedra = findViewById<AppCompatImageButton>(R.id.btnPedra)
        val btnPapel = findViewById<AppCompatImageButton >(R.id.btnPapel)
        val btnTesoura = findViewById<AppCompatImageButton >(R.id.btnTesoura)
        val btnNew = findViewById<Button>(R.id.btnNew)
        val escolha = findViewById<TextView>(R.id.escolha)
        val escolhaCPU = findViewById<TextView>(R.id.escolhaCPU)
        val resultado = findViewById<TextView>(R.id.resultado)
        val placar = findViewById<TextView>(R.id.placar)

        var escolhaHumano: Int?

        btnPedra.setOnClickListener{
            escolhaHumano=0
            escolha.text="Sua escolha foi: Pedra"
            jogo(escolhaHumano,resultado,escolhaCPU,placar)
            btnPedra.isClickable = false
            btnPapel.isClickable = false
            btnTesoura.isClickable = false

        }
        btnPapel.setOnClickListener{
            escolhaHumano=1
            escolha.text="Sua escolha foi: Papel"
            jogo(escolhaHumano,resultado,escolhaCPU,placar)
            btnPedra.isClickable = false
            btnPapel.isClickable = false
            btnTesoura.isClickable = false
        }
        btnTesoura.setOnClickListener{
            escolhaHumano=2
            escolha.text="Sua escolha foi: Tesoura"
            jogo(escolhaHumano,resultado,escolhaCPU,placar)
            btnPedra.isClickable = false
            btnPapel.isClickable = false
            btnTesoura.isClickable = false
        }
        btnNew.setOnClickListener{
            escolhaHumano=null
            escolha.text="Sua escolha foi:"
            escolhaCPU.text="A escolha da CPU foi:"
            resultado.text=""
            btnPedra.isClickable = true
            btnPapel.isClickable = true
            btnTesoura.isClickable = true
        }

    }

    private fun jogo(escolhaHumano: Int?, resultado: TextView, escolhaCPU: TextView, placar: TextView){
        if (escolhaHumano != null && escolhaHumano in listOf(0, 1, 2)) {
            var escolhaComputador: Int = Random.nextInt(0, 3)
            if(escolhaComputador == 0){
                escolhaCPU.text="A escolha da CPU foi: Pedra"
            }
            else if(escolhaComputador == 1){
                escolhaCPU.text="A escolha da CPU foi: Papel"
            }
            else{
                escolhaCPU.text="A escolha da CPU foi: Tesoura"
            }
            if (escolhaHumano == escolhaComputador) {
                resultado.text="Empate"
            } else if (
                (escolhaHumano == 0 && escolhaComputador == 2) ||
                (escolhaHumano == 1 && escolhaComputador == 0) ||
                (escolhaHumano == 2 && escolhaComputador == 1)
            ) {
                resultado.text="Você venceu"
                ganhoHumano += 1
            } else {
                resultado.text="CPU venceu"
                ganhoCPU += 1
            }
            placar.text="Você X CPU \n ${ganhoHumano}:${ganhoCPU}"
        }
    }

}


