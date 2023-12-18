package com.example.myapp

import retrofit2.GsonConverterFactory
import retrofit2.Retrofit

object RetrofitInstance  {
    //bir app ayağa kalktıgında retrofit üzerinden api servisleri oluşturulur
    //app boyunca bu instance kullanılacak (singleton design pattern)

    //https://jsonplaceholder.typicode.com/posts/1
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    //Facet design pattern
    //Karmaşık alt sistemleri olan bir yapıyı ; tek ,
    // makul bir arayüz sağlayan Facet sınıfı oluşturarak basitleştirmek.
    }
}