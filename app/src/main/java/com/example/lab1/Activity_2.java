package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button back = (Button) findViewById(R.id.back);
        EditText input_link = (EditText) findViewById(R.id.input_link);
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        TextView text_with_name = (TextView) findViewById(R.id.text_with_name);
        View.OnClickListener onClikGoTo1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Activity_2.this, MainActivity.class);
                intent.putExtra("name", edit_name.getText().toString());
                intent.putExtra("link", input_link.getText().toString());
                startActivity(intent);
            }
        };

        back.setOnClickListener(onClikGoTo1);

        edit_name.setOnKeyListener(new View.OnKeyListener()
                                  {
                                      public boolean onKey(View v, int keyCode, KeyEvent event)
                                      {
                                          if(event.getAction() == KeyEvent.ACTION_DOWN &&
                                                  (keyCode == KeyEvent.KEYCODE_ENTER))
                                          {
                                              // сохраняем текст, введённый до нажатия Enter в переменную
                                              String strCatName = edit_name.getText().toString();
                                              text_with_name.setText("OK, "+ strCatName + ", now u can back");
                                              text_with_name.setVisibility(View.VISIBLE);
                                              return true;
                                          }
                                          return false;
                                      }
                                  }
        );
    }
}