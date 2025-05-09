package com.example.simplevpn

import android.net.VpnService
import android.os.ParcelFileDescriptor
import java.io.FileInputStream
import java.io.FileOutputStream

class MyVpnService : VpnService() {
    private var vpnInterface: ParcelFileDescriptor? = null

    fun startVpn(serverAddress: String) {
        val builder = Builder()
        builder.addAddress("10.0.0.2", 24)  // آدرس داخلی VPN
        builder.addRoute("0.0.0.0", 0)  // مسیریابی تمام ترافیک
        builder.addDnsServer("8.8.8.8")  // تنظیم DNS

        vpnInterface = builder.establish()
    }

    fun stopVpn() {
        vpnInterface?.close()
        vpnInterface = null
        stopSelf()
    }
}
