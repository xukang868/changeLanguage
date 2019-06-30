package com.xiaohan.languetest;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text;
    private ImageView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        show = findViewById(R.id.show);
        findViewById(R.id.chinese).setOnClickListener(this);
        findViewById(R.id.english).setOnClickListener(this);
        findViewById(R.id.russian).setOnClickListener(this);
        findViewById(R.id.switchActivity).setOnClickListener(this);

        text.setText(getString(R.string.test));
        show.setBackgroundResource(R.mipmap.language);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chinese:
//                SwitchSystemLanguageUtils.changeLangue(Locale.CHINA);
                switchLanguage(Locale.SIMPLIFIED_CHINESE);
                break;
            case R.id.english:
//                SwitchSystemLanguageUtils.changeLangue(Locale.ENGLISH);
                switchLanguage(Locale.ENGLISH);
                break;
            case R.id.russian:
                Locale locale = new Locale("ru");
                switchLanguage(new Locale(locale.getLanguage()));
//                SwitchSystemLanguageUtils.changeLangue(locale);
                break;
            case R.id.switchActivity:
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
                break;
        }
        text.setText(getString(R.string.test));
        show.setBackgroundResource(R.mipmap.language);
    }


    /**
     * 切换语言
     *
     * @param locale
     */

    private void switchLanguage(Locale locale) {
        //设置应用语言类型
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        config.setLocale(locale);
        resources.updateConfiguration(config, dm);
        //更新语言后，destroy当前页面，重新绘制
        finish();
        Intent it = new Intent(MainActivity.this, MainActivity.class);
        //清空任务栈确保当前打开activit为前台任务栈栈顶
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(it);
    }


}
