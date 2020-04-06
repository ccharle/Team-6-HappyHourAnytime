package org.pursuit.team_6_happyhouranytime.network.webutils

import org.pursuit.team_6_happyhouranytime.network.errorutil.Definition

enum class BaseUrl(var baseUrl: String) : Definition {
    COCKTAILS("https://www.thecocktaildb.com");

    lateinit var baseURl: String

    fun Url(baseUrl: String) {
        this.baseUrl = baseURl
    }

    fun getURl(): String? {
        return baseURl
    }

    override fun getName(): String? {
        return name
    }

}