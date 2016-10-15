package com.example.vishalnagarale.loginpopup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button)findViewById(R.id.loginBtn);
        linearLayout = (LinearLayout) findViewById(R.id.activity_main);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.login,null);

                popupWindow = new PopupWindow(container,400,400,true);
                popupWindow.showAtLocation(linearLayout, Gravity.NO_GRAVITY,500,500);

                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
            }
        });
    }
}
