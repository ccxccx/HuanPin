package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ac7 extends Activity implements View.OnClickListener
{
	Statement s=ac.s;static String a;EditText e;Button b;
	List<String>l=new ArrayList<>(),l2=new ArrayList<>(),l3,l4;ba a2;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l2=new LinearLayout(this);setContentView(l2);l2.setOrientation(LinearLayout.VERTICAL);
		l2.setBackgroundColor(0xffffffcc);
		l2.addView(e=new EditText(this));e.setHint("请输入您要搜索的关键词");
		l2.addView(b=new Button(this));b.setText("搜索");b.setOnClickListener(this);
		ListView l=new ListView(this);l2.addView(l);
		l.setAdapter(a2=new ba());
	}
	public void onClick(View v)
	{try{
		final String a=e.getText()+"";
		l3=l;l=new ArrayList<>();l4=l2;l2=new ArrayList<>();int i;
		for(i=0;i<l3.size();i++)if(l3.get(i).contains(a))
		{
			l.add(l3.get(i));l2.add(l4.get(i));
		}
		a2.notifyDataSetChanged();
	}catch(Exception e){e.printStackTrace();}}
	class ba extends BaseAdapter
	{
		ba()
		{try{
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select * from t2");
					for(;r.next();)
					{
						l.add("店名："+r.getString(1)+"\n起送费："+r.getString(3)+"\n配送费："+r.getString(4));
						l2.add(r.getString(1));
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
			Button b=(Button)v;
			if(b==null)b=new Button(ac7.this);
			b.setText(l.get(i));
			b.setOnClickListener(new View.OnClickListener()
			{
				public void onClick(View v)
				{
					a=l2.get(i);startActivity(new Intent(ac7.this,ac8.class));
				}
			});
			return b;
		}
	}
}
