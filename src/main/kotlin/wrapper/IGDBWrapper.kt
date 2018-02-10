package wrapper

import callback.OnSuccessCallback
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

/**
* Wrapper.IGDBWrapper updated to Kotlin from java
 * Lets users access IGDB API with java
 *
 * Created at: 2017-11-21
 * Updated at: 2018-02-10
 *
 * Created by Filip
*
**/
class IGDBWrapper(private val API_KEY: String, version: Version = Version.PRO, val debug: Boolean = false) {
    private var apiURL: String = "https://api-endpoint.igdb.com/"
    private val apiHeader: String = "user-key"
    private var httpClient: OkHttpClient = OkHttpClient()

    init {
        if (version == Version.PRO) {
            apiURL += "pro/"
        }
    }

    /**
     * This method returns a JSONArray with the specified data requested,
     * with this method you can request any kind of data from the IGDB API using custom urls.
     *
     * @param url       The url stands for the query, except for the standard 3Scale url,
     *                  where the requested data is specified.
     * @param callback  The callback return the response from the server in the form of a JSONArray
     *
     **/
    fun getJSONArray(url: String, callback: OnSuccessCallback) {
        val completeURL = apiURL + url

        if (debug) {
            println(completeURL)
        }

        val request: Request = Request.Builder()
                .url(completeURL)
                .header(apiHeader, API_KEY)
                .addHeader("Accept", "application/json")
                .build()


        httpClient.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call?, response: Response?) {
                val jsonResponse = JSONArray(response?.body()?.string())
                callback.onSuccess(jsonResponse)
            }

            override fun onFailure(call: Call?, exception: IOException?) {
                callback.onError(exception!!)
            }
        })
    }

    /**
     * This method returns a JSONArray with the specified data requested,
     * with this method you can request any kind of data from the IGDB API using custom urls.
     *
     * @param url               The url stands for the query, except for the standard 3Scale url,
     *                          where the requested data is specified.
     * @param headers           Add custom headers(okhttp3)
     * @param callback          The callback return the response from the server in the form of a JSONArray
     *
     **/
    fun getJSONArray(url: String, headers: Headers, callback: OnSuccessCallback) {
        val completeURL = apiURL + url

        val request: Request = Request.Builder()
                .url(completeURL)
                .headers(headers)
                .build()


        httpClient.newCall(request).enqueue(object: Callback{
            override fun onResponse(call: Call?, response: Response?) {
                val jsonResponse = JSONArray(response?.body()?.string())
                callback.onSuccess(jsonResponse)
            }

            override fun onFailure(call: Call?, exception: IOException?) {
                callback.onError(exception!!)
            }
        })
    }

    /**
     * Search the IGDB API for information
     *
     * @param endpoint      Apply for which Endpoint to search in.
     * @param parameters    Args are the arguments, Ex: search query, fields, order etc.
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     * **/
    fun search(endpoint: Endpoint, parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(endpoint), callback)
    }

    /**
     * Games method returns a JSONArray containing the game information requested.
     *
     * @param parameters    The arguments added to specify the result, Ex parameters.addFilter("[cover][exists]")
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     * */
    fun games(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.GAMES), callback)
    }

    /**
     * Pulse method returns a JSONArray containing the pulse information requested.
     *
     * @param parameters    The arguments added to specify the result.
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     * */
    fun pulses(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.PULSES), callback)
    }

    /**
     * Characters method returns a JSONArray containing the character information requested.
     *
     * @param parameters    The arguments added to specify the result.
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     * */
    fun characters(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.CHARACTERS), callback)
    }

    /**
     * Collections method returns a JSONArray containing the collection information requested.
     *
     * @param parameters    The arguments added to specify the result.
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     * */
    fun collections(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.COLLECTIONS), callback)
    }

    /**
     * Companies method returns a JSONArray containing the company information requested.
     *
     * @param parameters    The arguments added to specify the result.
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     * */
    fun companies(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.COMPANIES), callback)
    }

    /**
     * Franchises method returns a JSONArray containing the franchise information requested.
     *
     * @param parameters    The arguments added to specify the result.
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     * */
    fun franchises(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.FRANCHISES), callback)
    }

    /**
     * Feed method returns a JSONArray containing the feed information requested.
     *
     * @param parameters    The arguments added to specify the result.
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun feeds(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.FEEDS), callback)
    }

    /**
     * Pages method returns a JSONArray containing the page information requested.
     *
     * @param parameters    The arguments added to specify the result.
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun pages(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.PAGES), callback)
    }

    /**
     * GameEngine method returns a JSONArray containing the game engine information requested.
     *
     * @param parameters    The arguments added to specify the result.
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun gameEngines(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.GAME_ENGINES), callback)
    }

    /**
     * GameModes method returns a JSONArray containing the game mode information requested.
     *
     * @param parameters    The arguments added to specify the result, Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                  API.
     **/
    fun gameModes(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.GAME_MODES), callback)
    }

    /**
     * Genres method returns a JSONArray containing the genre information requested.
     *
     * @param parameters    The arguments added to specify the result, Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun genres(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.GENRES), callback)
    }

    /**
     * Keywords method returns a JSONArray containing the keyword information requested.
     *
     * @param parameters    The arguments added to specify the result, Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun keywords(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.KEYWORDS), callback)
    }

    /**
     * People method returns a JSONArray containing the people information requested.
     *
     * @param parameters    The arguments added to specify the result, Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun people(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.PEOPLE), callback)
    }

    /**
     * Platforms method returns a JSONArray containing the platform information requested.
     *
     * @param parameters    The arguments added to specify the result, Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun platforms(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.PLATFORMS), callback)
    }

    /**
     * PlayerPerspectives method returns a JSONArray containing the player perspective information
     * requested.
     *
     * @param parameters    The arguments added to specify the result, Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun playerPerspectives(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.PLAYER_PERSPECTIVES), callback)
    }

    /**
     * ReleaseDates method returns a JSONArray containing the release date information requested.
     *
     * @param parameters    The arguments added to specify the result, Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     * */
    fun releaseDates(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.RELEASE_DATES), callback)
    }

    /**
     * PulseGroups method returns a JSONArray containing the pulse group information requested.
     *
     * @param parameters    The arguments added to specify the result, Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun pulseGroups(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.PULSE_GROUPS), callback)
    }

    /**
     * PulseSources method returns a JSONArray containing the pulse source information requested.
     *
     * @param parameters    The arguments added to specify the result,  Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun pulseSources(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.PULSE_SOURCES), callback)
    }

    /**
     * Themes method returns a JSONArray containing the theme information requested.
     *
     * @param parameters    The arguments added to specify the result,  Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun themes(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.THEMES), callback)
    }

    /**
     * Reviews method returns a JSONArray containing the review information requested.
     *
     * @param parameters    The arguments added to specify the result,  Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun reviews(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.REVIEWS), callback)
    }

    /**
     * Titles method returns a JSONArray containing the title information requested.
     *
     * @param parameters    The arguments added to specify the result,  Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun titles(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.TITLES), callback)
    }

    /**
     * Credits method returns a JSONArray containing the credit information requested.
     *
     * @param parameters    The arguments added to specify the result,  Ex parameters.addFilter("[cover][exists]").
     * @param callback      Callback which gets activated as soon as the JSONArray is returned from the
     *                      API.
     **/
    fun credits(parameters: Parameters, callback: OnSuccessCallback) {
        getJSONArray(parameters.buildQuery(Endpoint.CREDITS), callback)
    }

}