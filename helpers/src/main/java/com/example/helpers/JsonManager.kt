package com.example.helpers

import com.example.helpers.Status.HTTP_200_OK
import com.example.helpers.Status.RESPONSE_STATUS
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject

object JsonManager {
    val TAG = JsonManager::class.simpleName

    fun jsonToJson(parameter: JSONObject): JsonObject {
        return JsonParser().parse(parameter.toString()) as JsonObject
    }

    fun resultOnlyOk(): JsonObject {
        return jsonToJson(JSONObject().apply {
            this.put(RESPONSE_STATUS, HTTP_200_OK)
        })
    }
}