package com.example.administrator.appclick;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public int count = 0;
    TextView textView;
    private Button button;


    BroadcastReceiver myBorReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            intent.getExtras().getString("name");//name
            textView.getText();//count

            button.setEnabled(false);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
    }



    @Override
    protected void onStart() {
        registerReceiver(myBorReceiver, new IntentFilter(CountService.NOTIFICATION));
        System.out.println("Start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("Resume");

        super.onResume();
    }

    @Override
    protected void onPause() {
        System.out.println("Pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("Stop");
        unregisterReceiver(myBorReceiver);
        super.onStop();
    }

    @Override
    protected void onRestart() {
        System.out.println("Restart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        System.out.println("Destroy");
        super.onDestroy();
    }



    public void onCounterClick(View view){
        if(count == 0)
            CountService.startActionBaz(this,"Jhonatan",String.valueOf(count));
        count++;
        //Toast.makeText(this,"Click count = "+count, Toast.LENGTH_LONG).show();
        textView.setText(String.valueOf(count));
    }
}
