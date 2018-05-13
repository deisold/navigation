package navigation.dirkeisold.com.navigation.usecase.dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import navigation.dirkeisold.com.navigation.R
import navigation.dirkeisold.com.navigation.common.OnReselectedDelegate
import navigation.dirkeisold.com.navigation.common.isSectionVisible
import navigation.dirkeisold.com.navigation.common.setupActionBar

class DashboardFragment : Fragment(), OnReselectedDelegate {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            View.inflate(activity, R.layout.dashboard_fragment, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (isSectionVisible()) setupActionBar()
    }

    private fun setupActionBar() = setupActionBar("Dashboard")

    override fun onReselected() = setupActionBar()
}