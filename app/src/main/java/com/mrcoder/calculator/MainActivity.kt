package com.mrcoder.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator
import android.graphics.Color
import android.view.animation.Animation;
import android.support.v4.app.SupportActivity
import android.support.v4.app.SupportActivity.ExtraData
import android.support.v4.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Operands
        tvOne.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "1",
                canClear = true
            )
        })
        tvTwo.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "2",
                canClear = true
            )
        })
        tvThree.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "3",
                canClear = true
            )
        })
        tvFour.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "4",
                canClear = true
            )
        })
        tvFive.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "5",
                canClear = true
            )
        })
        tvSix.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "6",
                canClear = true
            )
        })
        tvSeven.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "7",
                canClear = true
            )
        })
        tvEight.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "8",
                canClear = true
            )
        })
        tvNine.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "9",
                canClear = true
            )
        })
        tvZero.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "0",
                canClear = true
            )
        })

        //Operators
        tvPlus.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "+",
                canClear = false
            )
        })
        tvMinus.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "-",
                canClear = false
            )
        })
        tvMultiply.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "*",
                canClear = false
            )
        })
        tvDevide.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "/",
                canClear = false
            )
        })
        tvOpenParanthesis.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = "(",
                canClear = false
            )
        })
        tvClosParanthesis.setOnClickListener(View.OnClickListener {
            appendOnExperssion(
                string = ")",
                canClear = false
            )
        })

        tvCancel.setOnClickListener {
            tvResult.text = ""
            tvExpression.text = ""
        }

        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if (string.isNotEmpty()) {
                tvExpression.text = string.substring(0, string.length - 1)
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            } catch (e: Exception) {
                Log.d("Exception", "message : " + e.message)
            }
        }
    }

    fun appendOnExperssion(string: String, canClear: Boolean) {

        if (tvResult.text.isNotEmpty()) {
            tvExpression.text = ""
        }
        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }

}
