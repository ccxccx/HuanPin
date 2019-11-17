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

public class ac6 extends Activity implements View.OnClickListener
{
	EditText e,e2;Button b;TextView t;int i;String u;
	Statement s=ac.s;ListView l2;ba a;List<String>l=new ArrayList<>();
	Handler h=new Handler()
	{
		public void handleMessage(Message m){t.setText(u);}
	};
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		l.addView(e=new EditText(this));e.setHint("请输入商品名");
		l.addView(e2=new EditText(this));e2.setHint("请输入价格");
		l.addView(b=new Button(this));b.setText("添加商品");b.setOnClickListener(this);
		l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
		l2=new ListView(this);l.addView(l2);l2.setAdapter(a=new ba());
	}
	public void onClick(View v)
	{try{
		Thread t=new Thread(new Runnable()
		{
			public void run()
			{try{
				try{
					s.execute("insert into t3 values('"+ac5.a+"','"+e.getText()+"','"+e2.getText()+"')");
					f("添加商品成功！");
				}catch(Exception e)
				{
					f("该商品名已被注册！");
					e.printStackTrace();
				}
			}catch(Exception e){e.printStackTrace();}}
		});
		t.start();
		t.join();
		l.add("商品名："+e.getText()+"\n价格："+e2.getText());
		a.notifyDataSetChanged();
		l2.setSelection(l.size());
	}catch(Exception e){e.printStackTrace();}}
	void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
	class ba extends BaseAdapter
	{
		ba()
		{try{
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select * from t3 where 店名='"+ac5.a+"'");
					for(;r.next();)
					{
						l.add("商品名："+r.getString(2)+"\n价格："+r.getString(3));
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
			if(t==null)t=new TextView(ac6.this);
			t.setText(l.get(i));
			return t;
		}
	}
}