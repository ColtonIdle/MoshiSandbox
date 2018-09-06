package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(MoshiConverterFactory.create().failOnUnknown())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .build()

        val service = retrofit.create(ApiService::class.java)

        service.listRepos().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({ t ->
            Toast.makeText(this, t.title, Toast.LENGTH_LONG).show()

        }, { t ->

            Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()

        })

//        val repos = service.listRepos("octocat")

    }
}
