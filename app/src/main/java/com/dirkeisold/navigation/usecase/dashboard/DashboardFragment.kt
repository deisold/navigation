package com.dirkeisold.navigation.usecase.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dirkeisold.navigation.R
import com.dirkeisold.navigation.common.OnReselectedDelegate
import com.dirkeisold.navigation.common.isSectionVisible
import com.dirkeisold.navigation.common.setupActionBar

class DashboardFragment : Fragment(), OnReselectedDelegate {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            View.inflate(activity, R.layout.dashboard_fragment, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (isSectionVisible()) setupActionBar()
    }

    private fun setupActionBar() = setupActionBar("Dashboard")

    override fun onReselected() = setupActionBar()
}
