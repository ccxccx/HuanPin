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
/*
public class ac9 extends Activity implements View.OnClickListener
{
	EditText e2;Button b9;Statement s=ac.s;ba2 a3;
	List<String>l9=new ArrayList<>(),l11,l12=new ArrayList<>(),l13;
	TextView t;int i;String u;
	Handler h=new Handler()
	{
		public void handleMessage(Message m){t.setText(u);}
	};
	protected void onCreate(Bundle savedInstanceState)
	{try{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		l.setBackgroundColor(0xffffffcc);
		l.addView(e2=new EditText(this));
		e2.setHint("请输入您要搜索的关键词");
		l.addView(b9=new Button(this));
		b9.setText("搜索");
		b9.setOnClickListener(this);
		l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
		Thread t=new Thread(new Runnable()
		{
			public void run()
			{try{
				ResultSet r=s.executeQuery("select * from t4 where 状态=1&&账号!='"+ac.a+"'");
				for(;r.next();)
				{
					l9.add("店名："+r.getString(2)+"\n地址："+r.getString(3)+"\n最晚时间："+r.getString(4)
							+"\n商品："+r.getString(5)+"\n价格："+r.getString(6)+"\n起送费："+r.getString(7)
							+"\n联系方式："+r.getString(8));
					l12.add(r.getString(2));
				}
				r.close();
			}catch(Exception e){e.printStackTrace();}}
		});
		t.start();
		t.join();
		ListView l3=new ListView(this);l.addView(l3);
		l3.setAdapter(a3=new ba2());
	}catch(Exception e){e.printStackTrace();}}
	class ba2 extends BaseAdapter
	{
		public int getCount(){return l9.size();}
		public Object getItem(int position){return null;}
		public long getItemId(int position){return 0;}
		class i{TextView t;Button b;i(TextView i,Button j){t=i;b=j;}}
		public View getView(final int i,View v,ViewGroup g)
		{
			LinearLayout l3=(LinearLayout)v;i a;
			if(l3==null)
			{
				l3=new LinearLayout(ac9.this);l3.setOrientation(LinearLayout.VERTICAL);
				l3.setTag(a=new i(new TextView(ac9.this),new Button(ac9.this)));
				l3.addView(a.t);
				l3.addView(a.b);a.b.setText("和他拼单");
			}
			else a=(i)l3.getTag();
			a.t.setText(l9.get(i));
			a.b.setOnClickListener(new View.OnClickListener()
			{
				public void onClick(View v)
				{
					new Thread(new Runnable()
					{
						public void run()
						{try{
							ResultSet r=s.executeQuery("select * from t4 where 状态=1&&账号='"+ac.a+"'&&店名='"+l12.get(i)+"'");
							if(r.next())
							{
								String c=r.getString(9);
								s.execute("update t4 set 状态=0,拼单号="+c+" where 状态=1&&店名='"+l12.get(i)+"'");
								startActivity(new Intent(ac9.this,ac12.class));
							}
							else
							{
								f("您没有这个店的拼单信息！只有相同的店才能拼单！");
							}
							r.close();
						}catch(Exception e){e.printStackTrace();}}
					}).start();
				}
			});
			return l3;
		}
	}
	public void onClick(View v)
	{try{
		final String a=e2.getText()+"";
		l11=l9;
		l9=new ArrayList<>();
		l13=l12;
		l12=new ArrayList<>();int i;
		for(i=0;i<l11.size();i++)if(l11.get(i).contains(a))
		{
			l9.add(l11.get(i));
			l12.add(l13.get(i));
		}
		a3.notifyDataSetChanged();
	}catch(Exception e){e.printStackTrace();}}
	void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
}*/
