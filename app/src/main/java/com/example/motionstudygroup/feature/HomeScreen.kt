package com.example.motionstudygroup.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.motionstudygroup.BookDetail
import com.example.motionstudygroup.model.BookModel
import com.example.motionstudygroup.ui.theme.robotoFamily

data class NavigationItem(
    val title: String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
)

@Composable
fun HomeScreen(navController: NavController) {
    val screens = listOf(
        NavigationItem(
            "Home",
            Icons.Filled.Home,
            Icons.Outlined.Home
        ),
        NavigationItem(
            "Profile",
            Icons.Filled.Person,
            Icons.Outlined.Person
        ),
        NavigationItem(
            "Settings",
            Icons.Filled.Settings,
            Icons.Outlined.Settings
        ),
    )
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(

            ) {
                screens.forEachIndexed { index, s ->
                    NavigationBarItem(
                        icon = {
                            if (selectedItemIndex == index) Icon(
                                s.iconSelected,
                                contentDescription = null
                            ) else Icon(
                                s.iconUnselected,
                                contentDescription = null
                            )
                        },
                        label = { Text(s.title) },
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                        }
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(16.dp)
            ) {
                when (selectedItemIndex) {
                    0 -> HomeContent(navController = navController)
                    1 -> ProfileContent()
                    2 -> SettingsContent()
                }
            }
        }
    )
}

@Composable
fun HomeContent(navController: NavController) {
    // Dummy data
    val books = listOf(
        BookModel(
            "Harry Poter",
            "Description 1",
            ""
        ),
        BookModel(
            "LOTR",
            "Description 2",
            ""
        ),
        BookModel(
            "Title 3",
            "Description 3",
            ""
        ),
        BookModel(
            "Title 4",
            "Description 4",
            ""
        ),
        BookModel(
            "Title 5",
            "Description 5",
            ""
        ),
        BookModel(
            "Title 6",
            "Description 6",
            ""
        ),
        BookModel(
            "Title 7",
            "Description 7",
            ""
        ),
        BookModel(
            "Title 8",
            "Description 8",
            ""
        ),
        BookModel(
            "Title 9",
            "Description 9",
            ""
        ),
        BookModel(
            "Title 10",
            "Description 10",
            ""
        ),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn {
            items(books) { book ->
                BookItem(
                    book.title,
                    book.description,
                    book.imageUrl,
                    onClick = {
                        navController.navigate(
                            BookDetail(
                                bookTitle = book.title,
                                bookDesc = book.description
                            )
                        )
                    }
                )

            }
        }
    }
}

@Composable
fun BookItem(
    title: String,
    description: String,
    imageUrl: String,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .size(76.dp)
                    .background(color = Color.Gray)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    title,
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Text(
                    description,
                    fontFamily = robotoFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}