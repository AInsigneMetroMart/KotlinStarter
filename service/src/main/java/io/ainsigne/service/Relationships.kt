package io.ainsigne.service

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class Relationships {
    @SerializedName("areas")
    var areas: MultiEntityWrapper? = null

    @SerializedName("locations")
    var locations: MultiEntityWrapper? = null

    @SerializedName("tag")
    var tag: SingleEntityWrapper? = null

    @SerializedName("shop")
    var shop: SingleEntityWrapper? = null

    @SerializedName("shops")
    var shops: MultiEntityWrapper? = null

    @SerializedName("related-shops")
    var related_shops: MultiEntityWrapper? = null

    @SerializedName("job-order")
    var job_order: SingleEntityWrapper? = null

    @SerializedName("job-orders")
    var job_orders: MultiEntityWrapper? = null

    @SerializedName("favorites")
    var favorites: MultiEntityWrapper? = null

    @SerializedName("products")
    var products: MultiEntityWrapper? = null

    @SerializedName("weights")
    var weights: MultiEntityWrapper? = null

    @SerializedName("aisles")
    var aisles: MultiEntityWrapper? = null

    @SerializedName("departments")
    var departments: MultiEntityWrapper? = null

    @SerializedName("items")
    var items: MultiEntityWrapper? = null

    @SerializedName("deliverables")
    var deliverables: MultiEntityWrapper? = null

    @SerializedName("area")
    var area: SingleEntityWrapper? = null

    @SerializedName("city")
    var city: SingleEntityWrapper? = null

    @SerializedName("user")
    var user: SingleEntityWrapper? = null

    @SerializedName("product")
    var product: SingleEntityWrapper? = null

    @SerializedName("profile")
    var profile: SingleEntityWrapper? = null

    @SerializedName("checkout")
    var checkout: SingleEntityWrapper? = null

    @SerializedName("weight")
    var weight: SingleEntityWrapper? = null

    @SerializedName("aisle")
    var aisle: SingleEntityWrapper? = null

    @SerializedName("department")
    var department: SingleEntityWrapper? = null

    @SerializedName("coupon")
    var coupon: SingleEntityWrapper? = null

    @SerializedName("consignments")
    var consignments: MultiEntityWrapper? = null

    @SerializedName("discounts")
    var discounts: MultiEntityWrapper? = null

    @SerializedName("telco")
    var telco: SingleEntityWrapper? = null

    @SerializedName("billers")
    var billers: MultiEntityWrapper? = null

    @SerializedName("biller-category")
    var biller_category: SingleEntityWrapper? = null

    @SerializedName("replacement")
    var replacement: SingleEntityWrapper? = null

    @SerializedName("with-deliverable")
    var with_deliverable: SingleEntityWrapper? = null

    @SerializedName("from-deliverable")
    var from_deliverable: SingleEntityWrapper? = null

    @SerializedName("restaurant")
    var restaurant: SingleEntityWrapper? = null

    //	@SerializedName("reservation-time-slots") public MultiEntityWrapper reservation_time_slot;
    @SerializedName("next-daily-discounted-reservation-time-slots")
    var reservation_time_slot: MultiEntityWrapper? = null

    @SerializedName("next-available-discounted-reservation-time-slot")
    var next_available_discounted_reservation_time_slot: SingleEntityWrapper? = null

    @SerializedName("table-address")
    var table_address: SingleEntityWrapper? = null

    @SerializedName("cuisines")
    var cuisines: MultiEntityWrapper? = null

    @SerializedName("terms-and-conditions")
    var terms_and_conditions: MultiEntityWrapper? = null

    @SerializedName("landmarks")
    var landmarks: MultiEntityWrapper? = null

    @SerializedName("table-addresses")
    var table_addresses: MultiEntityWrapper? = null

    @SerializedName("boundary-coordinates")
    var boundary_coordinates: MultiEntityWrapper? = null

    @SerializedName("active-fmcg-campaigns")
    var active_fmcg_campaigns: MultiEntityWrapper? = null

    @SerializedName("fmcg-campaign")
    var fmcg_campaign: SingleEntityWrapper? = null

    @SerializedName("fmcg-campaign-vouchers")
    var fmcg_campaign_vouchers: MultiEntityWrapper? = null

    @SerializedName("fmcg-campaign-voucher")
    var fmcg_campaign_voucher: SingleEntityWrapper? = null

    @SerializedName("job-order-fmcg-campaign-vouchers")
    var job_order_fmcg_campaign_vouchers: MultiEntityWrapper? = null

    @SerializedName("qualified-fmcg-campaign-voucher")
    var qualified_fmcg_campaign_voucher: SingleEntityResponse? = null

    @SerializedName("qualified-chz-campaign")
    var qualified_chz_campaign: SingleEntityResponse? = null

    @SerializedName("chz-campaign")
    var chz_campaign: SingleEntityResponse? = null

    @SerializedName("brands")
    var brand: MultiEntityWrapper? = null

    @SerializedName("payment-card")
    var payment_card: MultiEntityWrapper? = null

    @SerializedName("banners-shops")
    var banners_shops: SingleEntityWrapper? = null

    @SerializedName("promo-landing-page")
    var promo_landing_page: SingleEntityWrapper? = null

    @SerializedName("new-item")
    var new_item: SingleEntityWrapper? = null

    @SerializedName("take-y-products")
    var take_y_products: MultiEntityWrapper? = null

    @SerializedName("buy-x-take-y-deliverable")
    var buy_x_take_y_deliverable: SingleEntityWrapper? = null

    @SerializedName("buy-x-weight")
    var buy_x_weight: SingleEntityWrapper? = null

    @SerializedName("take-y-weight")
    var take_y_weight: SingleEntityWrapper? = null

    @SerializedName("replaced-withs")
    var replaced_withs: MultiEntityWrapper? = null

    @SerializedName("replaced-froms")
    var replaced_froms: MultiEntityWrapper? = null

    @SerializedName("replacements")
    var replacements: MultiEntityWrapper? = null
    override fun toString(): String {
        return Gson().toJson(this)
    }
}