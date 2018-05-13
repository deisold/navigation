package navigation.dirkeisold.com.navigation.usecase.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.home_fragment.*
import navigation.dirkeisold.com.navigation.R
import navigation.dirkeisold.com.navigation.common.OnReselectedDelegate
import navigation.dirkeisold.com.navigation.common.isSectionVisible
import navigation.dirkeisold.com.navigation.common.setupActionBar

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