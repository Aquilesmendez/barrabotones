package com.example.barrabotones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.barrabotones.databinding.FragmentBarraBotonesBinding

class BarraBotonesFragment : Fragment() {

    private var _binding: FragmentBarraBotonesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBarraBotonesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnHome.setOnClickListener {
            showFragment(HomeFragment())
        }

        binding.btnSearch.setOnClickListener {
            showFragment(SearchFragment())
        }

        binding.btnSettings.setOnClickListener {
            showFragment(SettingsFragment())
        }

        binding.btnProfile.setOnClickListener {
            showFragment(ProfileFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)  // Permite volver al fragmento anterior
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}