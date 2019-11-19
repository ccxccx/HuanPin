package i.HuanPin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Statement;

public class ac3 extends Activity implements View.OnClickListener
{
	Button b,b2,b3,b4,b5,b6;Statement s=ac.s;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//*
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
		l.setBackgroundColor(0xffffffcc);
		ImageView i=new ImageView(this);i.setImageResource(R.drawable.i);l.addView(i,-1,ac.w/2);
        l.addView(b=new Button(this));b.setText("添加商店");b.setOnClickListener(this);
        l.addView(b2=new Button(this));b2.setText("我的商店");b2.setOnClickListener(this);
		l.addView(b3=new Button(this));b3.setText("商店列表");b3.setOnClickListener(this);
		l.addView(b4=new Button(this));b4.setText("搜索拼单");b4.setOnClickListener(this);
		l.addView(b5=new Button(this));b5.setText("我的拼单");b5.setOnClickListener(this);
		l.addView(b6=new Button(this));b6.setText("我的地址");b6.setOnClickListener(this);
		//*/
		/*
		setContentView(R.layout.l3);
		b=findViewById(R.id.b31);b2=findViewById(R.id.b32);b3=findViewById(R.id.b33);
		b4=findViewById(R.id.b34);b5=findViewById(R.id.b35);b6=findViewById(R.id.b36);
		b.setOnClickListener(this);b2.setOnClickListener(this);b3.setOnClickListener(this);
		b4.setOnClickListener(this);b5.setOnClickListener(this);b6.setOnClickListener(this);
		//*/
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
