package com.abheri.bhajane;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class BhajaneListAdapter extends RecyclerView.Adapter<BhajaneListAdapter.ViewHolder>{
    private BhajaneData[] listdata;
    Context context;

    // RecyclerView recyclerView;
    public BhajaneListAdapter(BhajaneData[] listdata, Context con) {
        this.listdata = listdata;
        context = con;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final BhajaneData myListData = listdata[position];
        holder.textView.setText(listdata[position].getTitle());
        holder.imageView.setImageResource(listdata[position].getImgId());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"click on item: "+myListData.getTitle(),Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(context, BhajaneDisplayActivity.class);
                myIntent.putExtra("PageSelected", position);
                context.startActivity(myIntent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.listTextView);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayout);
        }
    }
}