package com.abheri.bhajane;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class BajanePageAdapter extends RecyclerView.Adapter<BajanePageAdapter.ViewHolder>{
    private BhajaneData[] listdata;
    Context context;

    String htmlFrontTags = "<html><body>";
    String htmlBackTags = "</body></html>";

    // RecyclerView recyclerView;
    public BajanePageAdapter(BhajaneData[] listdata, Context con) {
        this.listdata = listdata;
        context = con;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View bpage= layoutInflater.inflate(R.layout.bhajane_page, parent, false);
        ViewHolder viewHolder = new ViewHolder(bpage);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final BhajaneData myListData = listdata[position];

        String content = htmlFrontTags+ myListData.getContent()+ htmlBackTags;

        holder.textView.setText(myListData.getTitle());
        holder.webView.loadData(content, "text/html; charset=UTF-8", null);
        holder.relativeLayout.setBackgroundColor(myListData.getColorFilter());
        holder.swipeTextView.setText("<<< Swipe Here >>>");

        holder.webView.setVerticalScrollBarEnabled(false);
        //holder.webView.getSettings().setBuiltInZoomControls(true);

        holder.webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"click on item: " + position,Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView swipeTextView;
        public WebView webView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.bpTextView);
            this.swipeTextView = (TextView) itemView.findViewById(R.id.swipeTextView);
            this.webView = (WebView) itemView.findViewById(R.id.bpWebView);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.bpRelativeLayout);
        }
    }
}