package com.example.tipcalculator

import androidx.compose.runtime.MutableDoubleState
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class jetTIpViewModel(): ViewModel() {
    private val _totalPerPerson = mutableDoubleStateOf(0.0)
    private val _totalAmount = mutableStateOf("")
    private val _splitNumber = mutableIntStateOf(1)
    private val _tip = mutableFloatStateOf(0.0f)
    private val _tipPercent = mutableFloatStateOf(0.0f)


    // exposing the variables //
    val totalPerPerson : MutableDoubleState = _totalPerPerson
    val totalAmount : MutableState<String> = _totalAmount
    val splitNumber : MutableIntState = _splitNumber
    val tip : MutableFloatState = _tip
    val tipPercent : MutableFloatState = _tipPercent


}