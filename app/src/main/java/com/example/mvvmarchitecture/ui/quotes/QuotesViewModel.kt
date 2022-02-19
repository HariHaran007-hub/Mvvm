package com.example.mvvmarchitecture.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmarchitecture.data.Quote
import com.example.mvvmarchitecture.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) :ViewModel(){

    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)

}