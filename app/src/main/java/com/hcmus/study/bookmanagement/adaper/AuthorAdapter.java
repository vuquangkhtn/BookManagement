package com.hcmus.study.bookmanagement.adaper;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hcmus.study.bookmanagement.R;
import com.hcmus.study.bookmanagement.fragment.MoreInfoFragment;
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
        final Author author = itemList.get(position);
        holder.tvAuthorName.setText(author.name);
        holder.tvNation.setText(author.nation);
        holder.tvBookNum.setText(String.valueOf(author.bookList.size()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoreInfoFragment.show(((FragmentActivity) mContext).getSupportFragmentManager(), author, "author");
            }
        });
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
        public TextView tvAuthorName;
        public TextView tvNation;
        public TextView tvBookNum;
        public AuthorHolder(View itemView) {
            super(itemView);
            tvAuthorName = itemView.findViewById(R.id.tv_author_name);
            tvBookNum = itemView.findViewById(R.id.tv_book_num);
            tvNation = itemView.findViewById(R.id.tv_nation);
        }
    }
}
