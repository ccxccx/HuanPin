package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.*;
import androidx.viewpager.widget.ViewPager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ac3 extends Activity implements View.OnClickListener
{
	Button b,b2,b3,b4,b5,b6,b7,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23;
	Statement s=ac.s;LinearLayout l,l2;RelativeLayout l3;
	LinearLayout.LayoutParams p;RelativeLayout.LayoutParams p2,p3;
	
	static String a;EditText e;Button b8;
	List<String> l4,l5,l6,l7;ba a2;
	
	EditText e2;Button b9;ba2 a3;
	List<String>l9,l11,l12,l13,l14,l15;
	TextView t;int i;String u;
	Handler h=new Handler()
	{
		public void handleMessage(Message m){t.setText(u);}
	};
	
	static String f,g;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//*
		l3=new RelativeLayout(this);setContentView(l3);//l3.setOrientation(LinearLayout.VERTICAL);
		l3.setBackgroundColor(0xffffffcc);
		p2=new RelativeLayout.LayoutParams(-1,-2);p2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		p3=new RelativeLayout.LayoutParams(-1,-1);p3.addRule(RelativeLayout.ABOVE,1);
		l2=new LinearLayout(this);l3.addView(l2,p2);int i=1;l2.setId(i);
		p=new LinearLayout.LayoutParams(0,-2,1);
		l2.addView(b7=new Button(this),p);b7.setText("我的");b7.setOnClickListener(this);
		l2.addView(b3=new Button(this),p);b3.setText("搜索商店");b3.setOnClickListener(this);
		l2.addView(b4=new Button(this),p);b4.setText("搜索拼单");b4.setOnClickListener(this);
		l2.addView(b20=new Button(this),p);b20.setText("其他功能");b20.setOnClickListener(this);
		if(ac10.d){ac10.d=false;b4.callOnClick();}
		else b7.callOnClick();
		//*/
		/*
		setContentView(R.layout.l3);
		b9=findViewById(R.id.b31);b2=findViewById(R.id.b32);b3=findViewById(R.id.b33);
		b4=findViewById(R.id.b34);b5=findViewById(R.id.b35);b6=findViewById(R.id.b36);
		b9.setOnClickListener(this);b2.setOnClickListener(this);b3.setOnClickListener(this);
		b4.setOnClickListener(this);b5.setOnClickListener(this);b6.setOnClickListener(this);
		//*/
	}
	public void onClick(View v)
	{try{
		if(v==b)startActivity(new Intent(ac3.this,ac4.class));
		else if(v==b2)startActivity(new Intent(ac3.this,ac5.class));
		else if(v==b3)
		{
			//startActivity(new Intent(ac3.this,ac7.class));
			//b3.setBackgroundColor(0xffff0000);
			l3.removeView(l);
			l=new LinearLayout(this);l3.addView(l,p3);l.setOrientation(LinearLayout.VERTICAL);
			//l3.removeView(l2);l3.addView(l2,p2);
			l2.bringToFront();
			l.setBackgroundColor(0xffffffcc);
			l.addView(e=new EditText(this));e.setHint("请输入您要搜索的关键词");
			l.addView(b8=new Button(this));b8.setText("搜索");b8.setOnClickListener(this);
			ListView l2=new ListView(this);l.addView(l2);
			l2.setAdapter(a2=new ba());
		}
		else if(v==b4)
		{
			//startActivity(new Intent(ac3.this,ac9.class));
			l3.removeView(l);
			l=new LinearLayout(this);l3.addView(l,p3);l.setOrientation(LinearLayout.VERTICAL);
			//l3.removeView(l2);l3.addView(l2,p2);
			l2.bringToFront();
			l.setBackgroundColor(0xffffffcc);
			l.addView(e2=new EditText(this));
			e2.setHint("请输入您要搜索的关键词");
			l.addView(b9=new Button(this));
			b9.setText("搜索");
			b9.setOnClickListener(this);
			l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
			l9=new ArrayList<>();l12=new ArrayList<>();l14=new ArrayList<>();
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select * from t4 where 状态=1&&账号!='"+ac.a+"'");
					for(;r.next();)
					{
						l9.add("账号："+r.getString(1)+"\n店名："+r.getString(2)+"\n地址："+r.getString(3)
								+"\n最晚时间："+r.getString(4)+"\n商品："+r.getString(5)+"\n价格："+r.getString(6)
								+"\n起送费："+r.getString(7)+"\n联系方式："+r.getString(8));
						l12.add(r.getString(2));
						l14.add(r.getString(1));
					}
					r.close();
				}catch(Exception e){e.printStackTrace();}}
			});
			t.start();
			t.join();
			ListView l3=new ListView(this);l.addView(l3);
			l3.setAdapter(a3=new ba2());
		}
		else if(v==b5)startActivity(new Intent(ac3.this,ac12.class));
		else if(v==b6)startActivity(new Intent(ac3.this,ac11.class));
		else if(v==b7)
		{
			l3.removeView(l);
			l=new LinearLayout(this);l3.addView(l,p3);l.setOrientation(LinearLayout.VERTICAL);
			//l3.removeView(l2);l3.addView(l2,p2);
			l2.bringToFront();
			l.addView(b22=new Button(this));b22.setText("修改我的信息");b22.setOnClickListener(this);
			l.addView(b=new Button(this));b.setText("添加商店");b.setOnClickListener(this);
			l.addView(b2=new Button(this));b2.setText("我的商店");b2.setOnClickListener(this);
			l.addView(b5=new Button(this));b5.setText("我的拼单");b5.setOnClickListener(this);
			l.addView(b6=new Button(this));b6.setText("我的地址");b6.setOnClickListener(this);
			l.addView(b21=new Button(this));b21.setText("反馈信息");b21.setOnClickListener(this);
			l.addView(b10=new Button(this));b10.setText("开通超级会员（每月可领取红包）（功能未实现）");b10.setOnClickListener(this);
			LinearLayout l2=new LinearLayout(this);l.addView(l2);
			l2.addView(b11=new Button(this),p);b11.setText("我的红包（功能未实现）");b11.setOnClickListener(this);
			l2.addView(b12=new Button(this),p);b12.setText("我的津贴（功能未实现）");b12.setOnClickListener(this);
			l2.addView(b13=new Button(this),p);b13.setText("我的钱包（功能未实现）");b13.setOnClickListener(this);
			l.addView(b14=new Button(this));b14.setText("我的收藏（功能未实现）");b14.setOnClickListener(this);
		}
		else if(v==b8)
		{
			final String a=e.getText()+"";
			l6=l4;l4=new ArrayList<>();l7=l5;l5=new ArrayList<>();int i;
			for(i=0;i<l6.size();i++)if(l6.get(i).contains(a))
			{
				l4.add(l6.get(i));l5.add(l7.get(i));
			}
			a2.notifyDataSetChanged();
		}
		else if(v==b9)
		{
			final String a=e2.getText()+"";
			l11=l9;l9=new ArrayList<>();
			l13=l12;l12=new ArrayList<>();
			l15=l14;l14=new ArrayList<>();
			int i;
			for(i=0;i<l11.size();i++)if(l11.get(i).contains(a))
			{
				l9.add(l11.get(i));
				l12.add(l13.get(i));
				l14.add(l12.get(i));
			}
			a3.notifyDataSetChanged();
		}
		else if(v==b20)
		{
			l3.removeView(l);
			l=new LinearLayout(this);l3.addView(l,p3);l.setOrientation(LinearLayout.VERTICAL);
			//l3.removeView(l2);l3.addView(l2,p2);
			l2.bringToFront();
			l.addView(b23=new Button(this));b23.setText("在地图上查看路线");b23.setOnClickListener(this);
			l.addView(b15=new Button(this));b15.setText("客服（功能未实现）");b15.setOnClickListener(this);
			l.addView(b16=new Button(this));b16.setText("推荐有奖（功能未实现）");b16.setOnClickListener(this);
			l.addView(b17=new Button(this));b17.setText("商务合作（功能未实现）");b17.setOnClickListener(this);
			l.addView(b18=new Button(this));b18.setText("办卡有礼（功能未实现）");b18.setOnClickListener(this);
			l.addView(b19=new Button(this));b19.setText("3小时公益（功能未实现）");b19.setOnClickListener(this);
		}
		else if(v==b21)startActivity(new Intent(this,ac13.class));
		else if(v==b22)startActivity(new Intent(this,ac14.class));
		else if(v==b23)startActivity(new Intent(this,ac15.class));
	}catch(Exception e){e.printStackTrace();}}
	class ba extends BaseAdapter
	{
		ba()
		{try{
			l4=new ArrayList<>();l5=new ArrayList<>();
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select * from t2");
					for(;r.next();)
					{
						l4.add("店名："+r.getString(1)+"\n起送费："+r.getString(3)+"\n配送费："+r.getString(4));
						l5.add(r.getString(1));
					}
					r.close();
				}catch(Exception e){e.printStackTrace();}}
			});
			t.start();
			t.join();
		}catch(Exception e){e.printStackTrace();}}
		public int getCount(){return l4.size();}
		public Object getItem(int position){return null;}
		public long getItemId(int position){return 0;}
		public View getView(final int i,View v,ViewGroup g)
		{
			Button b=(Button)v;
			if(b==null)b=new Button(ac3.this);
			b.setText(l4.get(i));
			b.setOnClickListener(new View.OnClickListener()
			{
				public void onClick(View v)
				{
					a=l5.get(i);startActivity(new Intent(ac3.this,ac8.class));
				}
			});
			return b;
		}
	}
	class ba2 extends BaseAdapter
	{
		public int getCount(){return l9.size();}
		public Object getItem(int position){return null;}
		public long getItemId(int position){return 0;}
		class i{TextView t;Button b,b2;i(TextView i,Button j,Button k){t=i;b=j;b2=k;}}
		public View getView(final int i,View v,ViewGroup vg)
		{
			LinearLayout l3=(LinearLayout)v;i a;
			if(l3==null)
			{
				l3=new LinearLayout(ac3.this);l3.setOrientation(LinearLayout.VERTICAL);
				l3.setTag(a=new i(new TextView(ac3.this),new Button(ac3.this),new Button(ac3.this)));
				l3.addView(a.t);
				l3.addView(a.b);a.b.setText("和他拼单");
				l3.addView(a.b2);a.b2.setText("在地图上查看路线");
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
								s.execute("update t4 set 状态=0,拼单号="+c+" where 状态=1&&店名='"+l12.get(i)
										+"'&&(账号='"+ac.a+"'||账号='"+l14.get(i)+"')");
								startActivity(new Intent(ac3.this,ac12.class));
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
			a.b2.setOnClickListener(new View.OnClickListener()
			{
				public void onClick(View v)
				{
					new Thread(new Runnable()
					{
						public void run()
						{try{
							ResultSet r=s.executeQuery("select 地址2 from t4 where 状态=1&&账号='"+ac.a+"'&&店名='"+l12.get(i)+"'");
							if(r.next())
							{
								f=r.getString(1);r.close();
								r=s.executeQuery("select 地址2 from t4 where 状态=1&&店名='"+l12.get(i)+"'&&账号='"+l14.get(i)+"'");
								//System.out.println("select 地址2 from t4 where 状态=1&&店名='"+l12.get(i)+"'&&账号='"+l14.get(i)+"'");
								r.next();g=r.getString(1);
								startActivity(new Intent(ac3.this,ac16.class));
							}
							else
							{
								f("您没有这个店的拼单信息！只有发布过相同的店的拼单，才能在地图上查看路线！");
							}
							r.close();
						}catch(Exception e){e.printStackTrace();}}
					}).start();
				}
			});
			return l3;
		}
	}
	void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
}
