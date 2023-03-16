package com.example.applicationbnet.data.repository

import com.example.applicationbnet.data.Drug
import rx.Single

interface IDrugInteractor {

    fun getDrugItem(id: Int): Single<Drug>
}