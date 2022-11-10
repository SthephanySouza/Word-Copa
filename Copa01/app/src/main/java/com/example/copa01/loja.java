package com.example.copa01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class loja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja);

        androidx.cardview.widget.CardView bt = (androidx.cardview.widget.CardView)findViewById(R.id.cardview_lojapramenu);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(loja.this, menu.class);
                startActivity(it);

            }
        });
    }
}