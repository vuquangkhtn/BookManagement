package com.hcmus.study.bookmanagement.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.hcmus.study.bookmanagement.R;
import com.hcmus.study.bookmanagement.adaper.BookAdapter;
import com.hcmus.study.bookmanagement.model.Book;
import com.hcmus.study.bookmanagement.model.BookList;

public class BookListFragment extends DialogFragment {
    private static final String TAG = "BookListFragment";

    ImageView imvBack;
    RecyclerView rvBookList;

    BookAdapter mAdapter;

    public static void show(FragmentManager fm, BookList bookList) {
        BookListFragment dialog = newInstance(bookList);
        dialog.show(fm, TAG);
    }

    private static BookListFragment newInstance(BookList bookList) {
        Bundle args = new Bundle();
        args.putSerializable("data", bookList);
        BookListFragment dialog = new BookListFragment();
        dialog.setArguments(args);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getContext(), R.style.DialogNoAnimation);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_book, null);
        init(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }
    }

    private void init(View view) {

        Bundle args = getArguments();
        BookList bookList = (BookList) args.getSerializable("data");

        imvBack = (ImageView) view.findViewById(R.id.imv_navi_back);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissAllowingStateLoss();//exit
            }
        });

        rvBookList = (RecyclerView) view.findViewById(R.id.rv_book);
        rvBookList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new BookAdapter(getContext());
        rvBookList.setAdapter(mAdapter);
        mAdapter.setData(bookList.getListBook());

    }

}
