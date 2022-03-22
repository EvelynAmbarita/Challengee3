package com.binar.challenge3.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.collection.arraySetOf
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.binar.challenge3.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {


    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNama.text = "Nama: ${args.person.name}"
        if (args.person.age == null){
            hideResult()
        }else{
            showResult()
        }

        binding.btnGoToScreen4.setOnClickListener {
            val action = ThirdFragmentDirections
                .actionThirdFragmentToFourthFragment(args.person.name)
            it.findNavController().navigate(action)
        }

    }

    private fun showResult(){
        binding.tvAge.visibility = View.VISIBLE
        binding.tvHeight.visibility = View.VISIBLE
        binding.tvWeight.visibility = View.VISIBLE
        binding.tvGender.visibility = View.VISIBLE
        binding.tvResult.visibility = View.VISIBLE
        binding.tvNama.updateLayoutParams<ConstraintLayout.LayoutParams> { verticalBias = 0.0f }

        binding.tvAge.text = "Umur: ${args.person.age} tahun"
        binding.tvHeight.text = "Tinggi: ${args.person.height}cm"
        binding.tvWeight.text = "Berat: ${args.person.weight}kg"
        binding.tvGender.text = "Jenis Kelamin: ${args.person.gender}"
        binding.tvResult.text = "Jumlah BMR: \n${args.person.result} Kalori/hari"

    }

    private fun hideResult(){
        binding.tvAge.visibility = View.GONE
        binding.tvHeight.visibility = View.GONE
        binding.tvWeight.visibility = View.GONE
        binding.tvGender.visibility = View.GONE
        binding.tvResult.visibility = View.GONE
        binding.tvNama.updateLayoutParams<ConstraintLayout.LayoutParams> { verticalBias = 1.0f }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}