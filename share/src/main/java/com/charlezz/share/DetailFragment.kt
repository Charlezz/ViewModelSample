package com.charlezz.share

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class DetailFragment : Fragment(){

    private lateinit var viewModel : SharedViewModel

    private lateinit var count : TextView
    private lateinit var plusBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.run {
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
                .get(SharedViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        plusBtn = view.findViewById(R.id.plus)
        count = view.findViewById(R.id.count)

        plusBtn.setOnClickListener {
            viewModel.count.value = viewModel.count.value!! + 1
            count.text = "${viewModel.count.value}"
        }

        viewModel.count.observe(viewLifecycleOwner, Observer{
            count.text = "$it"
        })
    }
}