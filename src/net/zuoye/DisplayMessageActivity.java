/**
 * @author �����
 */
package net.zuoye;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		Intent intent = getIntent();//����intent
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);//����message
		
	    // ����һ��textView
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(message);

	    // ����textview
	    setContentView(textView);
	}

}
