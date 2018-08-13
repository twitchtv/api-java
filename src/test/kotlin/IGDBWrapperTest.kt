

import callback.OnRequestSuccessCallback
import callback.OnSuccessCallback
import junit.framework.Assert.fail
import okhttp3.Headers
import okhttp3.RequestBody
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.junit.Test
import wrapper.*
import java.lang.Exception
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class IGDBWrapperTest {
    private lateinit var wrapper: IGDBWrapper

    @org.junit.Before
    fun setUp(){
        val key: String = System.getenv("API_KEY")
        wrapper = IGDBWrapper(key, Version.STANDARD, true)
    }

//    @Test
//    fun testPostReview() {
//        val completeURL = "private/rates/165141"
//        val authHeaders = Headers.Builder()
//                .add("user-key", System.getenv("API_KEY"))
//                .add("Accept", "application/json")
//                .add("Authorization", "Bearer 0933a367316cb2d1501f98b0d04057f1914c5859c68904f789177bbfa96b3162")
//                .add("Content-Type", "application/json")
//                .build()
//
//        val testRequestBody = "{\"rate\": {\"game\": " + 965 + ", \"rating\": " + 3 + "}}"
//        val body = RequestBody.create(null, testRequestBody)
//        val lock = CountDownLatch(1)
//
//        wrapper.getJSONArray(completeURL, authHeaders, HttpMethod.PATCH, body, object : OnRequestSuccessCallback() {
//
//            override fun onSuccess(result: JSONObject) {
//                lock.countDown()
//                print(result)
//            }
//
//            override fun onError(error: Exception) {
//                print(error)
//            }
//        })
//        lock.await(20, TimeUnit.SECONDS)
//    }

    @Test
    fun search() {
        val params = Parameters()
                .addSearch("mass effect")
                .addFields("*")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.search(Endpoint.GAMES, params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val gameObject: JSONObject = result.getJSONObject(0)
                    val name = gameObject.getString("name")
                    val url = gameObject.getString("url")
                    assert(url.equals("https://www.igdb.com/games/mass-effect") && name.equals("Mass Effect"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }

    @Test
    fun games() {
        val params = Parameters()
                .addIds("12356")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.games(params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val gameObject: JSONObject = result.getJSONObject(0)
                    val slug = gameObject.getString("slug")
                    assert(slug.equals("3d-quasars"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }

    @Test
    fun pulses() {
        val params = Parameters()
                .addIds("12342")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.pulses(params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val pulseObject: JSONObject = result.getJSONObject(0)
                    val title = pulseObject.getString("title")
                    assert(title.equals("A First Look Inside the Sailor Moon Museum Exhibit"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }

    @Test
    fun genres() {
        val params = Parameters()
                .addIds("5")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.genres(params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val genreObject: JSONObject = result.getJSONObject(0)
                    val genre = genreObject.getString("name")
                    assert(genre.equals("Shooter"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }

    @Test
    fun platforms() {
        val params = Parameters()
                .addIds("5")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.platforms(params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val platformObject: JSONObject = result.getJSONObject(0)
                    val name = platformObject.getString("name")
                    assert(name.equals("Wii"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }

    @Test
    fun releaseDates() {
        val params = Parameters()
                .addIds("4")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.releaseDates(params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val releaseObject: JSONObject = result.getJSONObject(0)
                    val date = releaseObject.getString("human")
                    assert(date.equals("2008-Oct-20"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }

    @Test
    fun pulseGroups() {
        val params = Parameters()
                .addIds("1254")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.pulseGroups(params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val groupObject: JSONObject = result.getJSONObject(0)
                    val name = groupObject.getString("name")
                    assert(name.equals("Marvel vs. Capcom: Infinite"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }

    @Test
    fun pulseSources() {
        val params = Parameters()
                .addIds("1")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.pulseSources(params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val sourceObject: JSONObject = result.getJSONObject(0)
                    val name = sourceObject.getString("name")
                    assert(name.equals("Kotaku"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }

    @Test
    fun themes() {
        val params = Parameters()
                .addIds("42")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.themes(params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val themeObject: JSONObject = result.getJSONObject(0)
                    val name = themeObject.getString("name")
                    assert(name.equals("Erotic"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }

    @Test
    fun reviews() {
        val params = Parameters()
                .addIds("42")

        val lock: CountDownLatch = CountDownLatch(1)

        wrapper.reviews(params, object: OnSuccessCallback {
            override fun onSuccess(result: JSONArray) {
                try {
                    lock.countDown()
                    val reviewObject: JSONObject = result.getJSONObject(0)
                    val title = reviewObject.getString("title")
                    assert(title.equals("This is a game"))
                } catch (e: JSONException) {
                    fail("JSONException! ${e.message}")
                }
            }

            override fun onSuccess(result: JSONObject) {
            }

            override fun onError(error: Exception) {
                fail("Received HTTP error: ${error.cause}")
            }
        })
        lock.await(20, TimeUnit.SECONDS)
    }
}