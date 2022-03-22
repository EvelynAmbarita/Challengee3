package com.binar.challenge3.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
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

//        val checkedId = binding.rgKelamin.checkedRadioButtonId
//        val selectedKelamin = binding.rgKelamin.getChildAt(checkedId) as RadioButton
//        val selectedKelaminText = selectedKelamin.text

        binding.btnBackToScree3.setOnClickListener {
            val person = Person("nama",null,null,null,null)
            val action = FourthFragmentDirections.actionFourthFragmentToThirdFragment(person)
            it.findNavController().navigate(action)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}