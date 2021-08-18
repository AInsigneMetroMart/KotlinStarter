package io.ainsigne.service

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class AttributesBase {
    var token: String? = null
    var email: String? = null
    var alcoholic = false
    var approved = false
    var closed = false
    var instructions: String? = null
    var size: String? = null
    var count = 0
    var shop_name: String? = null
    var title: String? = null

    @SerializedName("express")
    var express = false

    @SerializedName("delivery-fee-in-cents")
    var delivery_fee_in_cents = 0

    @SerializedName("free-delivery")
    var isFreeDelivery = false

    @SerializedName("free-delivery-fee")
    var isFreeDeliveryFee = false

    @SerializedName("status-updated-at")
    var status_updated_at: String? = null

    @SerializedName("delivery-status-updated-at")
    var delivery_status_updated_at: String? = null

    @SerializedName("delivery-status")
    var delivery_status: String? = null

    @SerializedName("created-at")
    var created_at: String? = null

    @SerializedName("updated-at")
    var updated_at: String? = null

    @SerializedName("settled-at")
    var settled_at: String? = null

    @SerializedName("payment-status-updated-at")
    var payment_status_updated_at: String? = null

    @SerializedName("settlement-status")
    var settlement_status: String? = null

    @SerializedName("settlement-status-updated-at")
    var settlement_status_updated_at: String? = null

    @SerializedName("payload-fields")
    var payload: Payload? = null

    @SerializedName("service-fee-in-cents")
    var service_fee_in_cents = 0

    @SerializedName("shopping-fee-in-cents")
    var shopping_fee_in_cents = 0

    @SerializedName("shopping-fee-tier-one-percentage")
    var shopping_fee_tier_one_percentage = 0f

    @SerializedName("shopping-fee-tier-two-percentage")
    var shopping_fee_tier_two_percentage = 0f

    @SerializedName("shopping-fee-tier-two-percentage-threshold-in-cents")
    var shopping_fee_tier_two_percentage_threshold_in_cents = 0

    @SerializedName("shopping-fee-kind")
    var shopping_fee_kind: String? = null

    @SerializedName("max-items-count")
    var max_items_count = 0

    @SerializedName("membership-enrolled")
    var membership_enrolled = false

    @SerializedName("non-membership-fee-percentage")
    var non_membership_fee_percentage = 0f

    @SerializedName("non-membership-fee-in-cents")
    var non_membership_fee_in_cents = 0

    @SerializedName("membership-fee-in-cents")
    var membership_fee_in_cents = 0

    @SerializedName("original-non-membership-fee-in-cents")
    var original_non_membership_fee_in_cents = 0

    @SerializedName("send-to")
    var send_to: String? = null

    @SerializedName("mobile-image-url")
    var mobile_image_url: String? = null

    @SerializedName("mobile-image-path")
    var mobile_image_path: String? = null

    @SerializedName("addresses-count")
    var addresses_count = 0
    var message: String? = null

    @SerializedName("referral-code")
    var referral_code: String? = null

    @SerializedName("referrals-remaining")
    var referrals_remaining = 0

    @SerializedName("profile-type")
    var profile_type: String? = null

    @SerializedName("profile-id")
    var profile_id: String? = null

    @SerializedName("current-password-set")
    var current_password_set = false

    @SerializedName("time-zone")
    var time_zone: String? = null

    @SerializedName("time-zone-iana-olson")
    var time_zone_iana_olson: String? = null

    @SerializedName("time-zone-utc-offset")
    var time_zone_utc_offset: String? = null

    @SerializedName("value")
    var value = 0.0

    @SerializedName("default")
    var selected_default = false

    @SerializedName("weighted")
    var weighted = false

    @SerializedName("weighted-disclaimer")
    var weighted_disclaimer: String? = null

    @SerializedName("long-description")
    var long_description: String? = null

    @SerializedName("short-description")
    var short_description: String? = null

    @SerializedName("recently-shopped-at")
    var recently_shopped: String? = null

    @SerializedName("free-delivery-minimum-in-cents")
    var free_delivery_minimum_in_cents = 0

    @SerializedName("free-delivery-fee-minimum-in-cents")
    var free_delivery_fee_minimum_in_cents = 0

    @SerializedName("text-color")
    var text_color: String? = null

    @SerializedName("background-color")
    var background_color: String? = null

    @SerializedName("banner-background-color")
    var banner_background_color: String? = null

    @SerializedName("border-color")
    var border_color: String? = null

    @SerializedName("banner-text-color")
    var banner_text_color: String? = null

    @SerializedName("logo-url")
    var logo_url: String? = null

    @SerializedName("logo-path")
    var logo_path: String? = null

    @SerializedName("banner-url")
    var banner_url: String? = null

    @SerializedName("banner-path")
    var banner_path: String? = null

    @SerializedName("mobile-banner-url")
    var mobile_banner_url: String? = null

    @SerializedName("mobile-banner-path")
    var mobile_banner_path: String? = null

    @SerializedName("mobile-icon-url")
    var mobile_icon_url: String? = null

    @SerializedName("mobile-icon-path")
    var mobile_icon_path: String? = null

    @SerializedName("mobile-shop-in-shop-banner-url")
    var mobile_shop_in_shop_banner_url: String? = null

    @SerializedName("mobile-shop-in-shop-banner-path")
    var mobile_shop_in_shop_banner_path: String? = null

    @SerializedName("opening-hour")
    var opening_hour = 0

    @SerializedName("closing-hour")
    var closing_hour = 0

    @SerializedName("closed-until")
    var closed_until: String? = null

    @SerializedName("new-arrival-products-count")
    var new_arrival_products_count = 0

    @SerializedName("popular-products-count")
    var popular_products_count = 0

    @SerializedName("products-on-sale-count")
    var products_on_sale_count = 0

    @SerializedName("products-on-markup-count")
    var products_on_markup_count = 0

    @SerializedName("products-count")
    var products_count = 0

    @SerializedName("original-count")
    var original_count = 0

    @SerializedName("on-sale")
    var on_sale = false

    @SerializedName("available-products-count")
    var available_products_count = 0

    @SerializedName("inactive-logo-url")
    var inactive_logo_url: String? = null

    @SerializedName("inactive-background-color")
    var inactive_background_color: String? = null

    @SerializedName("inactive-border-color")
    var inactive_border_color: String? = null

    @SerializedName("minimum-purchase-in-cents")
    var minimum_purchase_in_cents = 0

    @SerializedName("opening-time")
    var opening_time: String? = null

    @SerializedName("closing-time")
    var closing_time: String? = null

    @SerializedName("monday-opening-time")
    var monday_opening_time: String? = null

    @SerializedName("monday-closing-time")
    var monday_closing_time: String? = null

    @SerializedName("tuesday-opening-time")
    var tuesday_opening_time: String? = null

    @SerializedName("tuesday-closing-time")
    var tuesday_closing_time: String? = null

    @SerializedName("wednesday-opening-time")
    var wednesday_opening_time: String? = null

    @SerializedName("wednesday-closing-time")
    var wednesday_closing_time: String? = null

    @SerializedName("thursday-opening-time")
    var thursday_opening_time: String? = null

    @SerializedName("thursday-closing-time")
    var thursday_closing_time: String? = null

    @SerializedName("friday-opening-time")
    var friday_opening_time: String? = null

    @SerializedName("friday-closing-time")
    var friday_closing_time: String? = null

    @SerializedName("saturday-opening-time")
    var saturday_opening_time: String? = null

    @SerializedName("saturday-closing-time")
    var saturday_closing_time: String? = null

    @SerializedName("sunday-opening-time")
    var sunday_opening_time: String? = null

    @SerializedName("sunday-closing-time")
    var sunday_closing_time: String? = null

    @SerializedName("next-opening-phrase")
    var next_opening_phrase: String? = null

    @SerializedName("next-delivery-phrase")
    var next_delivery_phrase: String? = null

    @SerializedName("next-delivery-from")
    var next_delivery_from: String? = null

    @SerializedName("next-opening-time-from")
    var next_opening_time_from: String? = null

    @SerializedName("next-opening-time-to")
    var next_opening_time_to: String? = null

    @SerializedName("change-for-in-cents")
    var change_for_in_cents = 0

    @SerializedName("deliver-at")
    var deliver_at: String? = null

    @SerializedName("delivered-at")
    var delivered_at: String? = null

    @SerializedName("completed-at")
    var completed_at: String? = null

    @SerializedName("payment-status")
    var payment_status: String? = null

    @SerializedName("payment-failed-reason")
    var payment_failed_reason: String? = null

    @SerializedName("seen")
    var seen = false

    @SerializedName("payment-mode")
    var payment_mode: String? = null

    @SerializedName("replacement-preference")
    var replacement_preference: String? = null

    @SerializedName("for-replacement")
    var for_replacement = false

    @SerializedName("area-name")
    var area_name: String? = null

    @SerializedName("city-name")
    var city_name: String? = null

    @SerializedName("credit-amount-in-cents")
    var credit_amount_of_cents = 0

    @SerializedName("credit-card-last-digits")
    var credit_card_last_digits: String? = null

    @SerializedName("first-checkout")
    var first_checkout = false

    @SerializedName("checkouts-count")
    var checkouts_count = 0

    @SerializedName("settled")
    var settled = false

    @SerializedName("authorized-amount-in-cents")
    var authorized_amount_in_cents = 0

    @SerializedName("payment-card-charged-amount-in-cents")
    var payment_card_charged_amount_in_cents = 0

    @SerializedName("paid-cash-difference-in-cents")
    var paid_cash_difference_in_cents = 0

    @SerializedName("purchased-deliverables-amount-in-cents")
    var purchased_deliverables_amount_in_cents = 0

    @SerializedName("deliverables-amount-in-cents")
    var deliverables_amount_in_cents = 0

    @SerializedName("original-deliverables-amount-in-cents")
    var original_deliverables_amount_in_cents = 0

    @SerializedName("deliverables-purchased-count")
    var deliverables_purchased_count = 0

    @SerializedName("deliverables-count")
    var deliverables_count = 0

    @SerializedName("total-count")
    var total_count = 0

    @SerializedName("total-original-count")
    var total_original_count = 0

    @SerializedName("amount-in-cents")
    var amount_in_cents = 0

    @SerializedName("total-amount-in-cents")
    var total_amount_in_cents = 0

    @SerializedName("total-original-amount-in-cents")
    var total_original_amount_in_cents = 0

    @SerializedName("total-take-y-count")
    var total_take_y_count = 0

    @SerializedName("total-take-y-weight-value")
    var total_take_y_weight_value = 0.0

    @SerializedName("original-amount-in-cents")
    var original_amount_in_cents = 0

    @SerializedName("base-amount-in-cents")
    var base_amount_in_cents = 0

    @SerializedName("priority")
    var priority = 0

    @SerializedName("external-aisle-code")
    var external_aisle_code: String? = null

    @SerializedName("per-unit-amount-in-cents")
    var per_unit_amount_in_cents = 0

    @SerializedName("weight-multiplier")
    var weight_multiplier = 0f

    @SerializedName("weight-metric")
    var weight_metric: String? = null

    @SerializedName("weight-value")
    var weight_value = 0f

    @SerializedName("total-weight-value")
    var total_weight_value = 0f

    @SerializedName("original-weight-value")
    var original_weight_value = 0f

    @SerializedName("total-original-weight-value")
    var total_original_weight_value = 0f

    @SerializedName("added")
    var added = false

    @SerializedName("image-url")
    var image_url: String? = null

    @SerializedName("image-path")
    var image_path: String? = null

    @SerializedName("image-drawable")
    var image_drawable = 0

    @SerializedName("image-740x740")
    var image_740_740: String? = null

    @SerializedName("image-308x308")
    var image_308_308: String? = null

    @SerializedName("image-160x160")
    var image_160_160: String? = null

    @SerializedName("watermark-path")
    var watermark_path: String? = null

    @SerializedName("first-name")
    var first_name: String? = null

    @SerializedName("last-name")
    var last_name: String? = null

    @SerializedName("snr-membership-first-name")
    var snr_membership_first_name: String? = null

    @SerializedName("snr-membership-last-name")
    var snr_membership_last_name: String? = null

    @SerializedName("snr-membership-birth-date")
    var snr_membership_birth_date: String? = null

    @SerializedName("snr-membership-number")
    var snr_membership_number: String? = null

    @SerializedName("snr-membership-status")
    var snr_member_status: String? = null

    @SerializedName("snr-membership-expire-at")
    var snr_membership_expire_at: String? = null

    @SerializedName("snr-field-visible")
    var snr_field_visible = false

    @SerializedName("discount-type")
    var discount_type: String? = null

    @SerializedName("display-name")
    var display_name: String? = null

    @SerializedName("percent-off")
    var percent_off = 0.0

    @SerializedName("sum-in-cents-off")
    var sum_in_cents_off = 0

    @SerializedName("iso8601")
    var iso8601: String? = null

    @SerializedName("datetime")
    var datetime: String? = null

    @SerializedName("duration-in-minutes")
    var duration_in_minutes = 0

    @SerializedName("active")
    var active = false

    @SerializedName("now")
    var now = false

    @SerializedName("cart-items-discount-in-cents")
    var promotion_discount_in_cents = 0

    @SerializedName("promo-initiative-type")
    var promo_initiative_type: String? = null

    @SerializedName("coupon-discount-in-cents")
    var coupon_discount_in_cents = 0

    @SerializedName("fmcg-voucher-discount-in-cents")
    var fmcg_voucher_discount_in_cents = 0

    @SerializedName("fmcg-campaign-discount-in-cents")
    var fmcg_campaign_discount_in_cents = 0

    @SerializedName("chz-campaign-discount-in-cents")
    var chz_campaign_discount_in_cents = 0

    @SerializedName("primary")
    var primary = false

    @SerializedName("nw-quadrant-latitude")
    var nw_quadrant_latitude = 0.0

    @SerializedName("nw-quadrant-longitude")
    var nw_quadrant_longitude = 0.0

    @SerializedName("se-quadrant-latitude")
    var se_quadrant_latitude = 0.0

    @SerializedName("se-quadrant-longitude")
    var se_quadrant_longitude = 0.0

    @SerializedName("label-latitude")
    var label_latitude = 0.0

    @SerializedName("label-longitude")
    var label_longitude = 0.0

    @SerializedName("reference")
    var reference: String? = null

    @SerializedName("provider-reference")
    var provider_reference: String? = null

    @SerializedName("first-digits-of-card")
    var first_digits_of_card: String? = null

    @SerializedName("last-digits-of-card")
    var last_digits_of_card: String? = null

    @SerializedName("secured-card")
    var secure_card = false

    @SerializedName("authorization-request")
    var authorization_request: String? = null

    @SerializedName("merchant-data")
    var merchant_data: String? = null

    @SerializedName("issue-url")
    var issue_url: String? = null

    @SerializedName("verification-url")
    var verification_url: String? = null

    @SerializedName("version")
    var version: String? = null

    @SerializedName("update-kind")
    var update_kind: String? = null

    @SerializedName("platform")
    var platform: String? = null

    @SerializedName("app")
    var app: String? = null

    @SerializedName("expiry-month")
    var expiry_month = 0

    @SerializedName("expiry-year")
    var expiry_year = 0

    @SerializedName("payment-method-variant")
    var payment_method_variant: String? = null

    @SerializedName("variant")
    var variant: String? = null

    @SerializedName("scheme")
    var scheme: String? = null

    @SerializedName("card-bin")
    var card_bin = 0

    @SerializedName("last-four")
    var last_four: String? = null

    @SerializedName("first-six")
    var first_six: String? = null

    @SerializedName("keyword")
    var keyword: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("location-name")
    var location_name: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("atmosphere")
    var atmosphere: String? = null

    @SerializedName("price-rating")
    var price_rating: String? = null

    @SerializedName("image1-url")
    var image1_url: String? = null

    @SerializedName("image2-url")
    var image2_url: String? = null

    @SerializedName("image3-url")
    var image3_url: String? = null

    @SerializedName("image4-url")
    var image4_url: String? = null

    @SerializedName("image5-url")
    var image5_url: String? = null

    @SerializedName("conditions")
    var conditions: String? = null

    @SerializedName("what-to-do")
    var what_to_do: String? = null

    @SerializedName("longitude")
    var longitude = 0.0

    @SerializedName("latitude")
    var latitude = 0.0

    @SerializedName("day-name")
    var day_name: String? = null

    @SerializedName("day_of_week")
    var day_of_week = 0

    @SerializedName("from")
    var from: String? = null

    @SerializedName("to")
    var to: String? = null

    @SerializedName("discount")
    var discount: String? = null

    @SerializedName("available-count")
    var available_count = 0

    @SerializedName("used-count")
    var used_count = 0

    @SerializedName("min-seats-per-reservation-count")
    var min_seats_per_reservation_count = 0

    @SerializedName("max-seats-per-reservation-count")
    var max_seats_per_reservation_count = 0

    @SerializedName("reserved-on")
    var reserved_on: String? = null

    @SerializedName("original-reserved-on")
    var original_reserved_on: String? = null

    @SerializedName("original-discount")
    var original_discount: String? = null

    @SerializedName("number-of-seats")
    var number_of_seats: String? = null

    @SerializedName("original-number-of-seats")
    var original_number_of_seats: String? = null

    @SerializedName("original-contact-number")
    var original_contact_number: String? = null

    @SerializedName("attending-at")
    var attending_at: String? = null

    @SerializedName("attended-at")
    var attended_at: String? = null

    @SerializedName("no-show-at")
    var no_show_at: String? = null

    @SerializedName("cancelled-at")
    var cancelled_at: String? = null

    @SerializedName("monday-opening-hour")
    var monday_opening_hour: String? = null

    @SerializedName("monday-closing-hour")
    var monday_closing_hour: String? = null

    @SerializedName("tuesday-opening-hour")
    var tuesday_opening_hour: String? = null

    @SerializedName("tuesday-closing-hour")
    var tuesday_closing_hour: String? = null

    @SerializedName("wednesday-opening-hour")
    var wednesday_opening_hour: String? = null

    @SerializedName("wednesday-closing-hour")
    var wednesday_closing_hour: String? = null

    @SerializedName("thursday-opening-hour")
    var thursday_opening_hour: String? = null

    @SerializedName("thursday-closing-hour")
    var thursday_closing_hour: String? = null

    @SerializedName("friday-opening-hour")
    var friday_opening_hour: String? = null

    @SerializedName("friday-closing-hour")
    var friday_closing_hour: String? = null

    @SerializedName("saturday-opening-hour")
    var saturday_opening_hour: String? = null

    @SerializedName("saturday-closing-hour")
    var saturday_closing_hour: String? = null

    @SerializedName("sunday-opening-hour")
    var sunday_opening_hour: String? = null

    @SerializedName("sunday-closing-hour")
    var sunday_closing_hour: String? = null

    @SerializedName("code")
    var code: String? = null

    @SerializedName("monthly-popular-score")
    var monthly_popular_score: String? = null

    @SerializedName("full-name")
    var full_name: String? = null

    @SerializedName("original-full-name")
    var original_full_name: String? = null

    @SerializedName("operation-hours")
    var operation_hours: String? = null

    @SerializedName("terms-and-conditions")
    var terms_and_conditions: String? = null

    @SerializedName("this-week-discounted-percentages")
    var this_week_discounted_percentages: String? = null

    @SerializedName("buy-x-take-y")
    var buy_x_take_y = false

    @SerializedName("buy-x")
    var buy_x = 0

    @SerializedName("take-y")
    var take_y = 0

    @SerializedName("buy-x-weight-value")
    var buy_x_weight_value = 0.0

    @SerializedName("take-y-weight-value")
    var take_y_weight_value = 0.0

    @SerializedName("for-take-y")
    var for_take_y = false

    @SerializedName("products-with-buy-x-take-y-count")
    var products_with_buy_x_take_y_count = 0

    @SerializedName("ingredients")
    var ingredients: String? = null

    @SerializedName("country-of-origin")
    var country_of_origin: String? = null

    @SerializedName("contact-number")
    var contact_number: String? = null

    @SerializedName("short-address")
    var short_address: String? = null

    @SerializedName("address1")
    var address1: String? = null

    @SerializedName("address2")
    var address2: String? = null

    @SerializedName("address-label")
    var address_label: String? = null

    @SerializedName("label")
    var label: String? = null

    @SerializedName("kind")
    var kind: String? = null

    @SerializedName("landmark")
    var landmark: String? = null

    @SerializedName("status")
    var status: String? = null

    @SerializedName("slug")
    var slug: String? = null

    @SerializedName("icon-url")
    var icon_url: String? = null

    @SerializedName("icon-path")
    var icon_path: String? = null

    @SerializedName("fee-in-cents")
    var fee_in_cents = 0

    @SerializedName("original-fee-in-cents")
    var original_fee_in_cents = 0

    @SerializedName("sequence")
    var sequence = 0

    @SerializedName("operation-status")
    var operation_status: String? = null

    @SerializedName("by-created-at")
    var by_created_at: String? = null

    @SerializedName("suggested-label")
    var suggested_label: String? = null

    @SerializedName("hit-count")
    var hit_count: String? = null

    @SerializedName("place-id")
    var place_id: String? = null

    @SerializedName("coverage-status")
    var coverage_status: String? = null

    @SerializedName("coverage-message")
    var coverage_message: String? = null

    @SerializedName("special")
    var special = false

    @SerializedName("special-text-color")
    var special_text_color: String? = null

    @SerializedName("special-background-color")
    var special_background_color: String? = null

    @SerializedName("special-on-hover-background-color")
    var special_on_hover_background_color: String? = null

    @SerializedName("special-on-hover-text-color")
    var special_on_hover_text_color: String? = null

    @SerializedName("minimum-spend-in-cents")
    var minimum_spend_in_cents = 0

    @SerializedName("amount-remaining-in-cents")
    var amount_remaining_in_cents = 0

    @SerializedName("progress-in-percent")
    var progress_in_percent = 0.0

    @SerializedName("discount-in-cents")
    var discount_in_cents = 0

    @SerializedName("qualified")
    var qualified = false

    @SerializedName("shop-in-shop")
    var shop_in_shop = false

    @SerializedName("email-support")
    var email_support: Boolean? = null

    @SerializedName("pin-code")
    var pin_code: String? = null

    @SerializedName("deliverables-out-count")
    var deliverables_out_count: String? = null

    @SerializedName("deliverables-quantity-count")
    var deliverables_quantity_count = 0

    @SerializedName("optimise-sskey")
    var optimise_sskey: String? = null

    @SerializedName("optimise-aid")
    var optimise_aid: String? = null

    @SerializedName("optimise-uid")
    var optimise_uid: String? = null

    @SerializedName("optimise-uid2")
    var optimise_uid2: String? = null

    @SerializedName("chz-campaign-free-delivery")
    var chz_campaign_free_delivery: Boolean? = null

    @SerializedName("chz-campaign-available-count")
    var chz_campaign_available_count = 0

    @SerializedName("needs-finish-sign-up")
    var needs_finish_sign_up = false

    //Shop
    @SerializedName("checkout-time-slot-announcement")
    var checkout_time_slot_announcement: String? = null

    @SerializedName("checkout-time-slot-announcement-text-color")
    var checkout_time_slot_announcement_text_color: String? = null

    @SerializedName("checkout-time-slot-announcement-background-color")
    var checkout_time_slot_announcement_background_color: String? = null

    @SerializedName("checkout-time-slot-announcement-border-color")
    var checkout_time_slot_announcement_border_color: String? = null

    @SerializedName("main-text")
    var main_text: String? = null

    @SerializedName("secondary-text")
    var secondary_text: String? = null

    // Payment Card
    @SerializedName("card-holders-name")
    var card_holders_name: String? = null

    @SerializedName("first-digits")
    var first_digits: String? = null

    @SerializedName("funding-source")
    var funding_source: String? = null

    @SerializedName("stored-at")
    var stored_at: String? = null

    @SerializedName("last-used-at")
    var last_used_at: String? = null

    // Promo landing page
    @SerializedName("body")
    var body: String? = null

    @SerializedName("note-from-customer")
    var note_from_customer: String? = null

    // Contactless option
    @SerializedName("leave-at-doorstep")
    var leave_at_doorstep = false

    // Contactless option
    @SerializedName("cancellable-by-customer")
    var cancellable_by_customer = false

    // Replacements
    @SerializedName("replaced")
    var replaced = false

    // Grouped Deliverables
    @SerializedName("product_id")
    var product_id: String? = null

    @SerializedName("referee-email")
    var referee_email: String? = null

    @SerializedName("referee-signed-up-at")
    var referee_signed_up_at: String? = null

    @SerializedName("activated")
    var activated = false
    override fun toString(): String {
        return Gson().toJson(this)
    }
}