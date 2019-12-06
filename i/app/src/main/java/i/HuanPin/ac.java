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
import android.util.Base64;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
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
        w=getWindowManager().getDefaultDisplay().getWidth();
        //*
        LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
        l.setBackgroundColor(0xffede387);
        //l.addView(i,-2,-2);不行
        //l.addView(i,new LinearLayout.LayoutParams(-2,-2,1));也不行
        ImageView i=new ImageView(this);i.setImageResource(R.drawable.i);l.addView(i,-1,w*2/3);
        LinearLayout.LayoutParams p2=new LinearLayout.LayoutParams(-1,-2),p3=new LinearLayout.LayoutParams(-1,-2);
        int j=ac.w/6,k=ac.w/64;p2.setMargins(j,0,j,0);
        j=ac.w/4;p3.setMargins(j,k,j,k);
        l.addView(e=new EditText(this),p2);l.addView(e2=new EditText(this),p2);
        l.addView(b=new bu(this,"登录"),p3);l.addView(b2=new bu(this,"注册"),p3);
        e.setHint("请输入账号");e2.setHint("请输入密码");e2.setTransformationMethod(p=PasswordTransformationMethod.getInstance());
        b.setOnClickListener(this);b2.setOnClickListener(this);
        l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
        //*/
        /*
        setContentView(R.layout.l1denglu);
        e=findViewById(R.id.l1e);e2=findViewById(R.id.l1e2);
        b=findViewById(R.id.l1b);b2=findViewById(R.id.l1b2);
        b.setOnClickListener(this);b2.setOnClickListener(this);
        t=findViewById(R.id.l1t);
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
    static Bitmap s2b(String s)
    {
        byte[]b=Base64.decode(s,Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(b,0,b.length);
    }
    static String b2s(Bitmap b)
    {
        ByteArrayOutputStream o= new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100,o);
        return Base64.encodeToString(o.toByteArray(),Base64.DEFAULT);
    }
}
class bu extends Button
{
    bu(Context c,String s)
    {
        super(c);setText(s);setBackgroundColor(0xffde8100);
        int i=ac.w/64;
        LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,-2);
        p.setMargins(0,i,0,i);
        setLayoutParams(p);
    }
}
class bu2 extends bu
{
    Bitmap b;
    bu2(Context c,String s,int i)
    {
        super(c,s);
        b=BitmapFactory.decodeResource(c.getResources(),i);
    }
    protected void onDraw(Canvas c)
    {
        super.onDraw(c);int h=getHeight(),i=h/6,j=h*7/8;
        c.drawBitmap(b,null,new Rect(i,i,j,j),null);
    }
}