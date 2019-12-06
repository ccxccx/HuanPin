package i.HuanPin;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

public class sy extends Activity
{
	Button b;TextView t;Connection c;
	Statement s;LinearLayout l;
	ImageView i;String a;int w;
	protected void onCreate(Bundle savedInstanceState)
	{try{
		super.onCreate(savedInstanceState);
		w=getWindowManager().getDefaultDisplay().getWidth();
		l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
        //l.addView(b=new bu(this,R.drawable.tianjia));
        //b.setText("登录<br>1\n2&#10;3");
		l.addView(t=new TextView(this));
		l.addView(i=new ImageView(this),-1,400);
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
		
		
		
		
		
		//setContentView(R.layout.l1denglu);
		
		
		
		/*Intent albumIntent = new Intent(Intent.ACTION_PICK);
		albumIntent.setType( "image/*");
		startActivityForResult(albumIntent,0);
		*/
		
		
		t.setText("123 "+w+" "+getWindowManager().getDefaultDisplay().getHeight());
		t.setTextSize(100);
		
		
		
		
		
		
		
		
			
			
			
	}catch(Exception e){e.printStackTrace();}}
	protected void onActivityResult(int requestCode,int resultCode,Intent i)
	{
		t.append(i.getData()+"\n");
		Cursor c=getContentResolver().query(i.getData(),null,null,null,null);
		c.moveToNext();t.append((a=c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA)))+"\n");
		c.close();
		//必须<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>和requestPermissions()一起使用才行
		//易错难发现!!!!!!!!!小心!!!!!!!!!
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
		//t.append(a+"\n");
	}
	InputStream in;
	public void onRequestPermissionsResult(int requestCode,String[]permissions, int[]grantResults)
	{try{
		//t.append(a+"\n");
		Thread t2=new Thread(new Runnable()
		{
			public void run()
			{try{
				Class.forName("com.mysql.jdbc.Driver");
				c=DriverManager.getConnection("jdbc:mysql://172.81.211.138:3306/huanpin?useSSL=false","root","ccx");
				s=c.createStatement();
				PreparedStatement s2=c.prepareStatement("update t1 set 头像=? where 账号='0'");
				s2.setBlob(1,new FileInputStream(a));
				s2.execute();
				
				
				
				ResultSet r=s.executeQuery("select 头像 from t1 where 账号='0'");
				r.next();in=r.getBlob(1).getBinaryStream();
				
				
					
				
			}catch(Exception e){e.printStackTrace();}}
		});
		t2.start();t2.join();
		//t.append(a+"\n"+in);
		i.setImageBitmap(BitmapFactory.decodeStream(in));
	}catch(Exception e){e.printStackTrace();}}
}




























