package callback

import org.json.JSONArray
import java.lang.Exception

interface onSuccessCallback {
    fun onSuccess(result: JSONArray)
    fun onError(error: Exception)
}