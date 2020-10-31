package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
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
    private int currentDisplayedImage = 0 ;
    ArrayList<Integer> imageIDs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews() ;
        imageIDs = new ArrayList<>();
        imageIDs.add(R.drawable.android1) ;
        imageIDs.add(R.drawable.android2);
        imageIDs.add(R.drawable.arch);
        imageIDs.add(R.drawable.arch2);
        // setting up the adapter... and layout manager for recycler view ...
        adapter = new RecyclerViewAdapter(this,this,imageIDs);
        list.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        list.setAdapter(adapter);



        updateMainViewBasedOnCurrentVisiblePosition() ;
        // setting up the handlers for the next and previous buttons...

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// previous btn...
                if(currentDisplayedImage == 0){
                    currentDisplayedImage = imageIDs.size()-1  ;
                    updateMainViewBasedOnCurrentVisiblePosition();
                }else {
                    currentDisplayedImage-- ;
                    updateMainViewBasedOnCurrentVisiblePosition();
                }


/*
                if(currentDisplayedImage < 0  ) {
                    currentDisplayedImage = imageIDs.size()-1 ;
                    updateMainViewBasedOnCurrentVisiblePosition();
                }else if (currentDisplayedImage ==0) {
                    updateMainViewBasedOnCurrentVisiblePosition();
                } else {
                    if (currentDisplayedImage >0 && currentDisplayedImage< imageIDs.size()) {
                        // validation that the position is part of the list ... (just to be sure).
                        currentDisplayedImage-- ;
                        updateMainViewBasedOnCurrentVisiblePosition();
                    }

                }
*/
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentDisplayedImage == imageIDs.size() -1 ) {
                    currentDisplayedImage= 0 ;
                    updateMainViewBasedOnCurrentVisiblePosition();
                } else {
                    currentDisplayedImage++ ;
                    updateMainViewBasedOnCurrentVisiblePosition();
                }

/*
                if(currentDisplayedImage == imageIDs.size()-1 ) {
                    // we reached the end of the list or we surpassed it... or the current position is less than zero...
                    // so we set the the first image and we show it ...
                    updateMainViewBasedOnCurrentVisiblePosition();
                    currentDisplayedImage = 0 ;
                }else {
                    currentDisplayedImage++ ;
                }
                updateMainViewBasedOnCurrentVisiblePosition();
*/
            }
        });


    }




    private void updateMainViewBasedOnCurrentVisiblePosition(){
        // if the current position is between 0 and images.size()-1   we can get that image ...
            imageView.setImageDrawable(getDrawable(imageIDs.get(currentDisplayedImage)));
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