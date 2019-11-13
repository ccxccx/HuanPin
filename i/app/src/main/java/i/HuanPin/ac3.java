package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Statement;

public class ac3 extends Activity implements View.OnClickListener
{
	Button b,b2,b3,b4,b5,b6;
	Statement s=ac.s;TextView t;int i;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
        l.addView(b=new Button(this));b.setText("添加商店");b.setOnClickListener(this);
        l.addView(b2=new Button(this));b2.setText("我的商店");b2.setOnClickListener(this);
		l.addView(b3=new Button(this));b3.setText("商店列表");b3.setOnClickListener(this);
		l.addView(b4=new Button(this));b4.setText("搜索拼单");b4.setOnClickListener(this);
		l.addView(b5=new Button(this));b5.setText("我的拼单");b5.setOnClickListener(this);
		l.addView(b6=new Button(this));b6.setText("我的地址");b6.setOnClickListener(this);
        l.addView(t=new TextView(this));t.setTextColor(0xffff0000);t.setGravity(Gravity.CENTER);
	}
	public void onClick(View v)
	{
		if(v==b)startActivity(new Intent(ac3.this,ac4.class));
		else if(v==b2)startActivity(new Intent(ac3.this,ac5.class));
		else if(v==b3)startActivity(new Intent(ac3.this,ac7.class));
		else if(v==b4)startActivity(new Intent(ac3.this,ac9.class));
		else if(v==b5)startActivity(new Intent(ac3.this,ac12.class));
		else if(v==b6)startActivity(new Intent(ac3.this,ac11.class));
	}
}
