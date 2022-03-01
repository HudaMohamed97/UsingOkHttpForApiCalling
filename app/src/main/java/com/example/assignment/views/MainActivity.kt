package com.example.assignment.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.CustomAdapter
import com.example.assignment.R
import com.example.assignment.data.ResultsData
import com.example.assignment.presenter.MainPresenter

class MainActivity : AppCompatActivity(), CustomAdapter.CellClickedListener, MainView {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchText: EditText
    private lateinit var button: Button
    private lateinit var errorTextView: TextView
    private lateinit var presenter: MainPresenter
    var list = arrayOf<ResultsData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        setClickListener()
    }

    private fun setClickListener() {
        button.setOnClickListener {
            hideKeyboard(button)
            if (validateEmptyText()) {
                showErrorMessage()
            } else {
                hideErrorMessage()
                presenter.getAccessToken(searchText.text.toString())
            }
        }
        searchText.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                hideKeyboard(v)
            }
        }
    }

    private fun showErrorMessage() {
        errorTextView.visibility = View.VISIBLE
    }

    private fun hideErrorMessage() {
        errorTextView.visibility = View.GONE
    }

    private fun validateEmptyText(): Boolean {
        val text = searchText.text
        return text.isEmpty()
    }

    private fun initializeViews() {
        presenter = MainPresenter(this)
        recyclerView = findViewById(R.id.recyclerview)
        errorTextView = findViewById(R.id.errorText)
        button = findViewById(R.id.button)
        searchText = findViewById(R.id.searchTextId)
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(list, this)
        recyclerView.adapter = adapter
    }

    override fun cellClicked(itemsViewModel: ResultsData) {
        val intent = Intent(applicationContext, DetailsActivity::class.java)
        intent.putExtra("Obj", itemsViewModel.id.toString())
        startActivity(intent)
    }

    override fun setResultArrayList(result: Array<ResultsData>) {
        list = result
        runOnUiThread { setupRecyclerView() }
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager: InputMethodManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
