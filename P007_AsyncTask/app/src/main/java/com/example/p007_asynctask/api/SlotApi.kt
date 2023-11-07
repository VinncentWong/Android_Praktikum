package com.example.p007_asynctask.api

import com.example.p007_asynctask.model.SlotImage
import retrofit2.http.GET

interface SlotApi {
    @GET("/v1/821f1b13-fa9a-43aa-ba9a-9e328df8270e")
    suspend fun listSlotImage(): List<SlotImage>
}