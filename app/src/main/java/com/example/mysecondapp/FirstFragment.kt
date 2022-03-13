package com.example.mysecondapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mysecondapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener {
            val showCountTextView = binding.resultCount.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(showCountTextView)
            findNavController().navigate(action)
        }

        fun countMe (view: View) {
            val countString = binding.resultCount.text.toString()
            var count = countString.toInt()
            count++
            binding.resultCount.text = count.toString()
        }

        binding.toastButton.setOnClickListener {
            Toast.makeText(context, "Toast!", Toast.LENGTH_SHORT).show()
        }
        binding.countButton.setOnClickListener {
            countMe(view)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}