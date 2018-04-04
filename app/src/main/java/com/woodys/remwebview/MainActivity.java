package com.woodys.remwebview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText urlView=(EditText)findViewById(R.id.et_url);
        urlView.setText("file:///android_asset/index.html");
        findViewById(R.id.bt_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlView.getText().toString();
                if(!TextUtils.isEmpty(url)) {
                    Intent intent = new Intent(getBaseContext(), WebViewActivity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);
                }else {
                    Toast.makeText(getBaseContext(),"url 不能为空！",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
