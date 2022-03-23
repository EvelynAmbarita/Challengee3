package com.binar.challenge3.page

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.binar.challenge3.Person
import com.binar.challenge3.R
import com.binar.challenge3.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    private val args: FourthFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFourthBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackToScree3.setOnClickListener {

            val name = args.nama
            val age = binding.etAge.text.toString().toInt()
            val height = binding.etHeight.text.toString().toDouble()
            val weight = binding.etWeight.text.toString().toDouble()
            val gender = getSelectedGender()

            val result = calcResult(age, height, weight, gender)
            val person = Person(name, age, height, weight, gender, result)
            val action = FourthFragmentDirections.actionFourthFragmentToThirdFragment(person)
            it.findNavController().navigate(action)
        }


    }

    private fun getSelectedGender():String{

        val selectedId = binding.rgGender.checkedRadioButtonId
        val selectedRadio = activity?.findViewById<RadioButton>(selectedId)
        return selectedRadio?.text.toString()

    }

    private fun calcResult(age:Int, height: Double, weight: Double, gender: String): Double{

        var result = 0.0

        when(gender){
            "Pria" -> {
                result =
                    (10*weight) + (6.25*height) - (5*age)+5
            }
            "Wanita" -> {
                result =
                    (10*weight) + (6.25*height) - (5*age)-161
            }
        }

        return result

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}