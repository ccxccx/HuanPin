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

public class ac12 extends Activity
{
	Statement s=ac.s;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		f();
	}
	void f()
	{
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		TextView t=new TextView(this);l.addView(t);t.setText("正在拼单的：");
		t.setBackgroundColor(0xffde8100);t.setGravity(Gravity.CENTER);
		LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,0,1);
		ListView l2=new ListView(this);l.addView(l2,p);l2.setAdapter(new ba());
		TextView t2=new TextView(this);l.addView(t2);t2.setText("未拼单的：");
		t2.setBackgroundColor(0xffde8100);t2.setGravity(Gravity.CENTER);
		ListView l3=new ListView(this);l.addView(l3,p);l3.setAdapter(new ba2());
		TextView t3=new TextView(this);l.addView(t3);t3.setText("拼单结束的：");
		t3.setBackgroundColor(0xffde8100);t3.setGravity(Gravity.CENTER);
		ListView l4=new ListView(this);l.addView(l4,p);l4.setAdapter(new ba3());
	}
	class ba extends BaseAdapter
	{
		List<String>l=new ArrayList<>(),l2=new ArrayList<>();
		ba()
		{try{
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					//ResultSet r=s.executeQuery(),r2=s.executeQuery();不行!!!!!!!!
					//，必须改为Statement s2=c.createStatement();ResultSet r=s.executeQuery(),r2=s2.executeQuery();...;s2.close();
					//超级易错难发现!!!!!!!!小心!!!!!!!!!
					ResultSet r=s.executeQuery("select * from t4 where 状态=0&&账号='"+ac.a+"'");
					Statement s2=ac.c.createStatement();
					for(;r.next();)
					{
						String a=r.getString(9);
						ResultSet r2=s2.executeQuery("select * from t4 where 账号!='"+ac.a+"'&&拼单号="+a);
						System.out.println(r.getString(1));
						r2.next();
						l.add("店名："+r.getString(2)+"\n地址："+r.getString(3)+"\n对方的地址："+r2.getString(3)
								+"\n商品："+r.getString(5)+"\n价格："+r.getString(6)+"\n对方的商品："
								+r2.getString(5)+"\n对方的价格："+r2.getString(6)+"\n起送费："+r.getString(7)
								+"\n联系方式："+r.getString(8)+"\n对方的联系方式："+r2.getString(8));
						l2.add(a);
						r2.close();
					}
					r.close();s2.close();
				}catch(Exception e){e.printStackTrace();}}
			});
			t.start();
			t.join();
		}catch(Exception e){e.printStackTrace();}}
		public int getCount(){return l.size();}
		public Object getItem(int position){return null;}
		public long getItemId(int position){return 0;}
		class i{TextView t;Button b;i(TextView i,Button j){t=i;b=j;}}
		public View getView(final int i,View v,ViewGroup g)
		{
			LinearLayout l3=(LinearLayout)v;i a;
			if(l3==null)
			{
				l3=new LinearLayout(ac12.this);l3.setOrientation(LinearLayout.VERTICAL);
				l3.setTag(a=new i(new TextView(ac12.this),new bu(ac12.this,"结束拼单")));
				l3.addView(a.t);l3.addView(a.b);
			}
			else a=(i)l3.getTag();
			a.t.setText(l.get(i));
			a.b.setOnClickListener(new View.OnClickListener()
			{
				public void onClick(View v)
				{
					new Thread(new Runnable()
					{
						public void run()
						{try{
							s.execute("update t4 set 状态=2 where 拼单号="+l2.get(i));
						}catch(Exception e){e.printStackTrace();}}
					}).start();
					f();
				}
			});
			return l3;
		}
	}
	class ba2 extends BaseAdapter
	{
		List<String>l=new ArrayList<>(),l2=new ArrayList<>();
		ba2()
		{try{
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select * from t4 where 状态=1&&账号='"+ac.a+"'");
					for(;r.next();)
					{
						l.add("店名："+r.getString(2)+"\n地址："+r.getString(3)
								+"\n商品："+r.getString(5)+"\n价格："+r.getString(6)
								+"\n起送费："+r.getString(7)+"\n联系方式："+r.getString(8));
						l2.add(r.getString(9));
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
		class i{TextView t;Button b;i(TextView i,Button j){t=i;b=j;}}
		public View getView(final int i,View v,ViewGroup g)
		{
			LinearLayout l3=(LinearLayout)v;i a;
			if(l3==null)
			{
				l3=new LinearLayout(ac12.this);l3.setOrientation(LinearLayout.VERTICAL);
				l3.setTag(a=new i(new TextView(ac12.this),new bu(ac12.this,"撤销拼单")));
				l3.addView(a.t);l3.addView(a.b);
			}
			else a=(i)l3.getTag();
			a.t.setText(l.get(i));
			a.b.setOnClickListener(new View.OnClickListener()
			{
				public void onClick(View v)
				{
					new Thread(new Runnable()
					{
						public void run()
						{try{
							s.execute("update t4 set 状态=2 where 拼单号="+l2.get(i));
						}catch(Exception e){e.printStackTrace();}}
					}).start();
					f();
				}
			});
			return l3;
		}
	}
	class ba3 extends BaseAdapter
	{
		List<String>l=new ArrayList<>();
		ba3()
		{try{
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select * from t4 where 状态=2&&账号='"+ac.a+"'");
					for(;r.next();)
					{
						l.add("店名："+r.getString(2)+"\n地址："+r.getString(3)
								+"\n商品："+r.getString(5)+"\n价格："+r.getString(6)
								+"\n起送费："+r.getString(7)+"\n联系方式："+r.getString(8));
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
			if(t==null)t=new TextView(ac12.this);
			t.setText(l.get(i));
			return t;
		}
	}
}