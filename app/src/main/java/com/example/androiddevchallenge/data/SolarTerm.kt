package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes

data class SolarTerm(
    var index: Int,         //索引
    @DrawableRes var termRes: Int,
    @DrawableRes var detailsRes: Int,
    var title: String,      //节气名称
    var titleOfEn: String,  //英文名称
    var content: String,    //描述内容
    var time: String,        //节气时间
)