package broadcast.com.broadcastapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//此程序是广播发送方
public class MainActivity extends AppCompatActivity {

    Button btnSendBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSendBroadcast=(Button)findViewById(R.id.btnSendBroadcast);
    }
    public void onClick(View view){
        switch(view.getId()){
            case R.id.btnSendBroadcast:
                Intent intent=new Intent();
                //action是发送方和接收方约定的一个相同的标志，只要一模一样就可以区分某条广播
                intent.setAction("来自另一个APP");
                //广播字符串信息
                intent.putExtra("11","乐观看待自己是美好的品质！");
                sendBroadcast(intent);//广播发送出去
        }
    }

}
