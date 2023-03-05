package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var costOfService: AppCompatEditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        costOfService = binding.etCostOfService

        with(binding){

            btnSubmit.setOnClickListener {
                var tipAmount: Int = 0
                println("Cost of Service is ${costOfService.text}")
                var price: String = costOfService.text.toString()

                if(price.toInt() != 0){
                    when(radioGroup.checkedRadioButtonId) {
                        R.id.twenty -> {
                            tipAmount = price.toInt()*20/100
                            println(tipAmount)
                        }
                        R.id.eighteen -> {
                            tipAmount = price.toInt()*18/100
                            println(tipAmount)
                        }
                        R.id.fifteen -> {
                            tipAmount = price.toInt()*15/100
                            println(tipAmount)
                        }
                    }

                }
                else
                {
                    Toast.makeText(this@MainActivity , "Please Enter the Cost of Service", Toast.LENGTH_SHORT).show()
                }
                if(switchTip.isChecked){
                    tipAmount = kotlin.math.ceil(tipAmount.toDouble()).toInt()
                }
                tvTipCalculated.text = "Tip Amount: ₹$tipAmount"
            }
        }
    }
}