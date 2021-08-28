package com.example.rxjavaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Observable.just("apple", "orange", "banana")
            .map({
                throw RuntimeException()
            })
            .subscribe(
                object : Observer<String> {
                    override fun onSubscribe(d: Disposable) {
                        println("onSubsribe")
                    }

                    override fun onNext(t: String) {
                        println(t)
                    }

                    override fun onError(e: Throwable) {
                        println("on error $e")
                    }

                    override fun onComplete() {
                        println("oncomplete")
                    }

                }
            )

    }
}