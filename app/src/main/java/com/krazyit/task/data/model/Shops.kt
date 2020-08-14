package com.krazyit.task.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Shops(
    @SerializedName("abn")
    val abn: String,
    @SerializedName("accept_ms")
    val acceptMs: Int,
    @SerializedName("city")
    val city: String,
    @SerializedName("cover_photo")
    val coverPhoto: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("post_code")
    val postCode: String,
    @SerializedName("ps_duration")
    val psDuration: String,
    @SerializedName("ps_type")
    val psType: String,
    @SerializedName("shop_cat")
    val shopCat: Int,
    @SerializedName("shop_email")
    val shopEmail: String,
    @SerializedName("shop_logo")
    val shopLogo: String,
    @SerializedName("shop_mobile")
    val shopMobile: String,
    @SerializedName("shop_name")
    val shopName: String,
    @SerializedName("shop_telephone")
    val shopTelephone: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("vendor_id")
    val vendorId: String
): Parcelable