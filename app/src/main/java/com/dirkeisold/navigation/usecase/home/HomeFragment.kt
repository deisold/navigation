package com.dirkeisold.navigation.usecase.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.dirkeisold.navigation.R
import com.dirkeisold.navigation.common.OnReselectedDelegate
import com.dirkeisold.navigation.common.isSectionVisible
import com.dirkeisold.navigation.common.setupActionBar
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(), OnReselectedDelegate {

    val detailsButton: Button by lazy { details_button }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            View.inflate(activity, R.layout.home_fragment, null).apply { Log.d("HomeFragment", "onCreateView") }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("HomeFragment", "onViewCreated")
        (view.findViewById<Button>(R.id.details_button)).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_homeDetailFragment,
                        Bundle().apply { putString("FROM", "Home") }))

        if (isSectionVisible()) setupActionBar()
    }

    private fun setupActionBar() = setupActionBar("Home")

    override fun onReselected() = setupActionBar()
}
