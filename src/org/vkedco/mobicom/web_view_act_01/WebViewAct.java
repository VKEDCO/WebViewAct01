package org.vkedco.mobicom.web_view_act_01;

import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewAct extends Activity {
	
	WebView mWebView = null;
	final static String MESSAGE = "Random Number from WebViewAct: ";
	static Random mRandNum = new Random();

	//@SuppressLint({ "SetJavaScriptEnabled", "JavascriptInterface" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_view_layout);
		
		Intent i = this.getIntent();
		String html_type = i.getStringExtra("html_type");
		
		mWebView = (WebView) findViewById(R.id.web_view);
		
		if ( html_type.equals("static") ) {
			mWebView.loadUrl("file:///android_asset/swiss_hot_cocoa_mix.html");
		}
		else if ( html_type.equals("dynamic") ) {
			final String mimeType = "text/html";
	        final String encoding = "UTF-8";
	        String html = "<html><h4>" + MESSAGE + mRandNum.nextInt(101) + "</h4></html>";
	        mWebView.loadDataWithBaseURL("", html, mimeType, encoding, "");  
		}
		
	}
	
}
