package com.reactivestudio.navigationcontroller.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SampleData(val id: Int, val title: String, val body: String): Parcelable