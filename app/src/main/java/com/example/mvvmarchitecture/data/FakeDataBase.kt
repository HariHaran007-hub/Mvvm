package com.example.mvvmarchitecture.data

class FakeDataBase private constructor(){


    val quoteDao = FakeQuoteDao()


    companion object{
        @Volatile private var instance : FakeDataBase? = null

        fun  getInstance() =
            instance ?: synchronized(this){
                instance ?: FakeDataBase().also { instance = it }
            }
    }
}