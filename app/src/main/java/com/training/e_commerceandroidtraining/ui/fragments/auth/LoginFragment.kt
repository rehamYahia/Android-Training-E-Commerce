package com.training.e_commerceandroidtraining.ui.fragments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.training.data.`repo-imp`.`repo-imp`.LoginRepositoryImp
import com.training.domain.usecase.AuthUseCase
import com.training.e_commerceandroidtraining.R
import com.training.e_commerceandroidtraining.databinding.FragmentLoginBinding
import com.training.e_commerceandroidtraining.viewmodel.LoginViewModel
import com.training.e_commerceandroidtraining.viewmodel.LoginViewModelFactory
import com.training.ecommerce.data.datasource.datastore.UserPreferencesDataSource


class LoginFragment : Fragment() {

    val navController = findNavController()
    private val loginViewModel:LoginViewModel by viewModels {
        LoginViewModelFactory(authUseCase = AuthUseCase(LoginRepositoryImp( UserPreferencesDataSource(requireActivity()))))
    }

    private var _binding: FragmentLoginBinding ?= null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
//        val navController = findNavController()
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater , container , false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        view.findViewById<Button>(R.id.button).setOnClickListener {
//            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
//            navController.navigate(action)
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }


