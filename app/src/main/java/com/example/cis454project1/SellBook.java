package com.example.cis454project1;
//package com.google.firebase.quickstart.database.java;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.firebase.database.DatabaseReference;

import androidx.appcompat.app.AppCompatActivity;


public class SellBook extends AppCompatActivity {

    private static final String TAG = "SellBookActivity";

    private DatabaseReference mDatabase;
    private EditText bookTitle;
    private EditText bookAuthor;
    private EditText bookISBN;
    private EditText bookPrice;
    private Button confirmListing;
    String title;
    String author;
    String isbn;
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_book);
       // FirebaseDatabase database = FirebaseDatabase.getInstance();
       // DatabaseReference myRef = database.getReference("message");
        //mDatabase = FirebaseDatabase.getInstance().getReference();
       // myRef.setValue("Hello, World!");

        bookTitle = (EditText) findViewById(R.id.sellbooktitle);
        bookAuthor = (EditText) findViewById(R.id.sellbookauthor);
        bookISBN = (EditText) findViewById(R.id.sellbookisbn);
        bookPrice = (EditText) findViewById(R.id.sellbookprice);
        confirmListing = (Button) findViewById(R.id.confirmlisting);



       /* myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });*/
    }
    public void confirmListing(View view) {

        // inflate the layout of the popup window


    }
    public void onTouch(View view) {
        boolean cancel = false;
        View focusView = null;

        title = bookTitle.getText().toString();
        author = bookAuthor.getText().toString();
        isbn = bookISBN.getText().toString();
        price = bookPrice.getText().toString();

        bookTitle.setError(null);
        bookAuthor.setError(null);
        bookISBN.setError(null);
        bookPrice.setError(null);

            if (TextUtils.isEmpty(title)) {
                bookTitle.setError(getString(R.string.error_field_required));
                focusView = bookTitle;
                cancel= true;
            }
            if (TextUtils.isEmpty(author)) {
                bookAuthor.setError(getString(R.string.error_field_required));
                focusView = bookAuthor;
                cancel = true;
            }
            if (TextUtils.isEmpty(isbn)) {
                bookISBN.setError(getString(R.string.error_field_required));
                focusView = bookISBN;
                cancel = true;
            }
            if (TextUtils.isEmpty(price)) {
                bookPrice.setError(getString(R.string.error_field_required));
                focusView = bookPrice;
                cancel = true;
            }
            if (cancel) {
                focusView.requestFocus();
            }
            else {
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.confirmlisting, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = false; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken

                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        Intent intent = new Intent(SellBook.this, MainActivity.class);
                        startActivity(intent);
                        return true;
                    }
                });

            }
        }
    }

