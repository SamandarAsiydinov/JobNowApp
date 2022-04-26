package com.samsdk.myfirstproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.samsdk.myfirstproject.R
import com.samsdk.myfirstproject.adapters.JobAdapter
import com.samsdk.myfirstproject.databinding.FragmentHomeMainBinding
import com.samsdk.myfirstproject.util.ListObject

class HomeMainFragment : Fragment() {

    private var _binding: FragmentHomeMainBinding? = null
    private lateinit var jobAdapter: JobAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        jobAdapter = JobAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        jobAdapter.jobs = ListObject.jobList()
        binding.recyclerView.adapter = jobAdapter
        binding.recyclerView.setHasFixedSize(true)

        jobAdapter.onClick = {
            val navController =
                Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
            val bundle = Bundle()
            bundle.putParcelable("job", it)
            navController.navigate(R.id.action_homeMainFragment_to_detailFragment, bundle)
        }
    }
}