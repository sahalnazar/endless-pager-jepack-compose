package com.sahalnazar.endlesspagerjetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sahalnazar.endlesspagerjetpackcompose.ui.theme.EndlesspagerjepackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EndlesspagerjepackcomposeTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    EndlessHorizontalPager(
                        items = listOf("A", "B", "C"),
                        itemClicked = {
                            Toast.makeText(
                                this@MainActivity,
                                "item clicked: $it",
                                Toast.LENGTH_LONG
                            ).show()
                        })
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EndlessHorizontalPager(
    items: List<String>,
    itemClicked: (String) -> Unit
) {
    val pageCount = Int.MAX_VALUE
    val pagerState = rememberPagerState(
        initialPage = pageCount / 2
    )

    HorizontalPager(
        modifier = Modifier
            .background(Color(0xff469597))
            .size(200.dp)
            .clickable {
                val clickedItem = items[pagerState.settledPage % items.size]
                itemClicked(clickedItem)
            },
        pageCount = pageCount,
        state = pagerState
    ) { page ->
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = items[page % items.size],
                style = MaterialTheme.typography.h1
            )
        }
    }
}