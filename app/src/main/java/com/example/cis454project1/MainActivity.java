package com.example.cis454project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buy = (Button) findViewById(R.id.buytextbook);
        Button sell = (Button) findViewById(R.id.selltextbook);
    }
    public void sellBook(View view){
        Intent intent = new Intent(this, SellBook.class);
        startActivity(intent);
    }
    public void buyBook(View view){
        Intent intent = new Intent(this, BuyBook.class);
        startActivity(intent);
    }
}
