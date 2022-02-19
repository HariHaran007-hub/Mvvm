package com.example.mvvmarchitecture.utillites

import com.example.mvvmarchitecture.data.FakeDataBase
import com.example.mvvmarchitecture.data.QuoteRepository
import com.example.mvvmarchitecture.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun providesQuotesViewModelFactory() : QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDataBase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}