package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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

public class ac14 extends Activity implements View.OnClickListener
{
	EditText e,e2;Button b;TextView t;int i;String u,c,d;
	Statement s=ac.s;
	Handler h=new Handler()
	{
		public void handleMessage(Message m){t.setText(u);}
	};
	protected void onCreate(Bundle savedInstanceState)
	{try{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		l.setBackgroundColor(0xffffffcc);
		Thread t3=new Thread(new Runnable()
		{
			public void run()
			{try{
				ResultSet r=s.executeQuery("select * from t1 where 账号='"+ac.a+"'");
				for(;r.next();)
				{
					c=r.getString(2);
					d=r.getString(3);
				}
				r.close();
			}catch(Exception e){e.printStackTrace();}}
		});
		t3.start();
		t3.join();
		TextView t2=new TextView(this);l.addView(t2);t2.setText("账号："+ac.a);
		LinearLayout l3=new LinearLayout(this);l.addView(l3);
		LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,-2,1),p2=new LinearLayout.LayoutParams(0,-2,4);
		l3.addView(t2=new TextView(this),p);t2.setText("密码：");
		l3.addView(e=new EditText(this),p2);e.setText(c);
		l.addView(l3=new LinearLayout(this));
		l3.addView(t2=new TextView(this),p);t2.setText("联系方式：");
		l3.addView(e2=new EditText(this),p2);e2.setText(d);
		l.addView(b=new Button(this));b.setText("修改信息");b.setOnClickListener(this);
		l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
	}catch(Exception e){e.printStackTrace();}}
	public void onClick(View v)
	{try{
		Thread t=new Thread(new Runnable()
		{
			public void run()
			{try{
				try{
					s.execute("update t1 set 密码='"+e.getText()+"',联系方式='"+e2.getText()+"' where 账号='"+ac.a+"'");
					f("信息修改成功！");
				}catch(Exception e){}
			}catch(Exception e){e.printStackTrace();}}
		});
		t.start();t.join();
	}catch(Exception e){e.printStackTrace();}}
	void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
}