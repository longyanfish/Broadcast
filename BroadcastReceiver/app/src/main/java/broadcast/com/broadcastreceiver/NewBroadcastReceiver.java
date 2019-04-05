package broadcast.com.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
//接收到广播以后就会自动回调这个类里的onReceive()方法
public class NewBroadcastReceiver extends BroadcastReceiver {
    Context context;
    public NewBroadcastReceiver(Context context){
        this.context=context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction()!=null){
            //判断广播的标志是否一样，action内容这里是自己定义的
            TextUtils.equals(intent.getAction(),MainActivity.ACTION);
            Log.d("TAG",intent.getAction());
            //取出广播信息
            CharSequence msg=intent.getStringExtra("11");
            Toast.makeText(context.getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        }
    }
}
