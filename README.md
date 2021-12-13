# Jetpack-Compose-Samples

You can learn about jetpack compose with simple examples.

# Simple Text

		Text(
			text = "Text with Italic text",
			style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic)
		)


![image](https://user-images.githubusercontent.com/87621926/145778443-744fb4c3-ded7-406f-a5fb-907282b6fc18.png)

# Buttons

		@Composable
		fun ButtonWithIcon() {
			Button(onClick = {}) {
				Image(
		painterResource(id = R.drawable.ic_cart), 
		contentDescription ="Cart button icon",
		modifier = Modifier.size(20.dp))

				Text(text = "Add to cart",Modifier.padding(start = 10.dp))
			}
		}


![image](https://user-images.githubusercontent.com/87621926/145778536-376a0102-bd94-4f01-9dab-c4f076e2cd49.png)


# Image

		@Composable
		fun CircleImageView() {
			Image(
				painter = painterResource(R.drawable.andy_rubin),
				contentDescription = "Circle Image",
				contentScale = ContentScale.Crop,            
				modifier = Modifier
					.size(128.dp)
					.clip(CircleShape) // clip to the circle shape
					.border(5.dp, Color.Gray, CircleShape)//optional
			)
		}

![image](https://user-images.githubusercontent.com/87621926/145778885-e6359553-d553-4832-98f1-33b2a8bf0772.png)


# TextField

@Composable
		fun TextFieldWithIcons() {
			var text by remember { mutableStateOf(TextFieldValue("")) }
			return OutlinedTextField(
				value = text,
				leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
				//trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
				onValueChange = {
					text = it
				},
				label = { Text(text = "Email address") },
				placeholder = { Text(text = "Enter your e-mail") },
			)
		}

![image](https://user-images.githubusercontent.com/87621926/145778990-fca240ce-ecc3-4986-8a55-bd855fc70b0a.png)

# Bottom Menu

		@Composable
		fun ScaffoldWithBottomMenu() {
			Scaffold(bottomBar = {BottomBar()}
			) {
			  //content area
			  Box(modifier = Modifier
			  .background(Color(0xff546e7a))
			  .fillMaxSize())
			}
		}

![image](https://user-images.githubusercontent.com/87621926/145779111-148d5b51-9bb2-4638-bf2f-3d6110672947.png)


# Animation

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
		
		![image](https://user-images.githubusercontent.com/87621926/145779269-2a716b1d-6188-490f-a6fd-5ccc5d8dc9f6.png)




