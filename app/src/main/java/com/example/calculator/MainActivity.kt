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

        binding.one.setOnClickListener {
            appendExpression("1")
        }

        binding.two.setOnClickListener {
            appendExpression("2")
        }

        binding.three.setOnClickListener {
            appendExpression("3")
        }

        binding.four.setOnClickListener {
            appendExpression("4")
        }

        binding.five.setOnClickListener {
            appendExpression("5")
        }

        binding.six.setOnClickListener {
            appendExpression("6")
        }

        binding.seven.setOnClickListener {
            appendExpression("7")
        }

        binding.eight.setOnClickListener {
            appendExpression("8")
        }

        binding.nine.setOnClickListener {
            appendExpression("9")
        }

        binding.zero.setOnClickListener {
            appendExpression("0")
        }

        binding.plus.setOnClickListener {
            appendExpression("+")
        }

        binding.minus.setOnClickListener {
            appendExpression("-")
        }

        binding.multiplication.setOnClickListener {
            appendExpression("*")
        }

        binding.divide.setOnClickListener {
            appendExpression("/")
        }
        binding.percent.setOnClickListener {
            appendExpression("/100")
        }
        binding.doubleZero.setOnClickListener {
            appendExpression("00")
        }

        binding.dot.setOnClickListener {
            appendExpression(".")
        }

        binding.clear.setOnClickListener {
            expression = ""
            binding.tvExpression.text = ""
            binding.tvResult.text = ""
        }

        binding.del.setOnClickListener {
            if (expression.isNotEmpty()) {
                expression = expression.substring(0, expression.length - 1)
                binding.tvExpression.text = expression
            }
            binding.tvResult.text = ""
        }

        binding.equal.setOnClickListener {
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
