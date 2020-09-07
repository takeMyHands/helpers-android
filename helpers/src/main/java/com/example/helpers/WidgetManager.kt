package com.example.helpers

import android.content.Context
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageButton
import android.widget.NumberPicker

class WidgetManager {
    class AnimationManager {
        companion object {
            val TAG = AnimationManager::class.simpleName

            fun getFadeOutUp(context: Context): Animation{
                return AnimationUtils.loadAnimation(context, R.anim.fade_out_up_001)
            }

            fun getFadeInDown(context: Context): Animation {
                return AnimationUtils.loadAnimation(context, R.anim.fade_in_down_001)
            }

            fun getHeartBeating(context: Context): Animation {
                return AnimationUtils.loadAnimation(context, R.anim.heart_beating_001)
            }

            fun getMoveLeft(context: Context): Animation {
                return AnimationUtils.loadAnimation(context, R.anim.move_left_001)
            }

            fun getMoveRight(context: Context): Animation {
                return AnimationUtils.loadAnimation(context, R.anim.move_right_001)
            }

            fun getRemoveLeft(context: Context): Animation {
                return AnimationUtils.loadAnimation(context, R.anim.remove_left_001)
            }

            fun getBlink(context: Context): Animation {
                return AnimationUtils.loadAnimation(context, R.anim.blink)
            }
        }
    }

    class EnableManager {
        companion object {
            val TAG = EnableManager::class.simpleName

            fun setEnableEditText(v: EditText, status: Boolean) {
                Log.w(TAG, object:Any(){}.javaClass.enclosingMethod!!.name)
                try {
                    v.isClickable = status
                    v.isEnabled = status
                    v.isFocusable = status
                    v.isFocusableInTouchMode = status
                } catch (e: Exception) {e.printStackTrace()}
            }

            fun setEnableImageButton(v: ImageButton, status: Boolean) {
                Log.w(TAG, object:Any(){}.javaClass.enclosingMethod!!.name)
                try {
                    v.isClickable = status
                    v.isEnabled = status
//                v.isFocusable = status
//                v.isFocusableInTouchMode = status
                } catch (e: Exception) {e.printStackTrace()}
            }

            fun setEnableNumberPicker(v: NumberPicker, status: Boolean) {
                Log.w(TAG, object:Any(){}.javaClass.enclosingMethod!!.name)
                try {
                    v.isClickable = status
                    v.isEnabled = status
                    v.isFocusable = status
                    v.isFocusableInTouchMode = status
                } catch (e: Exception) {e.printStackTrace()}
            }

        }
    }

    class LayoutParamsManager {
        val TAG = LayoutParamsManager::class.simpleName

        // note. get width and height
        fun getViewWidthAndHeight(view: View): HashMap<String, Int>? {
            Log.w(TAG, object:Any(){}.javaClass.enclosingMethod!!.name)
            var result: HashMap<String, Int>? = HashMap()
            try {
                val observer: ViewTreeObserver = view.viewTreeObserver
                observer.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        Log.i(TAG, "width:${view.width}, height:${view.height}")
                        if (result != null) {
                            result["width"] = view.width
                            result["height"] = view.height
                        }
                        view.viewTreeObserver.removeGlobalOnLayoutListener(this)
                    }
                })
                return result
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }
            return null
        }
    }

    class Measure {

        // note. measure
        fun Float.toDp(context: Context) : Int = (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics)).toInt()
        fun Int.toDp(context: Context) : Int = (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics)).toInt()
    }
}