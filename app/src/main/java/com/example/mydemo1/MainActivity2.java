package com.example.mydemo1;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {


    ArrayList<Integer > mImageUrls = new ArrayList<Integer>();
    ArrayList<String> personNames = new ArrayList<String>();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initImageBitmaps();
    }



    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");


        mImageUrls.add(R.drawable.c);
        personNames.add("C Programming");

        mImageUrls.add(R.drawable.java);
        personNames.add("java");

        mImageUrls.add(R.drawable.php);
        personNames.add("PHP");

        mImageUrls.add(R.drawable.python);
        personNames.add("Python");

        mImageUrls.add(R.drawable.jscript);
        personNames.add("Java Script");

        mImageUrls.add(R.drawable.angular);
        personNames.add("Angular");

        mImageUrls.add(R.drawable.react);
        personNames.add("React");

        mImageUrls.add(R.drawable.node);
        personNames.add("Node");


        initRecyclerView();

    }
    private void initRecyclerView(){

        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        CustomAdapter customAdapter = new CustomAdapter(this, mImageUrls, personNames);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

}

