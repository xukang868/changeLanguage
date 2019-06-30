package com.xiaohan.languetest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xiaohan on 2019/6/30
 * Describe:
 */
public class OtherActivity extends Activity {
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_other);
        findViewById(R.id.finsh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        test = findViewById(R.id.textView);
        test.setText(getString(R.string.test));
    }
}
