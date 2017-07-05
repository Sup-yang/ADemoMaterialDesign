package com.example.yang.ademomaterialdesign;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Main3Fragment extends Fragment {
    EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_main3, container, false);

        NestedScrollView nestedScrollView= (NestedScrollView) inflater.inflate(R.layout.fragment_main3,container,false);

        editText= (EditText) nestedScrollView.findViewById(R.id.et_main_3);

        return nestedScrollView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        editText.requestFocus();

    }
}
