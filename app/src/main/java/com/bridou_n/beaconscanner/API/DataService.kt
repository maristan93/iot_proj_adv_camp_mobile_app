package com.bridou_n.beaconscanner.API

import com.bridou_n.beaconscanner.models.CouponResponse
import com.bridou_n.beaconscanner.models.ResultResponse
import com.bridou_n.beaconscanner.models.SurveyRequest
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.*

interface DataService {

    @GET("result")
    fun getResult(@Query("Drink") drinkState: String? = null,
                  @Query("Bakery") bakeryState: String? = null,
                  @Query("Candy") candyState: String? = null): Observable<List<ResultResponse>>

    @GET("coupon/{id}")
    fun getCoupon(@Path("id") id: Int): Observable<List<CouponResponse>>

    @GET("coupon_list")
    fun getCouponList(): Observable<List<CouponResponse>>

    @POST("survey/")
    fun sendSurveyResults(@Body request: SurveyRequest): Completable
}