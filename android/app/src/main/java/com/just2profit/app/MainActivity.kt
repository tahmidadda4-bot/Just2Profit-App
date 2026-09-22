package com.just2profit.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { Just2ProfitApp() }
    }
}

@Composable
fun Just2ProfitApp() {
    MaterialTheme {
        var tab by remember { mutableIntStateOf(0) }
        val names = listOf("Home", "Tasks", "Wallet", "Referral")
        Scaffold(
            bottomBar = {
                NavigationBar {
                    names.forEachIndexed { i, name ->
                        NavigationBarItem(
                            selected = tab == i,
                            onClick = { tab = i },
                            icon = { Text(name.take(1)) },
                            label = { Text(name) }
                        )
                    }
                }
            }
        ) { p ->
            Column(
                modifier = Modifier.fillMaxSize().padding(p).padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text("Just2Profit", style = MaterialTheme.typography.headlineMedium)
                when (tab) {
                    0 -> {
                        Text("Welcome! Complete genuine tasks to earn rewards.")
                        Text("Balance: ৳0.00", style = MaterialTheme.typography.headlineSmall)
                    }
                    1 -> {
                        Text("Daily Tasks", style = MaterialTheme.typography.headlineSmall)
                        Button(onClick = {}) { Text("Start Task") }
                    }
                    2 -> {
                        Text("Wallet", style = MaterialTheme.typography.headlineSmall)
                        Text("Balance: ৳0.00")
                        Button(onClick = {}) { Text("Request Withdrawal") }
                    }
                    3 -> {
                        Text("Referral", style = MaterialTheme.typography.headlineSmall)
                        Text("Referral Code: J2P-DEMO")
                    }
                }
            }
        }
    }
}
