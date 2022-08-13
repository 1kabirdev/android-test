package com.android_test.hilt.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android_test.App
import com.android_test.R
import com.android_test.databinding.FragmentButtonsBinding
import com.android_test.hilt.data.LoggerLocalDataSource
import com.android_test.hilt.navigator.AppNavigator
import com.android_test.hilt.navigator.Screens

class ButtonsFragment : Fragment() {

    private lateinit var binding: FragmentButtonsBinding

    private lateinit var logger: LoggerLocalDataSource
    private lateinit var navigator: AppNavigator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentButtonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        populateFields(context)
    }

    private fun populateFields(context: Context) {
        logger = (context.applicationContext as App).serviceLocator.loggerLocalDataSource

        navigator =
            (context.applicationContext as App).serviceLocator.provideNavigator(requireActivity())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button1.setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }

        binding.button2.setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }

        binding.button3.setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        binding.allLogs.setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        binding.deleteLogs.setOnClickListener {
            logger.removeLogs()
        }
    }
}