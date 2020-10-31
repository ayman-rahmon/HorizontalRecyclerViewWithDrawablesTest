package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hw4.adapters.RecyclerViewAdapter;
import com.example.hw4.listeners.OnImageClickedListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnImageClickedListener {


    private ImageView imageView ;
    private Button previous , next ;
    private RecyclerViewAdapter adapter ;
    private RecyclerView list ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews() ;
        ArrayList<Integer> imageIDs = new ArrayList<>();
        imageIDs.add(R.drawable.android1) ;
        imageIDs.add(R.drawable.android2);
        imageIDs.add(R.drawable.arch);
        imageIDs.add(R.drawable.arch2);
        // setting up the adapter... and layout manager for recycler view ...
        adapter = new RecyclerViewAdapter(this,this,imageIDs);
        list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        list.setAdapter(adapter);

    }



    private void setUpViews() {
        imageView = (ImageView) findViewById(R.id.main_view);
        previous = (Button) findViewById(R.id.prev_btn);
        next = (Button)findViewById(R.id.next_btn);
        list = (RecyclerView) findViewById(R.id.list);
    }


    @Override
    public void onImageClicked(int imageID) {
        // when an image is pressed it will be displayed in the main view...
        imageView.setImageDrawable(getDrawable(imageID));


    }




}