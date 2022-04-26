package com.samsdk.myfirstproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.samsdk.myfirstproject.R
import com.samsdk.myfirstproject.adapters.ItemAdapter
import com.samsdk.myfirstproject.databinding.FragmentDetailBinding
import com.samsdk.myfirstproject.model.Job
import com.samsdk.myfirstproject.util.ListObject
import java.util.*

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemAdapter: ItemAdapter

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = arguments?.getParcelable("job")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.apply {
            textCompany.text = job.company
            textDate.text = job.time
            textJob.text = job.jobTitle
            textLocation.text = job.location
            imageRound.setBackgroundResource(job.image)
        }
        itemAdapter = ItemAdapter()
        itemAdapter.items = ListObject.itemList()
        binding.recyclerView.adapter = itemAdapter
    }
}