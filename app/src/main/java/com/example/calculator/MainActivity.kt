package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var expression = ""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvOne.setOnClickListener {
            appendExpression("1")
        }

        binding.tvTwo.setOnClickListener {
            appendExpression("2")
        }

        binding.tvThree.setOnClickListener {
            appendExpression("3")
        }

        binding.tvFour.setOnClickListener {
            appendExpression("4")
        }

        binding.tvFive.setOnClickListener {
            appendExpression("5")
        }

        binding.tvSix.setOnClickListener {
            appendExpression("6")
        }

        binding.tvSeven.setOnClickListener {
            appendExpression("7")
        }

        binding.tvEight.setOnClickListener {
            appendExpression("8")
        }

        binding.tvNine.setOnClickListener {
            appendExpression("9")
        }

        binding.tvZero.setOnClickListener {
            appendExpression("0")
        }

        binding.tvPlus.setOnClickListener {
            appendExpression("+")
        }

        binding.tvMinus.setOnClickListener {
            appendExpression("-")
        }

        binding.tvMul.setOnClickListener {
            appendExpression("*")
        }

        binding.tvDivide.setOnClickListener {
            appendExpression("/")
        }

        binding.tvDot.setOnClickListener {
            appendExpression(".")
        }

        binding.tvClear.setOnClickListener {
            expression = ""
            binding.tvExpression.text = ""
            binding.tvResult.text = ""
        }

        binding.tvBack.setOnClickListener {
            if (expression.isNotEmpty()) {
                expression = expression.substring(0, expression.length - 1)
                binding.tvExpression.text = expression
            }
            binding.tvResult.text = ""
        }

        binding.tvEquals.setOnClickListener {
            if (expression.isNotEmpty()) {
                try {
                    val result = ExpressionBuilder(expression).build().evaluate()
                    binding.tvResult.text = result.toString()
                } catch (e: Exception) {
                    binding.tvResult.text = "Error"
                }
            }
        }
    }

    private fun appendExpression(string: String) {
        expression += string
        binding.tvExpression.append(string)
        binding.tvResult.text = ""
    }
}
