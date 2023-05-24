package com.nha2023.ex95webapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    val wv : WebView by lazy { findViewById(R.id.wv) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //webview 기본 설정
        wv.settings.javaScriptEnabled = true //웹뷰설정 객체를 통해 js사용을 허용한다. (기본적으로 위험하다 판단해서 꺼둠)

        //가급적 해야하는
        wv.webViewClient = WebViewClient() //새로운 웹문서가 열릴때 기본 웹뷰는 새탭으로 열기에 이 웹뷰가 아니라 웹 브라우저가 실행되면서 열린다.
        wv.webChromeClient = WebChromeClient() //얼럿이나 컨펌같은 팝업기능을 사용하도록 설정...

        //웹뷰가 보여줄 웹문서(.html) 로드하기
        //웹문서가 있는 위치는 프로젝트 안에 있거나(인터넷이 안되도 읽어들일수있음- 그러나 앱 업데이트할때마다 apk파일을 다시 만들어서 올려야함.), 웹 서버에 위치시킨다.
        //1. 프로젝트 안에 assets 폴더안에 html 문서가 위치
        wv.loadUrl("file:///android_asset/index.html")
        // 프로젝트 폴더를 나타내는  /

        //2. 닷홈 or AWS 같은 웹 서버에 html 문서가 존재
        wv.loadUrl("http://mrhicock.dothome.co.kr")


    }

    override fun onBackPressed() {
        //super.onBackPressed()
        //뒤로가기 누르면 액티비티는 꺼진다.그것을 방지한다.
        if(wv.canGoBack()) wv.goBack()
        else finish()
    }
}