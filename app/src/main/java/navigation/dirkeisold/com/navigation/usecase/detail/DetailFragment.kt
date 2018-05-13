package navigation.dirkeisold.com.navigation.usecase.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import navigation.dirkeisold.com.navigation.R
import navigation.dirkeisold.com.navigation.common.OnReselectedDelegate
import navigation.dirkeisold.com.navigation.common.isSectionVisible
import navigation.dirkeisold.com.navigation.common.setupActionBar

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