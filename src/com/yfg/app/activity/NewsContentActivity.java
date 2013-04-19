package com.yfg.app.activity;


import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ViewSwitcher;

/**
 * 用于显示新闻详情页面
 * 
 * 
 * @author lyuan
 *
 */
public class NewsContentActivity extends BaseScreen {
	
	ImageButton btn_back;
	WebView webView;
	String content_url;
	ViewSwitcher viewSwitcher;

	
	@Override
	public void initView() {
		setContentView(R.layout.layout_newscontent);
		btn_back = (ImageButton) findViewById(R.id.btn_newscontent_back);
		btn_back.setOnClickListener(listener);

		viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);

//		content_url = "http://news.163.com/13/0419/05/8SQ3MKK200011229.html";
		content_url = "http://v.youku.com/v_show/id_XNTQ0OTQ3OTU2.html?f=19182695";
		webView = new WebView(this);
		// 向ViewSwitcher中添加两个View，用来切换
		viewSwitcher.addView(webView);
		viewSwitcher.addView(getLayoutInflater().inflate(R.layout.layout_progress_page, null));
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setUseWideViewPort(true); 
		settings.setLoadWithOverviewMode(true);
		webView.setWebViewClient(client);
		webView.loadUrl(content_url);

	}
	
	
	private WebViewClient client = new WebViewClient() {

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			viewSwitcher.showPrevious();
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			viewSwitcher.showNext();
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return super.shouldOverrideUrlLoading(view, url);
		}

	};

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			NewsContentActivity.this.setResult(RESULT_OK);
			NewsContentActivity.this.finish();
		}
	};

	public void onBackPressed() {
		if (webView.canGoBack()) {
			webView.goBack();
		} else {
			NewsContentActivity.this.setResult(RESULT_OK);
			NewsContentActivity.this.finish();
		}
	};
	
	
	
	
	
	
	

}
