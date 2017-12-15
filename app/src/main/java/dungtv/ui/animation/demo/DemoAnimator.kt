package dungtv.ui.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Bundle
import android.view.animation.AccelerateInterpolator

import kotlinx.android.synthetic.main.activity_demo_animator.*

class DemoAnimator : Activity() {

    private var mScaleAnimator = AnimatorSet()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_animator)

        btnScaleX.setOnClickListener({
            val scaleX = ObjectAnimator.ofFloat(tvAnimation, "scaleX",
                    0.5f, 1.2f, 0.9f, 1.0f).setDuration(1000)
            startAnimator(scaleX)
        })

        btnScaleY.setOnClickListener({
            val scaleY = ObjectAnimator.ofFloat(tvAnimation, "scaleY",
                    0.5f, 1.2f, 0.9f, 1.0f).setDuration(1000)
            startAnimator(scaleY)
        })

        btnTransX.setOnClickListener({
            val transX = ObjectAnimator.ofFloat(tvAnimation, "translationX", 20f, 0.0f)
                    .setDuration(1000)

            startAnimator(transX)
        })

        btnTransY.setOnClickListener({
            val transY = ObjectAnimator.ofFloat(tvAnimation, "translationY",
                    -10f, 10f).setDuration(1000)
            transY.repeatMode = ObjectAnimator.REVERSE
            transY.repeatCount = ObjectAnimator.INFINITE
            startAnimator(transY)
        })

        btnAlpha.setOnClickListener({
            val transUp = ObjectAnimator.ofFloat(tvAnimation, "translationY", 20f, 0.0f)
                    .setDuration(1000)
            val fadeIn = ObjectAnimator.ofFloat(tvAnimation, "alpha", 0.0f, 1.0f)
                    .setDuration(1000)
            startAnimator(transUp, fadeIn)
        })

        btnSquare.setOnClickListener({
            val transStart = ObjectAnimator.ofFloat(tvAnimation, "translationY",
                    -400f, 0f, 10f, 0f).setDuration(1000)
            startAnimator(transStart)
        })


    }

    private fun startAnimator(vararg objectAnimator: ObjectAnimator?) {
        mScaleAnimator = AnimatorSet()
        mScaleAnimator.interpolator = AccelerateInterpolator()
        mScaleAnimator.playTogether(*objectAnimator)
        mScaleAnimator.start()

    }


}