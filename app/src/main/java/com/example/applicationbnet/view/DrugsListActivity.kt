package com.example.applicationbnet.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationbnet.DrugsListMvp
import com.example.applicationbnet.PresenterHolder
import com.example.applicationbnet.R
import com.example.applicationbnet.data.Drug
import com.example.applicationbnet.data.adapter.ListAdapter
import com.example.applicationbnet.databinding.ActivityMainBinding
import com.example.applicationbnet.presenter.DrugsListPresenter
import okhttp3.internal.notify

class DrugsListActivity : AppCompatActivity(), DrugsListMvp {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: DrugsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScreen()
        presenter = (application as PresenterHolder).getDrugListPresenter()
        presenter.onAttach(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        val menuSearchItem = menu?.findItem(R.id.search_action)
        val searchView = menuSearchItem?.actionView as androidx.appcompat.widget.SearchView

        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false

            override fun onQueryTextChange(newText: String?): Boolean {
                presenter.onSearch(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun setDrugs(drugs: List<Drug>) {
        adapter.drugsList = drugs
        adapter.notifyDataSetChanged()
        adapter.setOnItemClickListener(object : ListAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@DrugsListActivity, DrugActivity::class.java)
                intent.putExtra("id", drugs[position].id)
                startActivity(intent)
            }
        })
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun setupScreen() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.title = resources.getString(R.string.list)
        adapter = ListAdapter()
        recyclerView = binding.rcList
        recyclerView.adapter = adapter
    }
}