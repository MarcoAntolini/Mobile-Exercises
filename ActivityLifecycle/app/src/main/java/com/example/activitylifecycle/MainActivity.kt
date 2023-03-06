package com.example.activitylifecycle

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.activitylifecycle.ui.theme.ActivityLifecycleTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {

    /**
     * Callback fired when the system first creates the activity.
     * Here you perform basic application startup logic that should happen only once
     * for the entire life of the activity.
     * For example, your implementation of onCreate() might bind data to lists,
     * associate the activity with a ViewModel, and instantiate some class-scope variables.
     *
     * @param savedInstanceState --> a Bundle object containing the activity's previously
     *                           saved state. If the activity has never existed before,
     *                           the value of the Bundle object is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityLifecycleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        setMessage("onCreate")
    }

    /**
     * The onStart() call makes the activity visible to the user,
     * as the app prepares for the activity to enter the foreground and become interactive.
     *
     * The onStart() method completes very quickly and, as with the Created state,
     * Once this callback finishes, the activity enters the Resumed state,
     * and the system invokes the onResume() method.
     *
     */
    override fun onStart() {
        super.onStart()
        setMessage("onStart")
    }

    /**
     * When the activity enters the Resumed state, it comes to the foreground,
     * and then the system invokes the onResume() callback.
     * This is the state in which the app interacts with the user.
     * The app stays in this state until something happens to take focus away from the app.
     *
     * This is where the lifecycle components can enable any functionality that needs to run
     * while the component is visible and in the foreground, such as starting a camera preview.
     *
     * When an interruptive event occurs, the activity enters the Paused state.
     *
     * If the activity returns to the Resumed state from the Paused state,
     * the system once again calls onResume() method.
     * For this reason, you should implement onResume() to initialize components that you release
     * during onPause(), and perform any other initializations that must occur each time
     * the activity enters the Resumed state.
     */
    override fun onResume() {
        super.onResume()
        setMessage("onResume")
    }

    override fun onRestart() {
        super.onRestart()
        setMessage("onRestart")
    }

    /**
     * The system calls this method as the first indication that the user is leaving your activity
     * it indicates that the activity is no longer in the foreground (though it may still be visible
     * if the user is in multi-window mode).
     * Use the onPause() method to pause or adjust operations that should not continue
     * (or should continue in moderation) while the Activity is in the Paused state,
     * and that you expect to resume shortly.
     *
     * This is where the lifecycle components can stop any functionality that does not need to run
     * while the component is not in the foreground, such as stopping a camera preview.
     *
     * You can also use the onPause() method to release system resources, handles to sensors (like GPS),
     * or any resources that may affect battery life while your activity is paused and the user
     * does not need them. Activity may still be fully visible if in multi-window mode.
     * As such, you should consider using onStop() instead of onPause() to fully release or adjust
     * UI-related resources and operations to better support multi-window mode.
     */
    override fun onPause() {
        super.onPause()
        setMessage("onPause")
    }

    /**
     * When your activity is no longer visible to the user and the system invokes the onStop() callback.
     * This may occur, for example, when a newly launched activity covers the entire screen.
     * The system may also call onStop() when the activity has finished running,
     * and is about to be terminated.
     */
    override fun onStop() {
        super.onStop()
        setMessage("onStop")
    }

    /**
     * onDestroy() is called before the activity is destroyed. The system invokes this callback
     * either because:
     *
     * the activity is finishing (due to the user completely dismissing the activity
     * or due to finish() being called on the activity), or
     * the system is temporarily destroying the activity due to a configuration change
     * (such as device rotation or multi-window mode)
     *
     * N.B here the activity is already destroyed, so nothing will appear in the UI.
     */
    override fun onDestroy() {
        super.onDestroy()
        setMessage("onDestroy")
    }

    fun setMessage(method: String) {
        Log.d(TAG, method)
        Toast.makeText(this, method, Toast.LENGTH_SHORT).show();
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ActivityLifecycleTheme {
        Greeting("Android")
    }
}