package wrapper

/**
 * Wrapper.Version created for IGDBWrapper
 * Lets users use /pro/ for query
 *
 * Created at: 2018-02-10
 *
 * Created by Filip
 *
 **/
enum class Version {
    STANDARD, PRO
}

/**
 * Wrapper.Endpoint updated to Kotlin from java
 * Lets users access Endpoint
 *
 * Created at: 2017-11-21
 * Updated at: 2018-02-10
 *
 * Created by Filip
 *
 **/
enum class Endpoint {
    CHARACTERS, COLLECTIONS, COMPANIES, CREDITS, FEEDS, FRANCHISES, GAME_ENGINES, GAME_MODES, GAMES,
    GENRES, KEYWORDS, PAGES, PEOPLE, PLATFORMS, PLAYER_PERSPECTIVES, PULSE_GROUPS,
    PULSE_SOURCES, PULSES, RELEASE_DATES, REVIEWS, THEMES, TITLES
}

/**
 * HttpMethod enums helps the user pick the correct request methods for the wrapper
 *
 * Created at: 2018-02-22
 *
 * created by Filip
 * **/
enum class HttpMethod {
    GET, POST, PATCH, DELETE
}