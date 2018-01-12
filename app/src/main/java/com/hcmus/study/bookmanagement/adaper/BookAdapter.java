package com.hcmus.study.bookmanagement.adaper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.hcmus.study.bookmanagement.R;
import com.hcmus.study.bookmanagement.model.Book;

import java.util.List;

/**
 * Created by CPU10584-local on 12-Jan-18.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {
    private Context mContext;
    private List<Book> itemList;


    public BookAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book_list, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        final Book book = itemList.get(position);
        if(book.isFavor) {
            holder.cbFavor.setChecked(true);
        } else {
            holder.cbFavor.setChecked(false);
        }
        holder.cbFavor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    book.isFavor = true;
                } else {
                    book.isFavor = false;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }


    public void setData(List<Book> data) {
        this.itemList = data;
        notifyDataSetChanged();
    }

    public class BookHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvAuthor;
        public TextView tvContent;
        public CheckBox cbFavor;
        public BookHolder(View itemView) {
            super(itemView);
            cbFavor = itemView.findViewById(R.id.cb_star);
        }
    }
}
