package com.example.applicationbnet.presenter

import android.util.Log
import com.example.applicationbnet.DrugsListMvp
import com.example.applicationbnet.data.repository.DrugsListInteractor
import com.example.applicationbnet.data.repository.IDrugsListInteractor
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DrugsListPresenter(private val interactor: IDrugsListInteractor) {

    private var view: DrugsListMvp? = null

    fun onAttach(view: DrugsListMvp) {
        this.view = view
        getDrugsList("")
    }

    private fun getDrugsList(searchString: String) {
        interactor.getDrugsList(searchString)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.setDrugs(it)
            },{
                view?.showError(it.message)
            })
    }

    fun onSearch(string: String?) {
        getDrugsList(string?: "")
    }
}