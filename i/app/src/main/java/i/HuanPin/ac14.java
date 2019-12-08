package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ac14 extends Activity implements View.OnClickListener
{
	EditText e,e2;Button b,b2;TextView t;int i;String u,c,d;
	Statement s=ac.s;
	Handler h=new Handler()
	{
		public void handleMessage(Message m){t.setText(u);}
	};
	ImageView i2;Bitmap g=ac3.c;
	protected void onCreate(Bundle savedInstanceState)
	{try{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		Thread t3=new Thread(new Runnable()
		{
			public void run()
			{try{
				ResultSet r=s.executeQuery("select * from t1 where 账号='"+ac.a+"'");
				for(;r.next();)
				{
					c=r.getString(2);
					d=r.getString(3);
				}
				r.close();
			}catch(Exception e){e.printStackTrace();}}
		});
		t3.start();
		t3.join();
		LinearLayout l4=new LinearLayout(this);l.addView(l4,-1,ac.w/4);l4.setBackgroundColor(0xffede387);
		i2=new ImageView(this);
		i2.setImageBitmap(g);
		l4.addView(i2,ac.w*g.getWidth()/g.getHeight()/4,-1);
		TextView t2=new TextView(this);
		l4.addView(t2,new LinearLayout.LayoutParams(0,-1,1));
		t2.setText("账号："+ac.a);t2.setGravity(Gravity.CENTER);
		LinearLayout l3=new LinearLayout(this);l.addView(l3);
		LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(0,-2,1),p2=new LinearLayout.LayoutParams(0,-2,4);
		l3.addView(t2=new TextView(this),p);t2.setText("密码：");
		l3.addView(e=new EditText(this),p2);e.setText(c);
		l.addView(l3=new LinearLayout(this));
		l3.addView(t2=new TextView(this),p);t2.setText("联系方式：");
		l3.addView(e2=new EditText(this),p2);e2.setText(d);
		l.addView(b2=new bu(this,"选择头像"));b2.setOnClickListener(this);
		l.addView(b=new bu(this,"修改信息"));b.setOnClickListener(this);
		l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
	}catch(Exception e){e.printStackTrace();}}
	public void onClick(View v)
	{try{
		if(v==b)
		{
			Thread t=new Thread(new Runnable()
			{
				public void run()
				{try{
					try{
						s.execute("update t1 set 密码='"+e.getText()+"',联系方式='"+e2.getText()+"',头像='"+ac.b2s(ac3.c=g)+"' where 账号='"+ac.a+"'");
						f("信息修改成功！");
					}catch(Exception e){}
				}catch(Exception e){e.printStackTrace();}}
			});
			t.start();t.join();
		}
		else startActivityForResult(new Intent(Intent.ACTION_PICK).setType( "image/*"),0);
	}catch(Exception e){e.printStackTrace();}}
	protected void onActivityResult(int requestCode,int resultCode,Intent i)
	{try{
		Cursor c=getContentResolver().query(i.getData(),null,null,null,null);
		c.moveToNext();
		String a=c.getString(c.getColumnIndex(MediaStore.Images.Media.DATA));
		Bitmap f=BitmapFactory.decodeFile(a);
		i2.setImageBitmap(g=ThumbnailUtils.extractThumbnail(f,f.getWidth()*200/f.getHeight(),200));
		i2.setLayoutParams(new LinearLayout.LayoutParams(ac.w*g.getWidth()/g.getHeight()/4,-1));
		//不能用in.reset();，因为FileInputStream不支持reset();，小心!!!!!!!!!
		c.close();
	}catch(Exception e){e.printStackTrace();}}
	void f(String s){u=++i+"："+s;h.sendEmptyMessage(0);}
}