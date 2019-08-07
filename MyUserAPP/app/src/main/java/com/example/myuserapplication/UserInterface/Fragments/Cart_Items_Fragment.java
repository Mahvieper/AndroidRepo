package com.example.myuserapplication.UserInterface.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuserapplication.Application.Product;
import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.Adapter.CartAdapter;
import com.example.myuserapplication.UserInterface.Adapter.ItemAdapter;
import com.example.myuserapplication.UserInterface.IProductClicked;
import com.example.myuserapplication.UserInterface.UI.Shopping;

import java.util.ArrayList;
import java.util.List;

import static com.example.myuserapplication.UserInterface.UI.Shopping.products;

public class Cart_Items_Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cart_items_recycler,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {

        RecyclerView itemsList=getActivity().findViewById(R.id.cart_recycler);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        CartAdapter cartAdapter=new CartAdapter(this.getActivity(),products);
        //cartAdapter.setValueEnteredListner(this);
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(cartAdapter);

        cartAdapter.notifyDataSetChanged();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
