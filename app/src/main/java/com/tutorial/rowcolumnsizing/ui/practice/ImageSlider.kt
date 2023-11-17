package com.tutorial.rowcolumnsizing.ui.practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.tutorial.rowcolumnsizing.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlide(){
    val pagerState = rememberPagerState(initialPage = 0)
    val banner = listOf(
        painterResource(id = R.drawable.img_banner1),
        painterResource(id = R.drawable.img_banner2),
        painterResource(id = R.drawable.img_banner3)
    )

    LaunchedEffect(Unit) {
        while(true) {
            yield()
            delay(2600)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = banner.size,
            state = pagerState,
            modifier = Modifier
                .height(114.dp)
                .fillMaxWidth()
        ) { page ->
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = banner[page],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
    }

    /*
        LaunchedEffect(Unit): LaunchedEffect adalah fungsi yang digunakan untuk memulai efek samping atau tindakan sampingan (side effect) pada komponen Compose.
                              Parameter yang diterima (dalam hal ini Unit) digunakan sebagai tanda bahwa efek samping yang dinyatakan dalam blok lambda akan dijalankan hanya sekali ketika komponen pertama kali di-mount. Ini sering digunakan untuk memulai sesuatu seperti pengamatan data atau tindakan sampingan lainnya yang berkaitan dengan siklus hidup komponen.
        while(true): Ini adalah loop tak terbatas yang berarti efek samping akan berjalan terus-menerus.
        yield(): Fungsi ini memberi tahu runtime untuk memberi kesempatan kepada tugas-tugas lain yang mungkin berjalan dalam konteks yang sama untuk dijalankan.
                Ini membantu mencegah blok while-loop ini memblokir utas utama (main thread) dan memungkinkan UI untuk tetap responsif.
        delay(2600): Fungsi ini memberi jeda selama 2600 milidetik (2,6 detik). Ini akan membuat efek samping ini "tidur" selama periode waktu ini sebelum melanjutkan ke baris selanjutnya.
        pagerState.animateScrollToPage(...): Ini adalah bagian yang sebenarnya dari efek samping.
                    Ini menggunakan pagerState (kemungkinan besar objek yang mewakili keadaan dari komponen pager) untuk menganimasikan pergeseran halaman. Dalam hal ini, dia mencoba untuk menggulir ke halaman berikutnya dengan menggunakan rumus (pagerState.currentPage + 1) % (pagerState.pageCount).
                    Ini juga mungkin digunakan untuk membuat efek animasi otomatis seperti pergeseran halaman dalam sebuah tampilan pager/slider setiap 2,6 detik.
     */
}