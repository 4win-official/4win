package com.example.simplevpn

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var vpnService: MyVpnService
    private lateinit var statusText: TextView
    private lateinit var connectButton: Button
    private lateinit var disconnectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vpnService = MyVpnService()
        statusText = findViewById(R.id.statusText)
        connectButton = findViewById(R.id.connectButton)
        disconnectButton = findViewById(R.id.disconnectButton)

        connectButton.setOnClickListener { connectVpn() }
        disconnectButton.setOnClickListener { disconnectVpn() }
    }

    private fun connectVpn() {
        GlobalScope.launch(Dispatchers.IO) {
            val configJson = URL("https://your-config-link.com/config.json").readText()
            val bestServer = selectBestServer(configJson)
            vpnService.startVpn(bestServer)
            runOnUiThread { statusText.text = "متصل شد ✅" }
        }
    }

    private fun disconnectVpn() {
        vpnService.stopVpn()
        statusText.text = "قطع شد ❌"
    }

    private fun selectBestServer(configJson: String): String {
        return "vpn.example.com"
    }
}
