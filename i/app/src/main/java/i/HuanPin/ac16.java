package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ac16 extends Activity
{
	WebView w;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(w=new WebView(this));
		//避免使用别的浏览器打开
		w.setWebViewClient(new WebViewClient());
		WebSettings s=w.getSettings();
		//使网页能运行JavaScript
		s.setJavaScriptEnabled(true);
		//使内容适应屏幕大小
		s.setUseWideViewPort(true);s.setLoadWithOverviewMode(true);
		w.loadUrl("http://172.81.211.138:8080/0?i="+ac3.f+"&j="+ac3.g);
	}
}