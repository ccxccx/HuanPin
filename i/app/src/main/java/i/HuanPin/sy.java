package i.HuanPin;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.Calendar;
import java.util.Date;

public class sy extends Activity
{
	Button b;TextView t;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
        l.addView(b=new bu(this,R.drawable.tianjia));
        b.setText("登录<br>1\n2&#10;3");
		//l.addView(t=new TextView(this));
		/*WebView w=new WebView(this);
		setContentView(w);
		//w.loadUrl("http://www.baidu.com");
		w.loadUrl("http://172.81.211.138:8080/0?i=福州大学&j=福州大学玫瑰餐厅");
		//避免使用别的浏览器打开
		w.setWebViewClient(new WebViewClient());
		WebSettings s=w.getSettings();
		//使网页能运行JavaScript
		s.setJavaScriptEnabled(true);
		//使内容适应屏幕大小
		s.setUseWideViewPort(true);s.setLoadWithOverviewMode(true);*/
	}
	
}

