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
/*
public class ac7 extends Activity implements View.OnClickListener
{
	Statement s=ac.s;static String a;EditText e;Button b8;
	List<String>l4=new ArrayList<>(),l5=new ArrayList<>(),l6,l7;ba a2;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		l.setBackgroundColor(0xffffffcc);
		l.addView(e=new EditText(this));e.setHint("请输入您要搜索的关键词");
		l.addView(b8=new Button(this));b8.setText("搜索");b8.setOnClickListener(this);
		ListView l2=new ListView(this);l.addView(l2);
		l2.setAdapter(a2=new ba());
	}
	public void onClick(View v)
	{try{
		final String a=e.getText()+"";
		l6=l4;l4=new ArrayList<>();l7=l5;l5=new ArrayList<>();int i;
		for(i=0;i<l6.size();i++)if(l6.get(i).contains(a))
		{
			l4.add(l6.get(i));l5.add(l7.get(i));
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
			if(b==null)b=new Button(ac7.this);
			b.setText(l4.get(i));
			b.setOnClickListener(new View.OnClickListener()
			{
				public void onClick(View v)
				{
					a=l5.get(i);startActivity(new Intent(ac7.this,ac8.class));
				}
			});
			return b;
		}
	}
}*/
