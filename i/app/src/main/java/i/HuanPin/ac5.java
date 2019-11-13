package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ac5 extends Activity
{
	Statement s=ac.s;static String a;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		ListView l=new ListView(this);setContentView(l);
		l.setAdapter(new ba());
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
					ResultSet r=s.executeQuery("select * from t2 where 账号='"+ac.a+"'");
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
			if(b==null)b=new Button(ac5.this);
			b.setText(l.get(i));
			b.setOnClickListener(new View.OnClickListener()
			{
				public void onClick(View v)
				{
					a=l2.get(i);startActivity(new Intent(ac5.this,ac6.class));
				}
			});
			return b;
		}
	}
}
