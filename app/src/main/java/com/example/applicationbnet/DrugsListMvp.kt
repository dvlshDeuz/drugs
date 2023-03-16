package com.example.applicationbnet

import com.example.applicationbnet.data.Drug

interface DrugsListMvp {

    fun setDrugs(drugs: List<Drug>)

    fun showError(message: String?)
}