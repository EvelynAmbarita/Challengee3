package com.binar.challenge3.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.binar.challenge3.Person
import com.binar.challenge3.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

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

            val result = calcResult(5,170.0,60.0,"Pria")
            val person = Person("nama",5,170.0,60.0,"Pria",result)
            val action = FourthFragmentDirections.actionFourthFragmentToThirdFragment(person)
            it.findNavController().navigate(action)
        }


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