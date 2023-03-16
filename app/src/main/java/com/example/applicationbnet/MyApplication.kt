package com.example.applicationbnet

import android.app.Application
import com.example.applicationbnet.data.repository.APIService
import com.example.applicationbnet.data.repository.DrugInteractor
import com.example.applicationbnet.data.repository.DrugsListInteractor
import com.example.applicationbnet.presenter.DrugPresenter
import com.example.applicationbnet.presenter.DrugsListPresenter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application(), PresenterHolder {

    private val service = Retrofit.Builder()
        .baseUrl("http://shans.d2.i-partner.ru/")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(APIService::class.java)

    private lateinit var drugPresenter: DrugPresenter
    private lateinit var drugListPresenter: DrugsListPresenter
    private var drugInteractor = DrugInteractor(service)
    private var drugsListInteractor = DrugsListInteractor(service)

    override fun onCreate() {
        drugPresenter = DrugPresenter(drugInteractor)
        drugListPresenter = DrugsListPresenter(drugsListInteractor)
        super.onCreate()
    }

    override fun getDrugPresenter(): DrugPresenter = drugPresenter

    override fun getDrugListPresenter(): DrugsListPresenter = drugListPresenter
}