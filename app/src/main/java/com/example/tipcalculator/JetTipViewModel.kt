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

class JetTipViewModel(): ViewModel() {
    private val _repository : JetTipRepository = JetTipRepository()
    private val _initialisedData = _repository.initData()

    private val _totalPerPerson = mutableDoubleStateOf(_initialisedData.totalPerPerson)
    private val _totalAmount = mutableStateOf(_initialisedData.totalAmount)
    private val _splitNumber = mutableIntStateOf(_initialisedData.splitNumber)
    private val _tip = mutableFloatStateOf(_initialisedData.tip)
    private val _tipPercent = mutableFloatStateOf(_initialisedData.tipPercent)


    // exposing the variables //
    val totalPerPerson : MutableDoubleState = _totalPerPerson
    val totalAmount : MutableState<String> = _totalAmount
    val splitNumber : MutableIntState = _splitNumber
    val tip : MutableFloatState = _tip
    val tipPercent : MutableFloatState = _tipPercent


}