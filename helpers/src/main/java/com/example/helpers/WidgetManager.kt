package com.example.helpers

import android.content.Context
import android.content.res.ColorStateList
import android.text.InputFilter
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import com.google.android.material.tabs.TabLayout

object WidgetManager {
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
        companion object {
            fun View.setMarginLeft(value: Int) {
                var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(value.toDp(context), 0, 0, 0)
                this.layoutParams = params
            }
    
            fun View.setMarginRight(value: Int) {
                var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(0, 0, value.toDp(context), 0)
                this.layoutParams = params
            }
    
            fun View.setMarginTop(value: Int) {
                var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(0, value.toDp(context), 0, 0)
                this.layoutParams = params
            }
    
            fun View.setMarginBottom(value: Int) {
                var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(0, 0, 0, value.toDp(context))
                this.layoutParams = params
            }
    
            fun View.setMarginHorizontal(value: Int) {
                var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(value.toDp(context), 0, value.toDp(context), 0)
                this.layoutParams = params
            }
    
            fun View.setMarginVertical(value: Int) {
                var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(0, value.toDp(context), 0, value.toDp(context))
                this.layoutParams = params
            }
        }

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
    
    class EditTextManager {
        companion object {
            fun setMaxLength(editText: EditText, maxLength: Int) {
                editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
            }
        }
    }
    
    class TabLayoutManager {
        companion object {
            fun TabLayout.Tab.getTextView(tabs: TabLayout): TextView {
                val tabLayout = (tabs.getChildAt(0) as ViewGroup).getChildAt(this.position) as LinearLayout
                return tabLayout.getChildAt(1) as TextView
            }
        }
    }
    
    class TextColorManager {
        companion object {
            fun createStateColor(context: Context?, unPressedColor: Int, pressedColor: Int): ColorStateList? {
                context ?: return null
                return ColorStateList(
                    arrayOf(
                        intArrayOf(android.R.attr.state_pressed),
                        intArrayOf()
                    ),
                    intArrayOf(
                        pressedColor,
                        unPressedColor
                    )
                )
            }
        }
    }
}