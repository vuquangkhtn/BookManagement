package com.hcmus.study.bookmanagement.adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hcmus.study.bookmanagement.R;
import com.hcmus.study.bookmanagement.model.Author;

import java.util.List;

/**
 * Created by CPU10584-local on 12-Jan-18.
 */

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorHolder> {

    private Context mContext;
    private List<Author> itemList;

    public AuthorAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public AuthorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_author_list, parent, false);
        return new AuthorHolder(view);
    }

    @Override
    public void onBindViewHolder(AuthorHolder holder, int position) {

    }

    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }


    public void setData(List<Author> data) {
        this.itemList = data;
        notifyDataSetChanged();
    }

    public class AuthorHolder extends RecyclerView.ViewHolder {
        public AuthorHolder(View itemView) {
            super(itemView);
        }
    }
}