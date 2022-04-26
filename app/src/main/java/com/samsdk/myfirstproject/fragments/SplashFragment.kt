package com.samsdk.myfirstproject.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.samsdk.myfirstproject.R
import com.samsdk.myfirstproject.databinding.FragmentSplashBinding
import com.samsdk.myfirstproject.manager.SharedPrefManager

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private lateinit var sharedPrefManager: SharedPrefManager
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sharedPrefManager = SharedPrefManager(requireContext())
        initViews()

    }

    private fun initViews() {
        Handler().postDelayed({
            if (sharedPrefManager.getFinished()) {
                findNavController().navigate(R.id.action_splashFragment_to_homeMainFragment)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
            }
        }, 4000)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}