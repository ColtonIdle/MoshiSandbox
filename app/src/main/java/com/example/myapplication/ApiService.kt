package com.example.myapplication

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("Todos/1")
    fun listRepos(): Observable<Todos>
}