package navigation.dirkeisold.com.navigation.common

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup

object Utils {
}

fun <T> T?.or(default: T): T = this ?: default
fun <T> T?.or(compute: () -> T): T = this ?: compute()

fun Fragment.isSectionVisible(): Boolean = (((view?.parent as? ViewGroup)?.parent as? ViewGroup)?.visibility == View.VISIBLE)

fun Fragment.setupActionBar(title: String, displayHome: Boolean = false) {
    (activity as? AppCompatActivity)?.supportActionBar?.apply {
        this.title = title
        setDisplayShowHomeEnabled(displayHome)
        setDisplayHomeAsUpEnabled(displayHome)
    }
    setHasOptionsMenu(displayHome)
}