package i.HuanPin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ac extends Activity implements View.OnClickListener
{
    EditText e,e2;Button b,b2;TextView t;int i;static Statement s;String u;
    static PasswordTransformationMethod p;static String a;
    static Connection c;
    Handler h=new Handler()
    {
        public void handleMessage(Message m){t.setText(u);}
    };
    protected void onCreate(Bundle savedInstanceState)
    {try{
        super.onCreate(savedInstanceState);p=PasswordTransformationMethod.getInstance();
        LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
        l.addView(e=new EditText(this));l.addView(e2=new EditText(this));
        l.addView(b=new Button(this));l.addView(b2=new Button(this));
        e.setHint("请输入账号");e2.setHint("请输入密码");e2.setTransformationMethod(p);
        b.setText("登录");b2.setText("注册");
        b.setOnClickListener(this);b2.setOnClickListener(this);
        l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
        Thread t=new Thread(new Runnable()
        {
            public void run()
            {try{
                Class.forName("com.mysql.jdbc.Driver");
                c=DriverManager.getConnection("jdbc:mysql://112.74.89.58:39127/huanpin?useSSL=false","root","ccx");
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