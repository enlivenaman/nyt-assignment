package com.amansaxena.nyt.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopStoryModelResponse(
    @Expose
    @SerializedName("status")
    val status: String,

    @Expose
    @SerializedName("copyright")
    val copyright: String,

    @Expose
    @SerializedName("section")
    val section: String,

    @Expose
    @SerializedName("last_updated")
    val last_updated: String,

    @Expose
    @SerializedName("num_results")
    val num_results: Int,

    @Expose
    @SerializedName("results")
    val results: List<TopStoryModel>
)

data class TopStoryModel(

    @Expose
    @SerializedName("section")
    val section: String,

    @Expose
    @SerializedName("subsection")
    val subsection: String,

    @Expose
    @SerializedName("title")
    val title: String,

    @Expose
    @SerializedName("abstract")
    val abstract: String,

    @Expose
    @SerializedName("url")
    val url: String,

    @Expose
    @SerializedName("uri")
    val uri: String,

    @Expose
    @SerializedName("byline")
    val byline: String,

    @Expose
    @SerializedName("item_")
    val item_: String,

    @Expose
    @SerializedName("updated_date")
    val updated_date: String,

    @Expose
    @SerializedName("created_date")
    val created_date: String,

    @Expose
    @SerializedName("published_date")
    val published_date: String,

    @Expose
    @SerializedName("material_type_facet")
    val material_type_facet: String,

    @Expose
    @SerializedName("kicker")
    val kicker: String,

    @Expose
    @SerializedName("des_facet")
    val des_facet: List<String>,

    @Expose
    @SerializedName("org_facet")
    val org_facet: List<String>,

    @Expose
    @SerializedName("per_facet")
    val per_facet: List<String>,

    @Expose
    @SerializedName("geo_facet")
    val geo_facet: List<String>,

    @Expose
    @SerializedName("multimedia")
    val multimedia: List<MultimediaModel>
)

data class MultimediaModel(

    @Expose
    @SerializedName("url")
    val url: String,

    @Expose
    @SerializedName("format")
    val format: String,

    @Expose
    @SerializedName("height")
    val height: Int,

    @Expose
    @SerializedName("width")
    val width: Int,

    @Expose
    @SerializedName("type")
    val type: String,

    @Expose
    @SerializedName("subtype")
    val subtype: String,

    @Expose
    @SerializedName("caption")
    val caption: String,

    @Expose
    @SerializedName("copyright")
    val copyright: String
)
