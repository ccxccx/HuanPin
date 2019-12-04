package i.HuanPin;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
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

import androidx.core.app.ActivityCompat;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ac2 extends Activity implements View.OnClickListener
{
    EditText e,e2,e3,e4;Button b,b2;TextView t;int i;
    Statement s=ac.s;String u;PasswordTransformationMethod p=ac.p;
    Handler h=new Handler()
    {
        public void handleMessage(Message m){t.setText(u);}
    };
    ImageView i2;InputStream in;
    protected void onCreate(Bundle savedInstanceState)
    {try{
        super.onCreate(savedInstanceState);
        //*
        LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
        l.setBackgroundColor(0xffffffcc);
        l.addView(e=new EditText(this));e.setHint("请输入账号");
        l.addView(e2=new EditText(this));e2.setHint("请输入密码");
		l.addView(e3=new EditText(this));e3.setHint("请确认密码");
        e2.setTransformationMethod(p);e3.setTransformationMethod(p);
		l.addView(e4=new EditText(this));e4.setHint("请输入联系方式");
        l.addView(b2=new Button(this));b2.setText("选择头像");b2.setOnClickListener(this);
        l.addView(i2=new ImageView(this),-1,ac.w/2);
		l.addView(b=new Button(this));b.setText("注册");b.setOnClickListener(this);
        l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
        Thread t=new Thread(new Runnable()
        {
            public void run()
            {try{
                ResultSet r=s.executeQuery("select 头像 from t1 where 账号=''");
                r.next();in=r.getBlob(1).getBinaryStream();r.close();
            }catch(Exception e){e.printStackTrace();}}
        });
        t.start();t.join();
        i2.setImageBitmap(BitmapFactory.decodeStream(in));in.reset();
        //*/
        /*
        setContentView(R.layout.l9);
        e2=findViewById(R.id.e21);e2=findViewById(R.id.e22);e3=findViewById(R.id.e23);e4=findViewById(R.id.e24);
        b9=findViewById(R.id.b21);t=findViewById(R.id.t21);
        b9.setOnClickListener(this);
        //*/
    }catch(Exception e){e.printStackTrace();}}
    public void onClick(View v)
    {
        //必须<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>和requestPermissions()一起使用才行
        //易错难发现!!!!!!!!!小心!!!!!!!!!
        if(v==b)ActivityCompat.requestPermissions(ac2.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
        else startActivityForResult(new Intent(Intent.ACTION_PICK).setType( "image/*"),0);
    }
    public void onRequestPermissionsResult(int requestCode,String[]permissions, int[]grantResults)
    {try{
        new Thread(new Runnable()
        {
            public void run()
            {try{
                String a=e2.getText()+"", b=e3.getText()+"";
                if(a.equals(b))
                {try{
                    PreparedStatement s2=ac.c.prepareStatement("insert into t1 values('"+e.getText()+"','"+a+"','"+e4.getText()+"',?)");
                    s2.setBlob(1,in);s2.execute();s2.close();
                    startActivity(new Intent(ac2.this,ac.class));
                }catch(Exception e)
                {
                    e.printStackTrace();
                    f("该账号已被注册！");
                }}
                else f("两次输入的密码必须相同！");
            }catch(Exception e){e.printStackTrace();}}
        }).start();
    }catch(Exception e){e.printStackTrace();}}
    protected void onActivityResult(int requestCode,int resultCode,Intent i)
    {try{
        Cursor c=getContentResolver().query(i.getData(),null,null,null,null);
        c.moveToNext();
        String a=c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
        i2.setImageBitmap(BitmapFactory.decodeStream(in=new FileInputStream(a)));
        //不能用in.reset();，因为FileInputStream不支持reset();，小心!!!!!!!!!
        in=new FileInputStream(a);c.close();
    }catch(Exception e){e.printStackTrace();}}
    void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
}
