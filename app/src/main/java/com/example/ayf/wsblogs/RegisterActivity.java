package com.example.ayf.wsblogs;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AYF on 2018/11/25.
 */
public class RegisterActivity  extends AppCompatActivity {
    TextView tv,to_login;
    ImageView del,del2,del3;
    EditText pwd_edt,user_edt,phone_edt,code_edt;
    Button register_btn,code_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        tv = (TextView) findViewById(R.id.app_title);
        to_login = (TextView)findViewById(R.id.to_login);
        //“温商博客”设置自定义的字体
        Typeface face = Typeface.createFromAsset(getAssets(),"WenYue-XinQingNianTi-NC-W8.ttf");
        tv.setTypeface(face);
        pwd_edt = (EditText)findViewById(R.id.pwd_register);
        user_edt = (EditText)findViewById(R.id.user_edt_register);
        phone_edt = (EditText)findViewById(R.id.phone_edt);
        code_edt = (EditText)findViewById(R.id.code_edt);
        register_btn = (Button)findViewById(R.id.register_btn);
        register_btn.setEnabled(false);//设置按钮不可被点击
        code_btn = (Button)findViewById(R.id.code_btn);
        del = (ImageView)findViewById(R.id.img_delete1);
        del2 = (ImageView)findViewById(R.id.img_delete2);
        del3 = (ImageView)findViewById(R.id.img_delete3);

        //用户输入框设置变化监听
        user_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                user_edt.setHint("你的昵称");//输入前显示提示信息
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                user_edt.setHint(null);//如果有输入将提示信息删掉
                //如果用户框和密码框手机号码框满足都有数据 将注册按钮背景设置为深蓝 并且可以被点击
                if (!(pwd_edt.getText().toString().isEmpty()||phone_edt.getText().toString().isEmpty())){
                    register_btn.setBackgroundResource(R.drawable.darkblue_border_radius);
                    register_btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                user_edt.setHint("你的昵称");//输入后显示提示信息（不为空不显示）
                //如果用户框和密码框不满足都有数据 将注册按钮背景设置为浅蓝 并且不可被点击
                if ((user_edt.getText().toString().isEmpty())||pwd_edt.getText().toString().isEmpty()||phone_edt.getText().toString().isEmpty()){
                    register_btn.setBackgroundResource(R.drawable.wathet_border_radius);
                    register_btn.setEnabled(false);
                }
            }
        });
        //用户输入框获取失去焦点事件监听
        user_edt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    del.setVisibility(View.VISIBLE);//设置删除图片可见
                }else{
                    del.setVisibility(View.INVISIBLE);//设置删除图片不可见
                }
            }
        });

        //密码输入框设置同上功能的监听
        pwd_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                pwd_edt.setHint("密码");//如果没有输入显示提示信息
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pwd_edt.setHint(null);//如果有输入将提示信息删掉
                //如果用户框和密码框手机号码框满足都有数据 将注册按钮背景设置为深蓝 并且可以被点击
                if (!(user_edt.getText().toString().isEmpty()||phone_edt.getText().toString().isEmpty())){
                    register_btn.setBackgroundResource(R.drawable.darkblue_border_radius);
                    register_btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                pwd_edt.setHint("密码");//如果没有输入显示提示信息
                //如果用户框和密码框不满足都有数据 将注册按钮背景设置为浅蓝 并且不可被点击
                if ((user_edt.getText().toString().isEmpty())||pwd_edt.getText().toString().isEmpty()||phone_edt.getText().toString().isEmpty()){
                    register_btn.setBackgroundResource(R.drawable.wathet_border_radius);
                    register_btn.setEnabled(false);
                }
            }
        });

        //密码输入框获取失去焦点事件监听
        pwd_edt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    del3.setVisibility(View.VISIBLE);
                }else{
                    del3.setVisibility(View.INVISIBLE);
                }
            }
        });

        phone_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                phone_edt.setHint("手机号码");//如果没有输入显示提示信息
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phone_edt.setHint(null);//如果有输入将提示信息删掉
                //如果用户框和密码框手机号码框满足都有数据 将注册按钮背景设置为深蓝 并且可以被点击
                if (!(user_edt.getText().toString().isEmpty()||pwd_edt.getText().toString().isEmpty())||phone_edt.getText().toString().isEmpty()){
                    register_btn.setBackgroundResource(R.drawable.darkblue_border_radius);
                    register_btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                phone_edt.setHint("手机号码");//如果没有输入显示提示信息
                //如果用户框和密码框不满足都有数据 将注册按钮背景设置为浅蓝 并且不可被点击
                if ((user_edt.getText().toString().isEmpty())||pwd_edt.getText().toString().isEmpty()||phone_edt.getText().toString().isEmpty()){
                    register_btn.setBackgroundResource(R.drawable.wathet_border_radius);
                    register_btn.setEnabled(false);
                }
            }
        });

        //手机号码输入框获取失去焦点事件监听
        phone_edt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    del2.setVisibility(View.VISIBLE);
                }else{
                    del2.setVisibility(View.INVISIBLE);
                }
            }
        });
        //删除图片设置监听
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_edt.setText("");//删除输入框中的内容
            }
        });
        //删除图片设置监听
        del2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone_edt.setText("");//删除输入框中的内容
            }
        });
        //删除图片设置监听
        del3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd_edt.setText("");//删除输入框中的内容
            }
        });

        //注册按钮设置监听(未完成)
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //点击注册 跳转注册页面
        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginAcitivity.class);
                startActivity(intent);
            }
        });
    }

}
