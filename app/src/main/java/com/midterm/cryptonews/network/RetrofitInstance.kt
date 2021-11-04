package com.midterm.cryptonews.network

import com.midterm.cryptonews.network.Constants.Companion.SIMPLE_COIN_PRICE
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient by lazy {
        val builder = OkHttpClient().newBuilder()
        builder.addInterceptor(loggingInterceptor)
        builder.build()
    }

    val apiClient : RetroApi by lazy {
        Retrofit.Builder()
            .baseUrl(SIMPLE_COIN_PRICE)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(
                Moshi.Builder()
                    //.add(ArrayListAdapter.FACTORY)
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
            ))
            .build().create(RetroApi::class.java)
    }
    /*
    // MESS OF CONVERTERS, FIX WAS CHANGE ArrayList TO Array IN RetroApi

    //    abstract class ArrayListAdapter<C : MutableCollection<T>?, T> private constructor(
    //        private val elementAdapter: JsonAdapter<T>
    //    ) :
    //        JsonAdapter<C>() {
    //        abstract fun newCollection(): C
    //
    //        @Throws(IOException::class)
    //        override fun fromJson(reader: JsonReader): C {
    //            val result = newCollection()
    //            reader.beginArray()
    //            while (reader.hasNext()) {
    //                result?.add(elementAdapter.fromJson(reader)!!)
    //            }
    //            reader.endArray()
    //            return result
    //        }
    //
    //        @Throws(IOException::class)
    //        override fun toJson(writer: JsonWriter, value: C?) {
    //            writer.beginArray()
    //            for (element in value!!) {
    //                elementAdapter.toJson(writer, element)
    //            }
    //            writer.endArray()
    //        }
    //
    //        override fun toString(): String {
    //            return "$elementAdapter.collection()"
    //        }
    //
    //        companion object {
    //            val FACTORY = Factory { type, annotations, moshi ->
    //                val rawType = Types.getRawType(type)
    //                if (annotations.isNotEmpty()) return@Factory null
    //                if (rawType == ArrayList::class.java) {
    //                    return@Factory newArrayListAdapter<Any>(
    //                        type,
    //                        moshi
    //                    ).nullSafe()
    //                }
    //                null
    //            }
    //
    //            private fun <T> newArrayListAdapter(
    //                type: Type,
    //                moshi: Moshi
    //            ): JsonAdapter<MutableCollection<T>> {
    //                val elementType =
    //                    Types.collectionElementType(
    //                        type,
    //                        MutableCollection::class.java
    //                    )
    //
    //                val elementAdapter: JsonAdapter<T> = moshi.adapter(elementType)
    //
    //                return object :
    //                    ArrayListAdapter<MutableCollection<T>, T>(elementAdapter) {
    //                    override fun newCollection(): MutableCollection<T> {
    //                        return ArrayList()
    //                    }
    //                }
    //            }
    //        }
    //    }


        // MOSHI CONVERTER FOR ARRAY LIST
    //    class ArrayListAdapter(): JsonAdapter<ArrayList<MoshiMarketModel>>() {
    //        @ToJson
    //        fun arrayListToJson(list: ArrayList<GsonMarketModel.GsonModelForCoinsItem>) : List<GsonMarketModel.GsonModelForCoinsItem> = list
    //
    //        @FromJson
    //        fun arrayListFromJson(list: List<GsonMarketModel.GsonModelForCoinsItem>) : ArrayList<GsonMarketModel.GsonModelForCoinsItem> = ArrayList(list)
    //    }
        // GSON CONVERTER CLIENT
    //    val apiClient : RetroApi by lazy {
    //        Retrofit.Builder()
    //            .baseUrl(SIMPLE_COIN_PRICE)
    //            .client(okHttpClient)
    //            .addConverterFactory(GsonConverterFactory.create())
    //            .build()
    //            .create(RetroApi::class.java)
    //    }
    */
}