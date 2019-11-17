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

public class ac11 extends Activity implements View.OnClickListener
{
	EditText e;Button b;TextView t;int i;String u;
	Statement s=ac.s;
	Handler h=new Handler()
	{
		public void handleMessage(Message m){t.setText(u);}
	};
	List<String>l=new ArrayList<>();ListView l2;ba c;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		l.addView(e=new EditText(this));e.setHint("请输入地址");
		l.addView(b=new Button(this));b.setText("添加地址");b.setOnClickListener(this);
		l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
		l2=new ListView(this);l.addView(l2);
		l2.setAdapter(c=new ba());
	}
	class ba extends BaseAdapter
	{
		ba()
		{try{
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select 地址 from t5 where 账号='"+ac.a+"'");
					for(;r.next();)
					{
						l.add(r.getString(1));
					}
					r.close();
				}catch(Exception e){e.printStackTrace();}}
			});
			t.start();
			t.join();
		}catch(Exception e){e.printStackTrace();}}
		public int getCount(){return l.size();}
		public Object getItem(int position){return null;}
		public long getItemId(int position){return 0;}
		public View getView(final int i,View v,ViewGroup g)
		{
			TextView t=(TextView)v;
			if(t==null)t=new TextView(ac11.this);
			t.setText(l.get(i));
			return t;
		}
	}
	public void onClick(View v)
	{try{
		Thread t=new Thread(new Runnable()
		{
			public void run()
			{try{
				try{
					s.execute("insert into t5 values('"+ac.a+"','"+e.getText()+"')");
				}catch(Exception e)
				{
					f("已添加过该地址！");
				}
			}catch(Exception e){e.printStackTrace();}}
		});
		t.start();t.join();
		l.add(e.getText()+"");
		c.notifyDataSetChanged();
		l2.setSelection(l.size());
	}catch(Exception e){e.printStackTrace();}}
	void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
}