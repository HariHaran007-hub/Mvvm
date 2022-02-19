package com.example.mvvmarchitecture.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.data.Quote
import com.example.mvvmarchitecture.utillites.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi(){
        val factory = InjectorUtils.providesQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this , factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes->
            val stringBuilder = StringBuilder()
            quotes.forEach{quote ->
                stringBuilder.append("$quote\n\n")

            }
            textView_quotes.text = stringBuilder.toString()

        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editTextText_quotes.text.toString() , editTextText_authour.text.toString())
            viewModel.addQuotes(quote)
            editTextText_authour.setText("")
            editTextText_quotes.setText("")
        }




    }
}