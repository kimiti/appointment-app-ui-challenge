package com.example.appointmentappuichallenge.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.appointmentappuichallenge.R
import com.example.appointmentappuichallenge.model.DoctorModel
import com.example.appointmentappuichallenge.viewModel.MainViewModel


@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onDoctorClick: (DoctorModel) -> Unit = {}
) {
    MainScreenContent(
        doctor = viewModel.loadDoctors()
    )
}


@Composable
fun MainScreenContent(
    doctor: List<DoctorModel> = emptyList(),
    onDoctorClick: (DoctorModel) -> Unit = {}
) {
    var searchText by remember { mutableStateOf("") }
    var selectedBottomItem by remember { mutableStateOf(0) }


    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.shadow(elevation = 5.dp),
                containerColor = colorResource(R.color.lightGrey),
                tonalElevation = 5.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    BottomMenuItem(
                        iconId = R.drawable.bottom_btn1,
                        title = "Home",
                        isSelected = selectedBottomItem == 0,
                        onClick = { selectedBottomItem = 0 }
                    )
                    BottomMenuItem(
                        iconId = R.drawable.bottom_btn2,
                        title = "explorer",
                        isSelected = selectedBottomItem == 1,
                        onClick = { selectedBottomItem = 2 }
                    )
                    BottomMenuItem(
                        iconId = R.drawable.bottom_btn3,
                        title = "Bookmark",
                        isSelected = selectedBottomItem == 3,
                        onClick = { selectedBottomItem = 3 }
                    )
                    BottomMenuItem(
                        iconId = R.drawable.bottom_btn4,
                        title = "Profile",
                        isSelected = selectedBottomItem == 4,
                        onClick = { selectedBottomItem = 4 }
                    )
                }

            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(36.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Hi, John Doe",
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "What do you feel!",
                            color = Color.Black,
                            fontSize = 27.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.bell_icon),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    placeholder = {
                        Text(
                            text = "Health issue or Text",
                            color = Color.Gray,
                            fontStyle = FontStyle.Italic
                        )
                    },
                    trailingIcon = {
                        Image(
                            painter = painterResource(R.drawable.search_icon),
                            contentDescription = null
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = colorResource(R.color.lightGrey),
                        unfocusedContainerColor = colorResource(R.color.lightGrey)

                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.banner),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "NearBy Doctor",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}


@Composable
fun BottomMenuItem(
    iconId: Int,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor = if (isSelected) colorResource(R.color.lightGreen) else Color.Transparent
    val content = if (isSelected) colorResource(R.color.green) else Color.Gray


    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(20))
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = content
        )
        AnimatedVisibility(visible = isSelected) {
            Row() {
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = title,
                    color = content,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }

}


@Composable
fun DoctorItem(doctor: DoctorModel, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(doctor.Picture),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = colorResource(R.color.gray)),
                contentScale = ContentScale.Crop
            )
//            AsyncImage(
//                model = doctor.Picture,
//                contentDescription = null,
//                modifier = Modifier
//                    .size(80.dp)
//                    .clip(RoundedCornerShape(50.dp))
//                    .background(color = colorResource(R.color.gray)),
//                contentScale = ContentScale.Crop
//            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = doctor.Name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = doctor.Special,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Text(
                text = doctor.Cost,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.green),
                modifier = Modifier
                    .background(
                        color = colorResource(R.color.lightGreen),
                        shape = RoundedCornerShape(50.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}


@Composable
fun DoctorItemPreview() {
    val sampleDoctor = DoctorModel(
        Id = 1,
        Name = "Dr Jane Doe",
        Special = "Cardiologist",
        Picture = R.drawable.dr_david_johnson,
        Address = "123 Main St",
        Biography = "Sample Biography",
        Cost = "$50",
        Location = "Sample Location",
        Mobile = "1234567890",
        Patients = "100+",
        Rating = "4.5",
        Site = "www.sample.com"

    )
    DoctorItem(doctor = sampleDoctor)
}


@Preview
@Composable
fun MainScreenContentPreview() {
    MainScreenContent()
}