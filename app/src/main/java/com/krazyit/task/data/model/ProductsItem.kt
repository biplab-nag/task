package com.krazyit.task.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class ProductsItem(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: String,
    @SerializedName("delivery_in")
    val deliveryIn: String,
    @SerializedName("hashid")
    val hashid: String,
    @SerializedName("highlights")
    val highlights: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("ingrediants")
    val ingrediants: String,
    @SerializedName("mate_care")
    val mateCare: String,
    @SerializedName("pmt_type")
    val pmtType: String,
    @SerializedName("prod_brand_id")
    val prodBrandId: Int,
    @SerializedName("prod_cat_id")
    val prodCatId: Int,
    @SerializedName("prod_color")
    val prodColor: List<String>,
    @SerializedName("prod_description")
    val prodDescription: String,
    @SerializedName("prod_discount")
    val prodDiscount: String,
    @SerializedName("prod_images")
    val prodImages: List<String>,
    @SerializedName("prod_name")
    val prodName: String,
    @SerializedName("prod_price")
    val prodPrice: String,
    @SerializedName("prod_size")
    val prodSize: List<String>,
    @SerializedName("prod_slug")
    val prodSlug: String,
    @SerializedName("prod_status")
    val prodStatus: String,
    @SerializedName("prod_subcat_id")
    val prodSubcatId: Int,
    @SerializedName("prod_subcattwo_id")
    val prodSubcattwoId: Int,
    @SerializedName("prod_unit")
    val prodUnit: String,
    @SerializedName("prod_unit_val")
    val prodUnitVal: String,
    @SerializedName("product_tags")
    val productTags: List<String>,
    @SerializedName("quantity")
    val quantity: String,
    @SerializedName("selling_platform")
    val sellingPlatform: String,
    @SerializedName("shop_id")
    val shopId: Int,
    @SerializedName("shops")
    val shops: Shops,
    @SerializedName("size_fit")
    val sizeFit: String,
    @SerializedName("skip_stock")
    val skipStock: Int,
    @SerializedName("sku")
    val sku: String,
    @SerializedName("sp_end_dt")
    val spEndDt: String,
    @SerializedName("sp_st_date")
    val spStDate: String,
    @SerializedName("special_price")
    val specialPrice: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int
): Parcelable