package org.vkedco.mobicom.web_view_act_01;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	Button mBtnStaticDisplay = null;
	Button mBtnDynamicDisplay = null;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnStaticDisplay = (Button) this.findViewById(R.id.btnStaticDisplay);
        mBtnDynamicDisplay = (Button) this.findViewById(R.id.btnDynamicHTML);
        mBtnStaticDisplay.setOnClickListener(this);
        mBtnDynamicDisplay.setOnClickListener(this); 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		Intent i = null;
		int id = v.getId();
		switch ( id ) {
		case R.id.btnStaticDisplay:
			i = new Intent(this, WebViewAct.class);
			i.putExtra("html_type", "static");
			this.startActivity(i);
			break;
		case R.id.btnDynamicHTML:
			i = new Intent(this, WebViewAct.class);
			i.putExtra("html_type", "dynamic");
			this.startActivity(i);
		default: return;
		}
		
	}
    
}
