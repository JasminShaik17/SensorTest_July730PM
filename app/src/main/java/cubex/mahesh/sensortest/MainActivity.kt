package cubex.mahesh.sensortest

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sManager = getSystemService(Context.SENSOR_SERVICE)
                        as SensorManager
        var s = sManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        sManager.registerListener(object : SensorEventListener {
            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

            }
            override fun onSensorChanged(p0: SensorEvent?) {
                 var values:FloatArray = p0!!.values
                textView.text = values[0].toString()
              //  textView2.text = values[1].toString()
            }

        },s,SensorManager.SENSOR_DELAY_FASTEST)
    }
}
