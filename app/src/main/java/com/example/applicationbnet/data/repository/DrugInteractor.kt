package com.example.applicationbnet.data.repository

import com.example.applicationbnet.data.Drug
import rx.Single

class DrugInteractor(private val service: APIService): IDrugInteractor {

    override fun getDrugItem(id: Int): Single<Drug> {
        return service.getDrug(id)
    }
}