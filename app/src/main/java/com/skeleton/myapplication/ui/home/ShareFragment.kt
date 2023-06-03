package com.skeleton.myapplication.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.util.query
import by.kirich1409.viewbindingdelegate.viewBinding
import com.skeleton.myapplication.R
import com.skeleton.myapplication.data.EventResult
import com.skeleton.myapplication.databinding.FragmentShareBinding
import com.skeleton.myapplication.ui.MainViewModel
import com.skeleton.myapplication.ui.adapter.SearchAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShareFragment : Fragment(R.layout.fragment_share) {
    private val viewModel : MainViewModel by viewModel()
    private val binding : FragmentShareBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelSearch.setOnClickListener{
            binding.search1Et.setText("")
            cancel()
        }
        getQuery()
        doSomething(binding.search1Et)
    }

    private fun cancel(){
        binding.searchPhoto.visibility = View.VISIBLE
        binding.searchPhoto.visibility = View.GONE
        binding.notfoundTv.visibility = View.GONE
    }
    private fun getQuery(){
        binding.search1Et.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val query:String = p0.toString()
                if (query.isNotEmpty()){
                    viewModel.getSearch(query).observe(viewLifecycleOwner){
                        when(it){
                            is EventResult.Error ->{
                            }
                            is EventResult.Loading->{
                            }
                            is EventResult.Success->{
                                val adapter = SearchAdapter(it.data.results)
                                val layoutManager = GridLayoutManager(requireContext(),2,
                                    GridLayoutManager.VERTICAL,false)
                                binding.searchPhoto.setHasFixedSize(true)
                                binding.searchPhoto.layoutManager = layoutManager
                                binding.searchPhoto.adapter = adapter
                            }
                        }
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun doSomething(search: EditText){

        search.setOnEditorActionListener(TextView.OnEditorActionListener{ _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                getQuery()
                return@OnEditorActionListener true
            }
            false
        })
    }
}