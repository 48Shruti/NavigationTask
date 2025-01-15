package com.shruti.navigationtask

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shruti.navigationtask.databinding.FragmentHomeBinding
import com.shruti.navigationtask.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentLoginBinding
    lateinit var mainActivity: MainActivity
    var isPasswordVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnsignup.setOnClickListener {
            if (binding.etemail.text.isNullOrEmpty()){
                binding.etemail.error = "Enter email"
            }
            else if (binding.etpassword.text.isNullOrEmpty()){
                binding.etpassword.error = "Enter password"
            }else {
                val bundle = Bundle()
                bundle.putString("getEmail", binding.etemail.text.toString())
                findNavController().navigate(R.id.homeFragment , bundle)
            }
        }
        binding.iveyeclosedPass.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible){
                binding.etpassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.iveyeclosedPass.setImageResource(R.drawable.baseline_remove_red_eye_24)
            }else{
                binding.etpassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.iveyeclosedPass.setImageResource(R.drawable.img)
            }
            binding.etpassword.setSelection(binding.etpassword.text.length)
        }
        binding.tvforget.setOnClickListener{
            findNavController().navigate(R.id.accountFragment)
        }
        binding.tvsignup.setOnClickListener {
            findNavController().navigate(R.id.accountFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}