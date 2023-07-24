package com.base.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import com.base.testproject.signalstrength.MultiColorProgressBarDrawable
import com.beardedhen.androidbootstrap.BootstrapProgressBar
import com.beardedhen.androidbootstrap.BootstrapProgressBarGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val peterProgress = findViewById<SignalStrengthView>(R.id.signal_strength_view)
        peterProgress.setSegmentCount(4)
        peterProgress.setSignalStrength(1)
        val peterProgress2 = findViewById<ProgressBarView>(R.id.signal_strength_view2)
        peterProgress2.setProgress(100)
//        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
//        progressBar.progressDrawable  = MultiColorProgressBarDrawable(this,
//            getColor(R.color.red)
//            , getColor(R.color.yellow)
//            , getColor(R.color.blue)
//            , getColor(R.color.green))
//        progressBar.setProgress(25,true)

        val progressGroup=findViewById<BootstrapProgressBarGroup>(R.id.example_progress_bar_group_round_group)

        with(progressGroup.findViewById<BootstrapProgressBar>(R.id.red_section)){
            bootstrapBrand = CustomBootstrapBrand(colorM = R.color.red)
            progress = 25
        }
        with(progressGroup.findViewById<BootstrapProgressBar>(R.id.yellow_section)){
            bootstrapBrand = CustomBootstrapBrand(colorM = R.color.yellow)
            progress =25
        }
        with(progressGroup.findViewById<BootstrapProgressBar>(R.id.blue_section)){
            bootstrapBrand = CustomBootstrapBrand(colorM = R.color.blue)
            progress =25

        }
        with(progressGroup.findViewById<BootstrapProgressBar>(R.id.green_section)){
            bootstrapBrand = CustomBootstrapBrand(colorM = R.color.green)
            progress =25

        }

    }
}