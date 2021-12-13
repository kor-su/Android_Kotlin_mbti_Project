package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class TestWebview : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var mProgressBar: ProgressBar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.testwebview)

        webView = findViewById(R.id.Test_webView)
        mProgressBar = findViewById(R.id.Test_progessBar)

        webView.apply {
            webViewClient = WebViewClientClass()


            webChromeClient = object : WebChromeClient() {
                override fun onCreateWindow(
                    view: WebView?,
                    isDialog: Boolean,
                    isUserGesture: Boolean,
                    resultMsg: Message?
                ): Boolean {
                    val newWebView = WebView(this@TestWebview).apply {
                        webViewClient = WebViewClient()
                        settings.javaScriptEnabled = true
                    }

                    val dialog = Dialog(this@TestWebview).apply {
                        setContentView(newWebView)
                        window!!.attributes.width = ViewGroup.LayoutParams.MATCH_PARENT
                        window!!.attributes.height = ViewGroup.LayoutParams.MATCH_PARENT
                        show()
                    }

                    newWebView.webChromeClient = object : WebChromeClient() {
                        override fun onCloseWindow(window: WebView?) {
                            dialog.dismiss()
                        }
                    }

                    (resultMsg?.obj as WebView.WebViewTransport).webView = newWebView
                    resultMsg.sendToTarget()
                    return true
                }
            }

            settings.javaScriptEnabled = true // 자바스크립트 허용
            settings.setSupportMultipleWindows(true) // 새창 띄우기 허용
            settings.javaScriptCanOpenWindowsAutomatically = true // 자바스크립트 새창띄우기
            settings.loadWithOverviewMode = true //메타태크 허용
            settings.useWideViewPort = true // 화면 사이즈 맞추기 허용
            settings.setSupportZoom(true) // 화면 줌 허용 여부
            settings.builtInZoomControls = true // 화면 확대 축소 허용 여부

            // webview chche 허용여부
            settings.cacheMode =
                WebSettings.LOAD_NO_CACHE
            settings.domStorageEnabled = true // 로컬 저장소 허용 여부
            settings.displayZoomControls = true


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                settings.safeBrowsingEnabled = true // api 26
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                settings.mediaPlaybackRequiresUserGesture = false
            }

            settings.allowContentAccess = true
            settings.setGeolocationEnabled(true)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                settings.allowUniversalAccessFromFileURLs = true
            }

            settings.allowFileAccess = true

            fitsSystemWindows = true

        }


        webView.loadUrl("file:///android_asset/MBTI.html")
    }

    inner class WebViewClientClass() : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView,
            url: String
        ): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            mProgressBar.visibility = ProgressBar.VISIBLE
            webView.visibility = View.INVISIBLE
        }

        override fun onPageCommitVisible(view: WebView?, url: String?) {
            super.onPageCommitVisible(view, url)
            mProgressBar.visibility = ProgressBar.GONE
            webView.visibility = View.VISIBLE
        }

        override fun onReceivedSslError(
            view: WebView?,
            handler: SslErrorHandler?,
            error: SslError?
        ) {
            var builder: android.app.AlertDialog.Builder =
                android.app.AlertDialog.Builder(this@TestWebview)
            var message = "SSL Certificate error."
            when (error!!.primaryError) {
                SslError.SSL_UNTRUSTED -> message =
                    "The certificate authority is not trusted"
                SslError.SSL_EXPIRED -> message = "The certificate has expired"
                SslError.SSL_IDMISMATCH -> message = "The Certificate Hostname mismatch"
                SslError.SSL_NOTYETVALID -> message = "The certificate is not yet valid"
            }
            message += "Do you want to continue anyway?"
            builder.setTitle("SSL Certificate Error")
            builder.setMessage(message)
            builder.setPositiveButton("continue",
                DialogInterface.OnClickListener { _, _ -> handler!!.proceed() })

            builder.setNegativeButton("cancel",
                DialogInterface.OnClickListener { _, _ -> handler!!.cancel() })
            val dialog: android.app.AlertDialog? = builder.create()
            dialog?.show()
        }

    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
