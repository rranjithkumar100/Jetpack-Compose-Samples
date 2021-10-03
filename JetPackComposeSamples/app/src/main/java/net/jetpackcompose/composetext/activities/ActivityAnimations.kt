package net.jetpackcompose.composetext.activities

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jetpackcompose.composetext.R

class AnimationSamplesActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AnimationRootView()
        }
    }

    enum class SelectedAnimation {
        AnimationHomePage,
        ShowAnimateDpAsState,
        ColorAsStateAnimation,
        Animatable,
        AnimateAsFloat,
        ScaleAnimation,
        TransitionAnimation,
        EnterExitAnimation,
        CrossFadeAnimation,
        InfiniteAnimation,

    }

    @ExperimentalAnimationApi
    @Composable
    private fun AnimationRootView() {

        var selectedPage by remember { mutableStateOf(SelectedAnimation.AnimationHomePage) }
        val context = LocalContext.current
        BackHandler() {
            if (selectedPage == SelectedAnimation.AnimationHomePage)
                (context as Activity).finish()
            else
                selectedPage = SelectedAnimation.AnimationHomePage
        }
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = selectedPage.name) }, navigationIcon = {
                IconButton(onClick = {
                    //back press
                    if (selectedPage == SelectedAnimation.AnimationHomePage)
                        (context as Activity).finish()
                    else
                        selectedPage = SelectedAnimation.AnimationHomePage

                }) {
                    Icon(Icons.Filled.ArrowBack, "backIcon")
                }
            })
        }) {

            //main content list of buttons
            if (selectedPage == SelectedAnimation.AnimationHomePage) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomButton(label = "Animatable") {
                        selectedPage = SelectedAnimation.Animatable
                    }


                    CustomButton(label = "animateDpAsState") {
                        selectedPage = SelectedAnimation.ShowAnimateDpAsState
                    }

                    CustomButton(label = "ColorAsState") {
                        selectedPage = SelectedAnimation.ColorAsStateAnimation
                    }

                    CustomButton(label = "animateFloatAsState (Rotate)") {
                        selectedPage = SelectedAnimation.AnimateAsFloat
                    }

                    CustomButton(label = "Transition Animation") {
                        selectedPage = SelectedAnimation.TransitionAnimation
                    }

                    CustomButton(label = "Scale Animation") {
                        selectedPage = SelectedAnimation.ScaleAnimation
                    }

                    CustomButton(label = "Infinite Animation") {
                        selectedPage = SelectedAnimation.InfiniteAnimation
                    }

                    CustomButton(label = "Enter Exit Animation") {
                        selectedPage = SelectedAnimation.EnterExitAnimation
                    }

                    CustomButton(label = "CrossFade Animation") {
                        selectedPage = SelectedAnimation.CrossFadeAnimation
                    }

                }
            }

            //sub content -> show selected
            else {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    when (selectedPage) {
                        SelectedAnimation.Animatable -> {
                            AnimatableSample()
                        }

                        SelectedAnimation.ShowAnimateDpAsState -> {
                            AnimateDpAsState()
                        }
                        SelectedAnimation.ColorAsStateAnimation -> {
                            AnimateColorAsState()
                        }

                        SelectedAnimation.AnimateAsFloat -> {
                            AnimateAsFloatContent()
                        }
                        SelectedAnimation.TransitionAnimation -> {
                            TransitionAnimation()
                        }

                        SelectedAnimation.InfiniteAnimation -> {
                            InfiniteAnimation()
                        }

                        SelectedAnimation.CrossFadeAnimation -> {
                            CrossFadeAnimation()
                        }

                        SelectedAnimation.ScaleAnimation -> {
                            ButtonScaleAnimation()//Experimental Api
                        }
                        SelectedAnimation.EnterExitAnimation -> {
                            AnimatedVisibilityEnterAndExit()//Experimental Api
                        }
                        else -> AnimateDpAsState()
                    }

                }
            }
        }
    }

    @Composable
    private fun CustomButton(label: String, onClick: () -> Unit) {
        Button(
            onClick = onClick, modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(0.8f)
        ) {
            Text(text = label)
        }
    }

    @Composable
    private fun AnimateDpAsState() {
        val isNeedExpansion = rememberSaveable { mutableStateOf(false) }
        val animatedHeightDp: Dp by animateDpAsState(targetValue = if (isNeedExpansion.value) 350.dp else 100.dp)
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircleImage(animatedHeightDp)
            Button(
                onClick = { isNeedExpansion.value = !isNeedExpansion.value },
                modifier = Modifier
                    .padding(top = 50.dp)
                    .width(300.dp)
            ) {
                Text(text = "animateDpAsState")
            }
        }
    }


    @Composable
    private fun AnimateColorAsState() {
        var isNeedColorChange by remember { mutableStateOf(false) }
        val startColor = Color.Blue
        val endColor = Color.Green
        val backgroundColor by animateColorAsState(
            if (isNeedColorChange) endColor else startColor,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 100,
                easing = LinearEasing
            )
        )
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .background(backgroundColor)
            )
            Button(
                onClick = { isNeedColorChange = !isNeedColorChange },
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(text = "Switch Color")
            }
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun ButtonScaleAnimation() {
        val selected = remember { mutableStateOf(false) }
        val scale = animateFloatAsState(if (selected.value) 2f else 1f)

        Column(
            Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .scale(scale.value)
                    .height(40.dp)
                    .width(200.dp)
                    .pointerInteropFilter {
                        when (it.action) {
                            MotionEvent.ACTION_DOWN -> {
                                selected.value = true
                            }

                            MotionEvent.ACTION_UP -> {
                                selected.value = false
                            }
                        }
                        true
                    }
            ) {
                Text(text = "Scale Animation", fontSize = 15.sp, color = Color.White)
            }
        }
    }

    @Composable
    private fun AnimatableSample() {
        var isAnimated by remember { mutableStateOf(false) }

        // Start with gray color and animate to green/red based on `button click`
        val color = remember { Animatable(Color.DarkGray) }
        LaunchedEffect(isAnimated) {
            color.animateTo(if (isAnimated) Color.Green else Color.Red, animationSpec = tween(2000))
        }

        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(color.value)
        )
        Button(
            onClick = { isAnimated = !isAnimated },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Animate Color")
        }
    }

    @Composable
    private fun TransitionAnimation() {
        var isAnimated by remember { mutableStateOf(false) }
        val transition = updateTransition(targetState = isAnimated, label = "transition")

        val rocketOffset by transition.animateOffset(transitionSpec = {
            if (this.targetState) {
                tween(1000) // launch duration

            } else {
               tween(1500) // land duration
            }
        }, label = "rocket offset") { animated ->
            if (animated) Offset(200f, 0f) else Offset(200f, 500f)
        }

        val rocketSize by transition.animateDp(transitionSpec = {
            tween(1000)
        }, "") { animated ->
            if (animated) 75.dp else 150.dp
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.rocket),
                contentDescription = "Rocket",
                modifier = Modifier
                    .size(rocketSize)
                    .alpha(1.0f)
                    .offset(rocketOffset.x.dp, rocketOffset.y.dp)
            )
            Button(
                onClick = { isAnimated = !isAnimated },
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(text = if (isAnimated) "Land rocket" else "Launch rocket")
            }
        }
    }
}

@Composable
private fun AnimateAsFloatContent() {
    var isRotated by rememberSaveable { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated) 360F else 0f,
        animationSpec = tween(durationMillis = 2500)
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.fan),
            contentDescription = "fan",
            modifier = Modifier
                .rotate(rotationAngle)
                .size(150.dp)
        )

        Button(
            onClick = { isRotated = !isRotated },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(200.dp)
        ) {
            Text(text = "Rotate Fan")
        }
    }
}


@ExperimentalAnimationApi
@Composable
private fun AnimatedVisibilityEnterAndExit() {
    var isVisible by rememberSaveable { mutableStateOf(false) }
    Column {
        AnimatedVisibility(
            visible = isVisible,
            enter = expandIn(animationSpec = tween(2000)),
            exit = shrinkVertically(
                animationSpec = tween(
                    durationMillis = 1000,
                )
            )
        ) {
            CircleImage(300.dp)
        }
        Button(
            onClick = { isVisible = !isVisible },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp)
        ) {
            if (isVisible) {
                Text(text = "AnimatedVisibility \n(Press for Exit Animation)")
            } else {
                Text(text = "AnimatedVisibility \n(Press for Enter Animation)")

            }
        }

    }
}




@Composable
private fun CrossFadeAnimation() {
    var currentPage by remember { mutableStateOf("A") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Crossfade(targetState = currentPage, animationSpec = tween(3000)) { screen ->
            when (screen) {
                "A" -> Text(
                    "Page A", modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f)
                        .background(Color.Red)
                )
                "B" -> Text(
                    "Page B", modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f)
                        .background(Color.Green)
                )
            }
        }
        Button(
            onClick = {
                if (currentPage.equals("A")) {
                    currentPage = "B"
                } else {
                    currentPage = "A"

                }
            },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp)
        ) {
            Text(text = "Cross fade Animation")
        }

    }
}

@Composable
fun InfiniteAnimation() {
    val infiniteTransition = rememberInfiniteTransition()

    val heartSize by infiniteTransition.animateFloat(
        initialValue = 100.0f,
        targetValue = 250.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, delayMillis = 100,easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Image(
        painter = painterResource(R.drawable.heart),

        contentDescription = "heart",
        modifier = Modifier
            .size(heartSize.dp)
    )
}

@Composable
fun CircleImage(imageHeight: Dp) {
    Image(
        painter = painterResource(R.drawable.andy_rubin),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .size(imageHeight)
            .clip(CircleShape)                       // clip to the circle shape
            .border(5.dp, Color.Gray, CircleShape)   // add a border (optional)
    )
}
