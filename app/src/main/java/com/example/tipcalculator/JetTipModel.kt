package com.example.tipcalculator

import java.time.temporal.TemporalAmount

data class JetTipModel(
    var totalPerPerson:Double,
    var totalAmount: String,
    var splitNumber: Int,
    var tip:Float,
    var tipPercent:Float
)


class JetTipRepository(){
    private var jetTip = JetTipModel(0.0 , "" , 1 , 0.0f , 0.0f)

    fun initData():JetTipModel{
        return jetTip
    }

}