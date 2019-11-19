package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Statement;

public class ac4 extends Activity implements View.OnClickListener
{
    EditText e,e2,e3;Button b;TextView t;int i;String u;
	Statement s=ac.s;
	Handler h=new Handler()
	{
		public void handleMessage(Message m){t.setText(u);}
	};
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		//*/
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		l.setBackgroundColor(0xffffffcc);
        l.addView(e=new EditText(this));e.setHint("请输入店名");
		l.addView(e2=new EditText(this));e2.setHint("请输入商店的起送费");
		l.addView(e3=new EditText(this));e3.setHint("请输入商店的配送费");
        l.addView(b=new Button(this));b.setText("添加商店");b.setOnClickListener(this);
        l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
		//*/
		/*
		setContentView(R.layout.l11);
		e2=findViewById(R.id.e41);e2=findViewById(R.id.e42);e3=findViewById(R.id.e43);
		b9=findViewById(R.id.b41);t=findViewById(R.id.t41);
		b9.setOnClickListener(this);
		//*/
    }
    public void onClick(View v)
    {
		new Thread(new Runnable()
		{
			public void run()
			{try{
				try{
					s.execute("insert into t2(店名,账号,起送费,配送费) values('"+e.getText()+"','"+ac.a+"','"+e2.getText()+"','"+e3.getText()+"')");
					startActivity(new Intent(ac4.this,ac5.class));
				}catch(Exception e)
				{
					f("该店名已被注册！");
				}
			}catch(Exception e){e.printStackTrace();}}
		}).start();
    }
	void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
}