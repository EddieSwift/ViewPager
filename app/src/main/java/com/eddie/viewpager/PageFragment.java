package com.eddie.viewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    private int color;
    private int position;


    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment newInstance(int color, int position) {

        PageFragment fragment = new PageFragment();
        fragment.color = color;
        fragment.position = position;

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page, container, false);
        TextView titleTxt = view.findViewById(R.id.title_txt);
        FrameLayout root = view.findViewById(R.id.root_container);
        titleTxt.setText("Page " + position % 10);
        root.setBackgroundColor(color);

        return view;
    }

}
