/**
 * @author �����
 */
package net.zuoye;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
        public final static String EXTRA_MESSAGE = "net.zuoye.MESSAGE";
        public final static String FRAGMENT_TAG="Tag";

    @SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        PromptInfoDialogFragment dlg=new PromptInfoDialogFragment(false);
        dlg.show(getFragmentManager(), FRAGMENT_TAG);
    }
    
    @SuppressLint("NewApi")
	@Override  
    public void onBackPressed() { 
        PromptInfoDialogFragment dlg=new PromptInfoDialogFragment(true);
        dlg.show(getFragmentManager(), FRAGMENT_TAG);
    }
    
    
    /** ��Ӧ��ť��� */
    public void sendMessage(View view) {
            Intent intent = new Intent(this, DisplayMessageActivity.class); // ���ù��췽�� ����һ��intent
            EditText editText = (EditText) findViewById(R.id.edit_message);//����Դedit_message��ֵ��editText����
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);//��message����intent��,����һ����ֵ��key:EXTRA_MESSAGE value:message
            startActivity(intent);
    }

    @SuppressLint({ "NewApi", "ValidFragment" })
	public class PromptInfoDialogFragment extends DialogFragment {
    	private boolean state;
    	/**
    	 * 
    	 * @param s ����ʹ����һ���Ի���trueΪ�˳��Ի���,falseΪ��ӭ�Ի���
    	 */
			PromptInfoDialogFragment(boolean s){
    			state = s;
            }
            
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            if (state==true){
            	builder.setTitle("�˳�").setMessage(R.string.hello_world)
                   	.setPositiveButton("�ţ��Ͻ��˳���", new DialogInterface.OnClickListener() {
                   		public void onClick(DialogInterface dialog, int id) {
                           // FIRE ZE MISSILES!
                               if (state==true) MainActivity.this.finish();
                       }
                   });
            	}else{
                	builder.setTitle("ע��").setMessage(R.string.hello_world)
                   	.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                   		public void onClick(DialogInterface dialog, int id) {
                           // FIRE ZE MISSILES!
                       }
                   });
            	}
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}