package com.dirkeisold.navigation.usecase.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dirkeisold.navigation.R
import com.dirkeisold.navigation.common.OnReselectedDelegate
import com.dirkeisold.navigation.common.isSectionVisible
import com.dirkeisold.navigation.common.setupActionBar

class DetailFragment : Fragment(), OnReselectedDelegate {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            View.inflate(activity, R.layout.detail_fragment, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (isSectionVisible()) setupActionBar()
    }

    private fun setupActionBar() = setupActionBar("Details from " + arguments?.getString("FROM"), true)

    override fun onReselected() = setupActionBar()

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            android.R.id.home -> {
                view?.findNavController()?.navigateUp()
                return true
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }
}
