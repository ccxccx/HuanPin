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

public class ac15 extends Activity implements View.OnClickListener
{
	EditText e,e2;Button b;TextView t;WebView w;
	Statement s=ac.s;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		l.addView(t=new TextView(this));
		t.setText("有些地址无法正确识别，如：福州大学32#107、福州大学东3、福州大学东3-201、福州大学东3楼201\n"
		+"如果看地图时发现有错，请把地址改为较容易识别的地址，如：福州大学、福州大学32号楼、福州大学玫瑰餐厅、福州大学教学楼、福州大学东3楼、福州大学图书馆");
		t.setBackgroundColor(0xffde8100);
		l.addView(e=new EditText(this));e.setHint("请输入起始地址");
		l.addView(e2=new EditText(this));e2.setHint("请输入终点地址");
		l.addView(b=new bu(this,"在地图上查看路线"));b.setOnClickListener(this);
		l.addView(w=new WebView(this),-1,-1);
		//避免使用别的浏览器打开
		w.setWebViewClient(new WebViewClient());
		WebSettings s=w.getSettings();
		//使网页能运行JavaScript
		s.setJavaScriptEnabled(true);
		//使内容适应屏幕大小
		s.setUseWideViewPort(true);s.setLoadWithOverviewMode(true);
	}
	public void onClick(View v)
	{try{
		w.loadUrl("http://172.81.211.138:8080/0?i="+e.getText()+"&j="+e2.getText());
	}catch(Exception e){e.printStackTrace();}}
	
}