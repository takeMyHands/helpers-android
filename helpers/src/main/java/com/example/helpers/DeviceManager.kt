package com.example.helpers

import android.content.Context
import android.os.Build
import android.provider.Settings
import android.util.Log

class DeviceManager {
    companion object {
        val TAG = DeviceManager::class.simpleName

        fun getDeviceVersion(): Int {
            return Build.VERSION.SDK_INT
        }
        
        fun getDeviceId(context: Context): String {
            return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }
    
        fun getDeviceModel(): String {
            return Build.MODEL
        }
    
        fun getDeviceOs(): String {
            return Build.VERSION.RELEASE.toString()
        }
    }
}