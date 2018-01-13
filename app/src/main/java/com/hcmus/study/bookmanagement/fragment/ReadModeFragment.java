package com.hcmus.study.bookmanagement.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.hcmus.study.bookmanagement.R;
import com.hcmus.study.bookmanagement.model.Book;

/**
 * Created by CPU10584-local on 12-Jan-18.
 */

public class ReadModeFragment extends DialogFragment {
    private static final String TAG = "ReadModeFragment";

    ImageView imvBack;
    TextView tvContent;
    TextView tvTitle;
    TextView tvSection;

    public static void show(FragmentManager fm, Book book) {
        ReadModeFragment dialog = newInstance(book);
        dialog.show(fm, TAG);
    }

    private static ReadModeFragment newInstance(Book book) {
        Bundle args = new Bundle();
        args.putSerializable("data", book);
        ReadModeFragment dialog = new ReadModeFragment();
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
        View view = View.inflate(getActivity(), R.layout.fragment_read_mode, null);
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
        Book book = (Book) args.getSerializable("data");
        tvContent = view.findViewById(R.id.tv_content);
        tvContent.setText(book.content);

        tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText(book.name);

        tvSection = view.findViewById(R.id.tv_section);
        tvSection.setText(book.name);

        imvBack = (ImageView) view.findViewById(R.id.imv_navi_back);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissAllowingStateLoss();//exit
            }
        });


    }

}
