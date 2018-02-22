package callback

import org.json.JSONArray
import org.json.JSONObject
/**
 * Wrapper.OnSuccessCallback updated to Kotlin from java
 * Callback used to retrieve data from wrapper
 *
 * Created at: 2017-11-21
 * Updated at: 2018-02-22
 *
 * Created by Filip
 *
 **/
interface OnSuccessCallback {
    fun onSuccess(result: JSONArray)
    fun onSuccess(result: JSONObject)
    fun onError(error: Exception)
}

/**
 * OnRequestSuccessCallback is an abstract class created for the updated OnSuccessCallback.
 * This callback method will let the user decide which onSuccess method to use for their request.
 * JSONArray for GET requests and JSONObject for the others.
 *
 * Created at: 2018-02-22
 *
 * Created by Filip
 * **/
abstract class OnRequestSuccessCallback: OnSuccessCallback {
    override fun onSuccess(result: JSONObject) {  }
    override fun onSuccess(result: JSONArray) {  }
}