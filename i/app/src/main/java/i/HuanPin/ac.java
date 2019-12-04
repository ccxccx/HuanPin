package i.HuanPin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ac extends Activity implements View.OnClickListener
{
    EditText e,e2;Button b,b2;TextView t;int i;static Statement s;String u;
    static PasswordTransformationMethod p;static String a;static int w;
    static Connection c;
    Handler h=new Handler()
    {
        public void handleMessage(Message m){t.setText(u);}
    };
    protected void onCreate(Bundle savedInstanceState)
    {try{
        super.onCreate(savedInstanceState);
        //*
        LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
        l.setBackgroundColor(0xffffffcc);
        //l.addView(i,-2,-2);不行
        //l.addView(i,new LinearLayout.LayoutParams(-2,-2,1));也不行
        w=getWindowManager().getDefaultDisplay().getWidth();
        ImageView i=new ImageView(this);i.setImageResource(R.drawable.i);l.addView(i,-1,w/2);
        l.addView(e=new EditText(this));l.addView(e2=new EditText(this));
        l.addView(b=new Button(this));l.addView(b2=new Button(this));
        e.setHint("请输入账号");e2.setHint("请输入密码");e2.setTransformationMethod(p=PasswordTransformationMethod.getInstance());
        b.setText("登录");b2.setText("注册");
        b.setOnClickListener(this);b2.setOnClickListener(this);
        l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
        //*/
        /*
        setContentView(R.layout.l1denglu);
        e=findViewById(R.id.e);e2=findViewById(R.id.e2);
        b=findViewById(R.id.b);b2=findViewById(R.id.b2);
        b.setOnClickListener(this);b2.setOnClickListener(this);
        t=findViewById(R.id.t);
        //*/
        Thread t=new Thread(new Runnable()
        {
            public void run()
            {try{
                Class.forName("com.mysql.jdbc.Driver");
                c=DriverManager.getConnection("jdbc:mysql://172.81.211.138:3306/huanpin?useSSL=false","root","ccx");
                s=c.createStatement();
            }catch(Exception e){e.printStackTrace();}}
        });
        t.start();
        t.join();
    }catch(Exception e){e.printStackTrace();}}
    public void onClick(final View v)
    {
        new Thread(new Runnable()
        {
            public void run()
            {try{
                if(v==b)
                {
                	a=e.getText()+"";
                    ResultSet r=s.executeQuery("select * from t1 where 账号='"+a+"'");
                    if(r.next())
                    {
                        if(r.getString(2).equals(e2.getText()+""))
                            startActivity(new Intent(ac.this,ac3.class));
                        else f("密码错误！");
                    }
                    else f("账号不存在！");
                    r.close();
                }
                else startActivity(new Intent(ac.this,ac2.class));
            }catch(Exception e){e.printStackTrace();}}
        }).start();
    }
    void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
}
class bu extends Button
{
    Context c;Bitmap b;
    bu(Context a,int i)
    {
        super(a);c=a;b=BitmapFactory.decodeResource(c.getResources(),i);
    }
    protected void onDraw(Canvas c)
    {
        super.onDraw(c);int h=getHeight(),i=h/6,j=h*7/8;
        c.drawBitmap(b,null,new Rect(i,i,j,j),null);
    }
}