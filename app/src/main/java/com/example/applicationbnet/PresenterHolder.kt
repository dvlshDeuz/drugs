package com.example.applicationbnet

import com.example.applicationbnet.presenter.DrugPresenter
import com.example.applicationbnet.presenter.DrugsListPresenter

interface PresenterHolder {
    fun getDrugPresenter(): DrugPresenter
    fun getDrugListPresenter(): DrugsListPresenter
}