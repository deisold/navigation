package com.dirkeisold.navigation.usecase.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.dirkeisold.navigation.R
import com.dirkeisold.navigation.common.OnReselectedDelegate
import com.dirkeisold.navigation.common.isSectionVisible
import com.dirkeisold.navigation.common.setupActionBar
import kotlinx.android.synthetic.main.notification_fragment.*

class NotificationFragment : Fragment(), OnReselectedDelegate {
    val detailsButton: Button by lazy { details_button }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            View.inflate(activity, R.layout.notification_fragment, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findNavController()

        detailsButton.setOnClickListener {
            Log.d("NotificationFragment", "clicked on view=%s$it")
            val controller = view.findNavController()
            controller.navigate(R.id.action_notificationFragment_to_detailFragment,
                    Bundle().apply { putString("FROM", "Notifications") })
        }

        if (isSectionVisible()) setupActionBar()
    }

    private fun setupActionBar() = setupActionBar("Notifications")

    override fun onReselected() = setupActionBar()
}
