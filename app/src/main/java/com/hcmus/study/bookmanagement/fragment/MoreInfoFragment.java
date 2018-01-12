package com.hcmus.study.bookmanagement.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hcmus.study.bookmanagement.R;
import com.hcmus.study.bookmanagement.model.Author;
import com.hcmus.study.bookmanagement.model.AuthorManager;
import com.hcmus.study.bookmanagement.model.Book;

/**
 * Created by VuQuang on 12/01/2018.
 */

public class MoreInfoFragment extends DialogFragment {
    private static final String TAG = "MoreInfoFragment";

    private ImageView imvBack;
    private ImageView imvBanner;
    private TextView tvText1;
    private TextView tvText2;
    private TextView tvText3;
    private Button btnNext;

    public static void show(FragmentManager fm, Object obj, String type) {
        MoreInfoFragment dialog = newInstance(obj, type);
        dialog.show(fm, TAG);
    }

    private static MoreInfoFragment newInstance(Object obj, String type) {
        Bundle args = new Bundle();
        if(type == "author") {
            args.putSerializable("data", (Author) obj);
        } else {
            args.putSerializable("data", (Book) obj);
        }
        args.putString("type", type);
        MoreInfoFragment dialog = new MoreInfoFragment();
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
        View view = View.inflate(getActivity(), R.layout.fragment_more_info, null);
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

        imvBack = (ImageView) view.findViewById(R.id.imv_navi_back);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissAllowingStateLoss();//exit
            }
        });

        String type = args.getString("type");

        imvBanner = view.findViewById(R.id.imv_banner);
        tvText1 = view.findViewById(R.id.tv_text1);
        tvText2 = view.findViewById(R.id.tv_text2);
        tvText3 = view.findViewById(R.id.tv_text3);
        btnNext = view.findViewById(R.id.btn_next);
        if(type == "author") {
            final Author author = (Author) args.getSerializable("data");
            imvBanner.setImageDrawable(getResources().getDrawable(R.drawable.author_banner));
            tvText1.setText("Name: "+ author.name);
            tvText2.setText("Nation: "+ author.nation);
            tvText3.setText("Amount of books: "+ String.valueOf(author.bookList.size()));
            btnNext.setText("View books");
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BookListFragment.show(getActivity().getSupportFragmentManager(), author.bookList);
                }
            });
        } else {
            final Book book= (Book) args.getSerializable("data");
            imvBanner.setImageDrawable(getResources().getDrawable(R.drawable.book_banner));
            tvText1.setText("Name: "+ book.name);
            tvText2.setText("Author: "+ AuthorManager.findObject(book).name);
            tvText3.setText("Publish year: "+ book.publicYear);
            btnNext.setText("Read book");
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ReadModeFragment.show(getActivity().getSupportFragmentManager(), book);

                }
            });
        }
    }

}
