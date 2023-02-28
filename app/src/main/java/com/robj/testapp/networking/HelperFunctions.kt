package com.robj.testapp.networking

import java.security.MessageDigest
import java.util.Locale

object  HelperFunctions {
    private fun byteArrayToString(bytes: ByteArray): String? {
        val buffer = StringBuilder()
        for (b in bytes) {
            buffer.append(java.lang.String.format(Locale.getDefault(), "%02x", b))
        }
        return buffer.toString()
    }

    fun SHA1(clearString: String): String? {
        return try {
            val messageDigest: MessageDigest = MessageDigest.getInstance("SHA-1")
            messageDigest.update(clearString.toByteArray(charset("UTF-8")))
            byteArrayToString(messageDigest.digest())
        } catch (ignored: Exception) {
            ignored.printStackTrace()
            null
        }
    }
}