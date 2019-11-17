package i.HuanPin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Statement;

public class ac2 extends Activity implements View.OnClickListener
{
    EditText e,e2,e3,e4;Button b;TextView t;int i;
    Statement s=ac.s;String u;PasswordTransformationMethod p=ac.p;
    Handler h=new Handler()
    {
        public void handleMessage(Message m){t.setText(u);}
    };
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
        ImageView i=new ImageView(this);i.setImageResource(R.drawable.i);l.addView(i);
        l.addView(e=new EditText(this));e.setHint("请输入账号");
        l.addView(e2=new EditText(this));e2.setHint("请输入密码");
		l.addView(e3=new EditText(this));e3.setHint("请确认密码");
        e2.setTransformationMethod(p);e3.setTransformationMethod(p);
		l.addView(e4=new EditText(this));e4.setHint("请输入联系方式");
		l.addView(b=new Button(this));b.setText("注册");b.setOnClickListener(this);
        l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
    }
    public void onClick(View v)
    {
        new Thread(new Runnable()
        {
            public void run()
            {try{
                String a=e2.getText()+"",b=e3.getText()+"";
                if(a.equals(b))
                {
                    try{
                        s.execute("insert into t1 values('"+e.getText()+"','"+a+"','"+e4.getText()+"')");
                        startActivity(new Intent(ac2.this,ac.class));
                    }catch(Exception e)
                    {
                        f("该账号已被注册！");
                    }
                }
                else f("两次输入的密码必须相同！");
            }catch(Exception e){e.printStackTrace();}}
        }).start();
    }
    void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
}
