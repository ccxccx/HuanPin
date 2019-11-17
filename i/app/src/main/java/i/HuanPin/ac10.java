package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ac10 extends Activity implements View.OnClickListener
{
	EditText e,e2;Button b,b2;
	Statement s=ac.s;
	protected void onCreate(Bundle savedInstanceState)
	{try{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		l.addView(e=new EditText(this));e.setHint("请输入或选择下面的地址");
		final Spinner s2=new Spinner(this);l.addView(s2);
		final List<String>l3=new ArrayList<>();l3.add("");
		Thread t=new Thread(new Runnable()
		{
			public void run()
			{try{
				ResultSet r=s.executeQuery("select 地址 from t5 where 账号='"+ac.a+"'");
				for(;r.next();)
				{
					l3.add(r.getString(1));
				}
				r.close();
			}catch(Exception e){e.printStackTrace();}}
		});
		t.start();t.join();
		s2.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,l3));
		s2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
		{
			public void onItemSelected(AdapterView<?> parent,View view,int i,long id)
			{
				e.setText(l3.get(i));
				//System.out.println(s2.getSelectedItem());
			}
			public void onNothingSelected(AdapterView<?> parent){}
		});
		TextView t2=new TextView(this);l.addView(t2);t2.setText("请修改下面的时间，作为本次拼单所能等待的最晚时间");
		l.addView(e2=new EditText(this));
		Calendar c=Calendar.getInstance();
		e2.setText(c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"
				+c.get(Calendar.DAY_OF_MONTH)+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE));
		l.addView(b=new Button(this));b.setText("添加拼单");b.setOnClickListener(this);
		l.addView(b2=new Button(this));b2.setText("智能拼单（这个功能还没实现）");b2.setOnClickListener(this);
	}catch(Exception e){e.printStackTrace();}}
	public void onClick(View v)
	{
		if(v==b)
		{
			new Thread(new Runnable()
			{
				public void run()
				{try{
					ResultSet r=s.executeQuery("select 起送费 from t2 where 店名='"+ac7.a+"'");
					r.next();String a=r.getString(1),b,c;
					r.close();
					r=s.executeQuery("select 联系方式 from t1 where 账号='"+ac.a+"'");
					r.next();b=r.getString(1);
					r.close();
					r=s.executeQuery("select * from t6");
					r.next();c=Integer.parseInt(r.getString(1))+1+"";
					r.close();
					s.execute("update t6 set 拼单号="+c);
					s.execute("insert into t4 values('"+ac.a+"','"+ac7.a+"','"+e.getText()+"','"+e2.getText()
							+"','"+ac8.b+"','"+ac8.c+"','"+a+"','"+b+"','"+c+"','1')");
					startActivity(new Intent(ac10.this,ac9.class));
				}catch(Exception e){e.printStackTrace();}}
			}).start();
		}
		else
		{
		
		}
	}
}