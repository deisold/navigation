package navigation.dirkeisold.com.navigation.usecase.notifications

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.notification_fragment.*
import navigation.dirkeisold.com.navigation.R
import navigation.dirkeisold.com.navigation.common.OnReselectedDelegate
import navigation.dirkeisold.com.navigation.common.isSectionVisible
import navigation.dirkeisold.com.navigation.common.setupActionBar

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