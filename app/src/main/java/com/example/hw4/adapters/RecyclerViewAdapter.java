package com.example.hw4.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw4.R;
import com.example.hw4.listeners.OnImageClickedListener;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private String TAG = RecyclerViewAdapter.class.getSimpleName();
    Context mContext ;
    ArrayList<Integer> imageIDs;
    private OnImageClickedListener listener ;


    public RecyclerViewAdapter(OnImageClickedListener listener ) {
        super();
        this.listener = listener ;
    }


    public RecyclerViewAdapter(Context mContext, OnImageClickedListener listener , ArrayList<Integer> imageIDs) {
        super();
        this.listener = listener ;
        this.imageIDs = imageIDs ;
        this.mContext = mContext ;
    }



/*
    public RecyclerViewAdapter(Context context , ArrayList<Integer> drawableImages) {
        this.mContext = context ;
        this.item = drawableImages ;
    }
*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null);
        ViewHolder holder = new ViewHolder(itemLayoutView , listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setImageID(imageIDs.get(position));
        holder.setPosition(position);
        Log.d(TAG ,"size : " + imageIDs.size()) ;
        holder.image.setImageDrawable(mContext.getDrawable(holder.getImageID()));

    }

    @Override
    public int getItemCount() {
        return imageIDs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private int imageID ;
        private int position;

        private ImageView image ;
        private OnImageClickedListener listener ;

        public ViewHolder(@NonNull View itemView , OnImageClickedListener listener) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.image);
            this.listener = listener ;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if(listener != null) {
                listener.onImageClicked(imageID , position);
            }
        }


        public int getImageID() {
            return this.imageID ;
        }

        public void setImageID(int imageID) {
            this.imageID = imageID ;
        }

        public void setPosition(int position){
            this.position= position ;
        }
    }




}
