package com.example.applicationbnet.presenter

import com.example.applicationbnet.DrugMvp
import com.example.applicationbnet.data.repository.IDrugInteractor
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DrugPresenter(private val interactor: IDrugInteractor) {

    private var view: DrugMvp? = null

    fun onAttach(view: DrugMvp) {
        this.view = view
    }

    fun getDrug(id: Int) {
        interactor.getDrugItem(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.setDrug(it)
            },{
                view?.showError(it.message)
            })
    }
}