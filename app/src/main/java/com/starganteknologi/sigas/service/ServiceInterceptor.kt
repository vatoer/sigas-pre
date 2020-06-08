package com.starganteknologi.sigas.service

import okhttp3.*
import okio.IOException

class ServiceInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token =  "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImN0eSI6IkpXVCJ9.eyJpYXQiOjE1OTE0NDYyMjAsInJvbGVzIjpbIlJPTEVfUkVRVUVTVEVSIiwiUk9MRV9VU0VSIl0sInVzZXJuYW1lIjoicmVxdWVzdGVyIiwiZXhwIjoxNTkxNDk1MjAwLCJpcCI6IjE4MC4yNDMuMjMwLjI1MyIsInVzZXIiOnsiaWQiOjQsImVtYWlsIjoicmVxdWVzdGVyQHN0YXJnYW50ZWtub2xvZ2kuY29tIiwiZmNtX3Rva2VuIjoidGVzdGxhZ2kifX0.b5UtPU8Fw25Fy4puQoHdAwlSM6FA98j2fScj3-w722sKtxA8akvG6Kz4AFogbU3kul7YDVrkl4PKbYjNMAo9Wg_JJNaqr7tY9uE1vy97rKMedAqyiWjEloyeCqNymXdfTFuflLNiIXKaPxZAFHQq7lFprPGcuojM1rU0BQK4o122-BOGeYMWVYAv9leTcYNDL7vW5dZdXLvdACtmtL_Sfys3ARTqsx5G7GCjC6ilnzyIiir8t-BnZ99ELZk5D-M9g90eeV1kaOGDRF1mDZUzDkOqGCbWMNiYnpzXyqtPjA07IcPIrMK-nd9lVKfiBv5JGaB3ttrLU5OmH6rB_xiIpEZfvlM-PdWCBnR5DpHOhRL-Hceb58svVGfTlB_VqnrwQacSDEUsiuXwCUON4EDxXrGwI5M1OCpDF-wpUQ2LqvNVJ603vjC5M095VNKwdBlGVGpVPaUvCzhah19iTRjxgwNhjC3G3jrjLgfHBmspKbBuJCu5LB1SMrN5UeOy61Vxedp14ePV5Oy0hNdYITbAP7qbGmxrhvPAKbv4TC2tkX-Io7Pm5BOXZJYwsddEYS2BGKYzHg_j0YjRlim_gewABGw7_8p1p5KGA3KILBo21HkhZlj-uBop6oGisaAe2ujqbaUGoFeObkVTamlZO3y3YJlX_ooCTX34_GnOjpv8Pro"
        var request = chain.request()
        request = request.newBuilder()
            //?.addHeader("Accept","application/json")
            .addHeader("Authorization", "Bearer $token")
            .build()
        return chain.proceed(request)
    }
}