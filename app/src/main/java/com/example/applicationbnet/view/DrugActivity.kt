package com.example.applicationbnet.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.example.applicationbnet.DrugMvp
import com.example.applicationbnet.MyApplication
import com.example.applicationbnet.PresenterHolder
import com.example.applicationbnet.R
import com.example.applicationbnet.data.Drug
import com.example.applicationbnet.presenter.DrugPresenter

class DrugActivity : AppCompatActivity(), DrugMvp {

    private lateinit var presenter: DrugPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drug)
        presenter = (application as PresenterHolder).getDrugPresenter()
        presenter.onAttach(this)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val id = bundle.getInt("id")
            presenter.getDrug(id)
        }

        val actionBar = supportActionBar
        actionBar?.title = ""
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun setDrug(drug: Drug) {
        val titleDrugs: TextView = findViewById(R.id.tvDrugTitle)
        val descDrugs: TextView = findViewById(R.id.tvDrugDescription)
        titleDrugs.text = drug.name
        descDrugs.text = drug.description
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}