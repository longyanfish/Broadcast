package broadcast.com.broadcastreceiver;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//广播接收器的APP，这里是注册广播接收器，指定只接收标志为什么的广播接收器
public class MainActivity extends AppCompatActivity {
public static String ACTION="来自另一个APP";
NewBroadcastReceiver newReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //生成广播接收器对象
        newReceiver=new NewBroadcastReceiver(MainActivity.this);
        //广播过滤器
        IntentFilter intentFilter=new IntentFilter();
        //过滤标志action,只接收这样action的广播，其他不接收,和广播发送方的action必须一模一样才能接收到
        intentFilter.addAction(ACTION);
        //注册广播接收器
        registerReceiver(newReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //动态注册的广播接收器记得一定要注销掉，否则会内存泄漏
        unregisterReceiver(newReceiver);
    }
}
