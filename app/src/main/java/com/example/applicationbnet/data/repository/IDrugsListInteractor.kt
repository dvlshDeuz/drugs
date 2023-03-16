package com.example.applicationbnet.data.repository

import com.example.applicationbnet.data.Drug
import rx.Single

interface IDrugsListInteractor {

    fun getDrugsList(searchString: String): Single<List<Drug>>
}