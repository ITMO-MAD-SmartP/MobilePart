package com.plcoding.meditationuiyoutube.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.meditationuiyoutube.BottomMenuContent
import com.plcoding.meditationuiyoutube.Feature
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.standardQuadFromTo
import com.plcoding.meditationuiyoutube.ui.theme.*

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Living Room",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "BedRoom",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Kitchen",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Bathroom",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Studio",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Washing Room",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
    }
}

//@Composable
//fun BottomMenu(
//    items: List<BottomMenuContent>,
//    modifier: Modifier = Modifier,
//    activeHighlightColor: Color = ButtonBlue,
//    activeTextColor: Color = Color.White,
//    inactiveTextColor: Color = AquaBlue,
//    initialSelectedItemIndex: Int = 0
//) {
//    var selectedItemIndex by remember {
//        mutableStateOf(initialSelectedItemIndex)
//    }
//    Row(
//        horizontalArrangement = Arrangement.SpaceAround,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = modifier
//            .fillMaxWidth()
//            .background(DeepBlue)
//            .padding(15.dp)
//    ) {
//        items.forEachIndexed { index, item ->
//            BottomMenuItem(
//                item = item,
//                isSelected = index == selectedItemIndex,
//                activeHighlightColor = activeHighlightColor,
//                activeTextColor = activeTextColor,
//                inactiveTextColor = inactiveTextColor
//            ) {
//                selectedItemIndex = index
//            }
//        }
//    }
//}

//@Composable
//fun BottomMenuItem(
//    item: BottomMenuContent,
//    isSelected: Boolean = false,
//    activeHighlightColor: Color = ButtonBlue,
//    activeTextColor: Color = Color.White,
//    inactiveTextColor: Color = AquaBlue,
//    onItemClick: () -> Unit
//) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier.clickable {
//            onItemClick()
//        }
//    ) {
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .clip(RoundedCornerShape(10.dp))
//                .background(if (isSelected) activeHighlightColor else Color.Transparent)
//                .padding(10.dp)
//        ) {
//            Icon(
//                painter = painterResource(id = item.iconId),
//                contentDescription = item.title,
//                tint = if (isSelected) activeTextColor else inactiveTextColor,
//                modifier = Modifier.size(20.dp)
//            )
//        }
//        Text(
//            text = item.title,
//            color = if(isSelected) activeTextColor else inactiveTextColor
//        )
//    }
//}




@ExperimentalFoundationApi
@Composable
fun FeatureSection(features: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Rooms",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp),
            color = AquaBlue
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
        }
    }
}