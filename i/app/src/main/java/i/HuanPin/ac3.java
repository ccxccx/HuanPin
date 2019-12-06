package i.HuanPin;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.*;
import androidx.viewpager.widget.ViewPager;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ac3 extends Activity implements View.OnClickListener
{
	Button b,b2,b5,b6,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b21,b22,b23;
	Statement s=ac.s;LinearLayout l,l2;RelativeLayout l3;
	LinearLayout.LayoutParams p;RelativeLayout.LayoutParams p2,p3;
	li b3,b4,b7,b20;
	
	static String a;EditText e;ImageView b8;
	List<String>l4,l5,l6,l7;ba a2;
	
	EditText e2;ImageView b9;ba2 a3;
	List<String>l9,l11,l12,l13,l14,l15;
	TextView t;int i;String u;
	Handler h=new Handler()
	{
		public void handleMessage(Message m){t.setText(u);}
	};
	
	static String f,g;boolean j;
	static Bitmap c;ImageView i2;
	class li extends LinearLayout
	{
		li(Context c,int i,String s)
		{
			super(c);setOrientation(LinearLayout.VERTICAL);setOnClickListener(ac3.this);
			ImageView i2=new ImageView(c);addView(i2,-1,ac.w/7);i2.setImageResource(i);
			TextView t=new TextView(c);addView(t);t.setText(s);t.setGravity(Gravity.CENTER);
		}
	}
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//*
		l3=new RelativeLayout(this);setContentView(l3);
		p2=new RelativeLayout.LayoutParams(-1,-2);p2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		p3=new RelativeLayout.LayoutParams(-1,-1);p3.addRule(RelativeLayout.ABOVE,1);
		l2=new LinearLayout(this);l3.addView(l2,p2);int i=1;l2.setId(i);
		l2.setBackgroundColor(0xffede387);
		p=new LinearLayout.LayoutParams(0,-2,1);
		l2.addView(b3=new li(this,R.drawable.sandian,"搜索商店"),p);b3.setOnClickListener(this);
		l2.addView(b4=new li(this,R.drawable.pindan,"搜索拼单"),p);b4.setOnClickListener(this);
		l2.addView(b7=new li(this,R.drawable.wode,"我的"),p);b7.setOnClickListener(this);
		l2.addView(b20=new li(this,R.drawable.qita,"其他功能"),p);b20.setOnClickListener(this);
		if(ac10.d){ac10.d=false;b4.callOnClick();}
		else b3.callOnClick();
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
			j=false;
			//startActivity(new Intent(ac3.this,ac7.class));
			l3.removeView(l);
			l=new LinearLayout(this);l3.addView(l,p3);l.setOrientation(LinearLayout.VERTICAL);
			//l3.removeView(l2);l3.addView(l2,p2);
			l2.bringToFront();
			LinearLayout l4=new LinearLayout(this);l.addView(l4);
			l4.setBackgroundColor(0xffede387);
			l4.addView(e=new EditText(this),new LinearLayout.LayoutParams(0,-2,5));e.setHint("请输入您要搜索的关键词");
			LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,ac.w/10,1);
			int i=ac.w/100;p.setMargins(i,i,i,i);
			l4.addView(b8=new ImageView(this),p);
			b8.setImageResource(R.drawable.sou);b8.setOnClickListener(this);
			ListView l2=new ListView(this);l.addView(l2);
			l2.setAdapter(a2=new ba());
		}
		else if(v==b4)
		{
			j=true;
			//startActivity(new Intent(ac3.this,ac9.class));
			l3.removeView(l);
			l=new LinearLayout(this);l3.addView(l,p3);l.setOrientation(LinearLayout.VERTICAL);
			//l3.removeView(l2);l3.addView(l2,p2);
			l2.bringToFront();
			LinearLayout l4=new LinearLayout(this);l.addView(l4);
			l4.setBackgroundColor(0xffede387);
			l4.addView(e2=new EditText(this),new LinearLayout.LayoutParams(0,-2,5));e2.setHint("请输入您要搜索的关键词");
			LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,ac.w/10,1);
			int i=ac.w/100;p.setMargins(i,i,i,i);
			l4.addView(b9=new ImageView(this),p);
			b9.setImageResource(R.drawable.sou);b9.setOnClickListener(this);
			l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
			l11=l9=new ArrayList<>();l13=l12=new ArrayList<>();l15=l14=new ArrayList<>();
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select * from t4 where 状态=1&&账号!='"+ac.a+"'");
					for(;r.next();)
					{
						l9.add("店名："+r.getString(2)+"，商品："+r.getString(5)
								+"\n价格："+r.getString(6)+"，起送费："+r.getString(7)
								+"\n地址："+r.getString(3)+"，最晚时间："+r.getString(4)
								+"\n账号："+r.getString(1)+"，联系方式："+r.getString(8));
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
			j=true;
			l3.removeView(l);
			l=new LinearLayout(this);l3.addView(l,p3);l.setOrientation(LinearLayout.VERTICAL);
			//l3.removeView(l2);l3.addView(l2,p2);
			l2.bringToFront();
			LinearLayout l4=new LinearLayout(this);l.addView(l4);l4.setBackgroundColor(0xffede387);
			i2=new ImageView(this);
			l4.addView(i2,new LinearLayout.LayoutParams(0,ac.w/4,1));
			if(c==null)
			{
				Thread t=new Thread(new Runnable()
				{
					public void run()
					{try{
						ResultSet r=s.executeQuery("select 头像 from t1 where 账号='"+ac.a+"'");
						r.next();c=ac.s2b(r.getString(1));r.close();
					}catch(Exception e){e.printStackTrace();}}
				});
				t.start();t.join();
			}
			i2.setImageBitmap(c);
			TextView t2=new TextView(this);
			l4.addView(t2,new LinearLayout.LayoutParams(0,ac.w/4,3));
			t2.setText("账号："+ac.a);t2.setGravity(Gravity.CENTER);
			l.addView(b22=new bu2(this,"修改我的信息",R.drawable.wode));b22.setOnClickListener(this);
			l.addView(b=new bu2(this,"添加商店",R.drawable.tianjia));b.setOnClickListener(this);
			l.addView(b2=new bu2(this,"我的商店",R.drawable.sandian));b2.setOnClickListener(this);
			l.addView(b5=new bu2(this,"我的拼单",R.drawable.pindan));b5.setOnClickListener(this);
			l.addView(b6=new bu2(this,"我的地址",R.drawable.dizhi));b6.setOnClickListener(this);
			l.addView(b21=new bu(this,"反馈信息"));b21.setOnClickListener(this);
			/*l.addView(b10=new Button(this));b10.setText("开通超级会员（每月可领取红包）（功能未实现）");b10.setOnClickListener(this);
			LinearLayout l2=new LinearLayout(this);l.addView(l2);
			l2.addView(b11=new Button(this),p);b11.setText("我的红包（功能未实现）");b11.setOnClickListener(this);
			l2.addView(b12=new Button(this),p);b12.setText("我的津贴（功能未实现）");b12.setOnClickListener(this);
			l2.addView(b13=new Button(this),p);b13.setText("我的钱包（功能未实现）");b13.setOnClickListener(this);
			l.addView(b14=new Button(this));b14.setText("我的收藏（功能未实现）");b14.setOnClickListener(this);*/
		}
		else if(v==b8)
		{
			final String a=e.getText()+"";
			l4=new ArrayList<>();l5=new ArrayList<>();int i;
			for(i=0;i<l6.size();i++)if(l6.get(i).toLowerCase().contains(a.toLowerCase()))
			{
				l4.add(l6.get(i));l5.add(l7.get(i));
			}
			a2.notifyDataSetChanged();
		}
		else if(v==b9)
		{
			final String a=e2.getText()+"";
			l9=new ArrayList<>();l12=new ArrayList<>();l14=new ArrayList<>();
			int i;
			for(i=0;i<l11.size();i++)if(l11.get(i).toLowerCase().contains(a.toLowerCase()))
			{
				l9.add(l11.get(i));
				l12.add(l13.get(i));
				l14.add(l15.get(i));
			}
			a3.notifyDataSetChanged();
		}
		else if(v==b20)
		{
			j=true;
			l3.removeView(l);
			l=new LinearLayout(this);l3.addView(l,p3);l.setOrientation(LinearLayout.VERTICAL);
			//l3.removeView(l2);l3.addView(l2,p2);
			l2.bringToFront();
			l.addView(b23=new bu(this,"在地图上查看路线"));b23.setOnClickListener(this);
			/*l.addView(b15=new bu(this,R.drawable.kefu));b15.setText("客服（功能未实现）");b15.setOnClickListener(this);
			l.addView(b16=new bu(this,R.drawable.zan));b16.setText("推荐有奖（功能未实现）");b16.setOnClickListener(this);
			l.addView(b17=new bu(this,R.drawable.hezuo));b17.setText("商务合作（功能未实现）");b17.setOnClickListener(this);
			l.addView(b18=new Button(this));b18.setText("办卡有礼（功能未实现）");b18.setOnClickListener(this);
			l.addView(b19=new Button(this));b19.setText("3小时公益（功能未实现）");b19.setOnClickListener(this);*/
		}
		else if(v==b21)startActivity(new Intent(this,ac13.class));
		else if(v==b22)startActivityForResult(new Intent(this,ac14.class),0);
		else if(v==b23)startActivity(new Intent(this,ac15.class));
	}catch(Exception e){e.printStackTrace();}}
	protected void onActivityResult(int requestCode,int resultCode,Intent i)
	{try{
		i2.setImageBitmap(c);
	}catch(Exception e){e.printStackTrace();}}
	public boolean onKeyDown(int i,KeyEvent e)
	{
		if(i==4){if(j)b3.callOnClick();else finish();}
		//若return true;则会把除了电源键和home键以外
		//的其他所有按键(如音量+-和返回键等)的原来
		//的作用都屏蔽了，小心!!!!!
		//若return false;则只会把返回键屏蔽了
		//，这说明返回键的作用写在了super.onKeyDown(i,e);里
		//记原理!!!!!!!!!!!!!小心!!!!!!!!!!
		//若return super.onKeyDown(i,e);
		//则所有按键都会有原来的作用
		//对比记忆!!!!!!!!!小心!!!!!!!!!!!
		//所以这里要用return false;对比!!!!!!记原理!!!!!!!小心!!!!!!!
		return false;
	}
	class ba extends BaseAdapter
	{
		ba()
		{try{
			l6=l4=new ArrayList<>();l7=l5=new ArrayList<>();
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
			if(b==null)b=new bu(ac3.this,l4.get(i));
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
				l3.setTag(a=new i(new TextView(ac3.this),new bu(ac3.this,"和他拼单"),new bu(ac3.this,"在地图上查看路线")));
				l3.addView(a.t);l3.addView(a.b);l3.addView(a.b2);
				//setTextSize()不能用ac.w/60f之类的相对数，而必须用普通的数，不然不同的手机显示会不一样，小心!!!!!!!!!
				a.t.setTextSize(18);
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