package com.example.list_view

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

data class movie(
    val popularity:Float,
    val vote_count:Int,
    val video:Boolean,
    val poster_path:String,
    val id:Int,
    val adult:Boolean,
    val backdrop_path:String,
    val original_language:String,
    val original_title: String,
    val genre_ids: List<Int>,
    val title: String,
    val vote_average: Float,
    val overview:String,
    val release_date:String
)/*
class movieDeserializer : JsonDeserializer<movie> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): movie {
        json as JsonObject
        val popularity=json.get("popularity").asFloat
        val vote_count=json.get("vote_count").asInt
        val video=json.get("video").asBoolean
        val poster_path=json.get("poster_path").asString
        val id=json.get("id").asInt
        val adult=json.get("adult").asBoolean
        val backdrop_path=json.get("backdrop_path").asString
        val original_language=json.get("original_language").asString
        val original_title = json.get("original_title").asString
        val genre=json.get("genre_ids")
        val genre_ids= if(genre.isJsonArray) genre.asInt else genre.asInt
        val title=json.get("title").asString
        val vote_average=json.get("vote_average").asFloat
        val overview=json.get("overview").asString
        val release_date=json.get("release_date").asString
        return movie(popularity,vote_count,video,poster_path,id,adult,backdrop_path,original_language,original_title,genre_ids,title,vote_average,overview,release_date)
    }
}*/