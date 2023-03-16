package com.example.applicationbnet

import com.example.applicationbnet.data.Drug

interface DrugMvp {

    fun setDrug(drug: Drug)

    fun showError(message: String?)
}