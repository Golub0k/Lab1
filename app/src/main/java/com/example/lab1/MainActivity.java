package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button vk_link = (Button) findViewById(R.id.vk_link);
        Button go_to_2 = (Button) findViewById(R.id.go_to_2);
        String link = "https://vk.com/";
        if (getIntent().hasExtra("name")) {
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            TextView text2 = (TextView) findViewById(R.id.textView2);
            if (!(name.isEmpty())) {
                if (Locale.getDefault().getLanguage() == "ru")
                {
                    text2.setText(name + ", Это ваша ссылка на ВК страницу");
                }
                else{
                text2.setText(name + ", this is your VK-link");}
                text2.setVisibility(View.VISIBLE);
            }
        }
        if (getIntent().hasExtra("link")) {
            Intent intent = getIntent();
            link = "https://vk.com/"+ intent.getStringExtra("link");

            if (!(link.isEmpty())) {

                vk_link.setVisibility(View.VISIBLE);
            }

        }
        View.OnClickListener onClikGoTo2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                startActivity(intent);
            }
        };

        go_to_2.setOnClickListener(onClikGoTo2);

        String finalLink = link;
        vk_link.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse(finalLink) );
                startActivity(intent);
            }
        });


    }
}