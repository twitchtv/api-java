package callback

import org.json.JSONArray
import java.lang.Exception

/**
 * Wrapper.OnSuccessCallback updated to Kotlin from java
 * Callback used to retrieve data from wrapper
 *
 * Created at: 2017-11-21
 * Updated at: 2018-02-10
 *
 * Created by Filip
 *
 **/
interface OnSuccessCallback {
    fun onSuccess(result: JSONArray)
    fun onError(error: Exception)
}