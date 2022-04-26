package com.samsdk.myfirstproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.samsdk.myfirstproject.R
import com.samsdk.myfirstproject.adapters.ViewPagerAdapter
import com.samsdk.myfirstproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = viewPagerAdapter
        binding.textSkip.setOnClickListener {
            binding.viewPager.currentItem = 2
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}