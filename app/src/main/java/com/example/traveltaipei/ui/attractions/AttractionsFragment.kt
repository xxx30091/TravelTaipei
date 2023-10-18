package com.example.traveltaipei.ui.attractions

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.traveltaipei.R
import com.example.traveltaipei.databinding.FragmentAttractionsBinding
import com.example.traveltaipei.ui.detail.DetailFragmentDirections
import kotlinx.android.synthetic.main.dialog_language.view.rv_lang_list
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AttractionsFragment : Fragment() {

    lateinit var binding: FragmentAttractionsBinding
    //    val viewModel by viewModels<AttractionsViewModel>()
    val viewModel: AttractionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAttractionsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.model = viewModel

        binding.rvMain.adapter = AttractionsAdapter(viewModel)

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_language, null)
        val alertDialog = AlertDialog.Builder(context).setView(mDialogView).create()
        val mAdapter = LanguageAdapter(viewModel)
        val rv = mDialogView.rv_lang_list
        rv.adapter = mAdapter
        mAdapter.updateList(viewModel.allLangList)

        lifecycleScope.launch {
            viewModel.route.collect { route ->
                when(route) {
                    is AttractionsViewModel.NavRoute.GoToDetail -> {
                        val action = DetailFragmentDirections.navToDetailFragment(data = route.attraction)
                        findNavController().navigate(action)
                    }
                    is AttractionsViewModel.NavRoute.ShowLanguageList -> {
                        alertDialog.show()
                    }
                    is AttractionsViewModel.NavRoute.ChangeLanguage -> {
                        alertDialog.dismiss()
                    }
                    is AttractionsViewModel.NavRoute.Toast -> {
                        Toast.makeText(context, route.msg, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = AttractionsFragment()
    }
}