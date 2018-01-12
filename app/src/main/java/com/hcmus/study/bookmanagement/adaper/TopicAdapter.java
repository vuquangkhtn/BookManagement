package com.hcmus.study.bookmanagement.adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.hcmus.study.bookmanagement.R;
import com.hcmus.study.bookmanagement.model.Topic;

import java.util.List;

/**
 * Created by CPU10584-local on 12-Jan-18.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicHolder> {
    private Context mContext;
    private List<Topic> itemList;

    private AdapterView.OnItemClickListener onItemClickListener;

    public TopicAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public TopicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_topic_list, parent, false);
        return new TopicHolder(view);
    }

    @Override
    public void onBindViewHolder(TopicHolder holder, int position) {
        Topic topic = itemList.get(position);
        holder.tvText.setText(topic.getName());

    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }

    public void setData(List<Topic> data) {
        this.itemList = data;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class TopicHolder extends RecyclerView.ViewHolder {
        public TextView tvText;
        public TopicHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_name);
        }
    }


}
