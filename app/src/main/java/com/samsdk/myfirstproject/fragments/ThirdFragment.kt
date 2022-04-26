package com.samsdk.myfirstproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.samsdk.myfirstproject.R
import com.samsdk.myfirstproject.databinding.FragmentThirdBinding
import com.samsdk.myfirstproject.manager.SharedPrefManager

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        sharedPrefManager = SharedPrefManager(requireContext())
        binding.btnFinish.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_homeMainFragment)
            sharedPrefManager.isFinished(true)
        }
        binding.btnPrev.setOnClickListener {
            viewPager?.currentItem = 1
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}