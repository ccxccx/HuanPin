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

public class ac8 extends Activity
{
	Statement s=ac.s;ListView l2;ba a;List<String>l=new ArrayList<>(),l4=new ArrayList<>(),l5=new ArrayList<>();
	static String b,c;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(l2=new ListView(this));l2.setAdapter(a=new ba());
		l2.setBackgroundColor(0xffffffcc);
	}
	class ba extends BaseAdapter
	{
		ba()
		{try{
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select * from t3 where 店名='"+ac3.a+"'");
					for(;r.next();)
					{
						l.add("商品名："+r.getString(2)+"\n价格："+r.getString(3));
						l4.add(r.getString(2));l5.add(r.getString(3));
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
				l3=new LinearLayout(ac8.this);l3.setOrientation(LinearLayout.VERTICAL);
				l3.setTag(a=new i(new TextView(ac8.this),new Button(ac8.this)));
				l3.addView(a.t);
				l3.addView(a.b);a.b.setText("添加拼单");
			}
			else a=(i)l3.getTag();
			a.t.setText(l.get(i));
			a.b.setOnClickListener(new View.OnClickListener()
			{
				public void onClick(View v)
				{
					b=l4.get(i);c=l5.get(i);
					startActivity(new Intent(ac8.this,ac10.class));
				}
			});
			return l3;
		}
	}
}