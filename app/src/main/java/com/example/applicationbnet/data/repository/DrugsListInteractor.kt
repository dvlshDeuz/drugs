package com.example.applicationbnet.data.repository

import com.example.applicationbnet.data.Drug
import rx.Single

class DrugsListInteractor(private val service: APIService): IDrugsListInteractor {

    override fun getDrugsList(searchString: String): Single<List<Drug>> {
        return service.getDrugsList(searchString)
    }
}