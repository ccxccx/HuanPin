package i.HuanPin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class fr extends Fragment
{
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
		//R.layout.fragment1:fragment的layout.xml配置文件
		return inflater.inflate(R.layout.layout, container, false);
	}
}
