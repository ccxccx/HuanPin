package i.HuanPin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class sy extends Activity
{
	Button b;TextView t;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		LinearLayout l=new LinearLayout(this);setContentView(l);l.setOrientation(LinearLayout.VERTICAL);
        //l.addView(b=new Button(this));
        //b.setText("登录<br>1\n2&#10;3");
		l.addView(t=new TextView(this));
		Calendar c=Calendar.getInstance();
		t.setText("年: " + c.get(Calendar.YEAR)+"\n月: " + (c.get(Calendar.MONTH) + 1) + ""+"\n日: " + c.get(Calendar.DAY_OF_MONTH)
				+"\n时: " + c.get(Calendar.HOUR_OF_DAY)+"\n分: " + c.get(Calendar.MINUTE));
		
	}
}
