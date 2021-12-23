package com.example.work5_5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        initFragmentLast();
    }

    private void initFragmentLast() {
        getSupportFragmentManager().beginTransaction().add(R.id.containerThird, new BlankFragmentThird()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.containerFourth, new BlankFragmentFourth()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.containerFifth, new BlankFragmentFifth()).commit();
        transaction = manager.beginTransaction().add(R.id.containerSecond, new BlankFragmentSecond());
        transaction.commit();
    }

    public void onClickButtonFragment (View view) {
        EditText editText = (EditText) findViewById(R.id.text);
        TextView textView = (TextView) findViewById(R.id.reallyTextView);
        textView.setText(editText.getText());
        replaceFragment();
        checkImage();
    }
    private void checkImage() {
        ImageView imageView = (ImageView) findViewById(R.id.logoImage);
        if (!check) imageView.setImageResource(R.drawable.ic_launcher_man);
        else imageView.setImageResource(R.drawable.ic_launcher);
    }

    private void  replaceFragment() {
        if (!check) {
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFourth, new BlankFragmentFifth()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFifth, new BlankFragmentFourth()).commit();
            check = true;
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFourth, new BlankFragmentFourth()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFifth, new BlankFragmentFifth()).commit();
            check = false;
        }
    }
}