package com.example.tipcalculator

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.PlusOne
import androidx.compose.material.icons.rounded.RemoveCircle
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon as Icon

@Composable
fun JetTipUI(){
    val totalPerPerson = remember {
        mutableDoubleStateOf(0.0)
    }
    val totalAmount = remember {
        mutableStateOf("")
    }
    val splitNumber = remember {
        mutableIntStateOf(1)
    }
    val tip = remember{
        mutableFloatStateOf(0.0f)
    }
    // A surface helps in automatically change the theme rather than box //
    Column(modifier = Modifier.padding(12.dp)){


        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
            color = MaterialTheme.colorScheme.primary
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "Total per Person", style = MaterialTheme.typography.headlineMedium)
                Text(
                    text = "$ "+String.format("%.2f", totalPerPerson.doubleValue),

                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))
        Surface(modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            border = BorderStroke(width = 1.dp , color = Color.LightGray),
            shadowElevation = 4.dp
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.padding(12.dp)) {


                OutlinedTextField(
                    value = totalAmount.value,
                    onValueChange = {
                        // This is important for checking //
                        val newText = it.filter { char -> char.isDigit() || char == '.' }
                        // Check if the new text is a valid decimal number
                        if (newText.matches(Regex("^\\d*(\\.\\d*)?$"))) {
                            totalAmount.value = newText
                        }
                    },
                    singleLine = true,
                    // this is the code to restrict the user to type int
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.AttachMoney,
                            contentDescription = "Input Icon"
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(fontSize = 18.sp),
                    label = { Text(text = "Enter Value")},

                )

                Row(horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = "Split")

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        IconButton(
                            onClick = { splitNumber.intValue++ },
                        ) {
                            Icon(imageVector = Icons.Rounded.AddCircle, contentDescription = "")
                        }


                        Text(text = splitNumber.intValue.toString())

                        IconButton(
                            onClick = {
                                if(splitNumber.intValue > 1){
                                    splitNumber.intValue--

                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Rounded.RemoveCircle, contentDescription = "")
                        }

                    }

                }

                Row(horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Tip")
                    Text(text = "$"+String.format("%.2f", tip.floatValue) , modifier = Modifier.padding(end = 41.dp))
                }

                // just the needed value //

                val tipPercent = remember {
                    mutableFloatStateOf(0.0f)
                }
                Text(text = String.format("%.2f", tipPercent.floatValue * 100) + " %")
                val context = LocalContext.current
                Slider(value = tipPercent.floatValue, onValueChange ={

                    tipPercent.floatValue = it
                },
                    steps = 5,
                    onValueChangeFinished = {
                        if(totalAmount.value.isNotEmpty()){
                            val totalTip = (totalAmount.value.toDouble()) * (tipPercent.floatValue.toDouble())
                            val totalMoney = totalTip+totalAmount.value.toDouble()
                            totalPerPerson.doubleValue = totalMoney/splitNumber.intValue
                        }
                        else{
                            Toast.makeText(context , "Enter the Amount First" , Toast.LENGTH_LONG).show()
                        }
                    }
                    )
            }
        }


    }


}


@Preview
@Composable
fun JetTipUIPreview(){
    JetTipUI()
}




