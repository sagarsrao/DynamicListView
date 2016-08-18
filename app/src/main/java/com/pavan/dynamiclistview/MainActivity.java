package com.pavan.dynamiclistview;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView lv;
	EditText et;

	ArrayList<Model> modelList;
	CustomAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lv = (ListView) findViewById(R.id.lv);
		et = (EditText) findViewById(R.id.et);

		modelList = new ArrayList<Model>();
		adapter = new CustomAdapter(getApplicationContext(), modelList);

		lv.setAdapter(adapter);
	}

	@SuppressLint("NewApi")
	public void addbtn(View v) {
		String name = et.getText().toString();

		if (name.isEmpty()) {
			Toast.makeText(getApplicationContext(), "Plz enter Values",
					Toast.LENGTH_SHORT).show();
		} else {
			Model md = new Model(name);
			modelList.add(md);
			adapter.notifyDataSetChanged();
			et.setText("");
		}
	}
}
