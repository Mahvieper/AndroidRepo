package com.example.myuserapplication.UserInterface.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuserapplication.Application.Cart;
import com.example.myuserapplication.Application.Product;
import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.Adapter.CartAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart_Items_Fragment extends Fragment {

    List<Cart> cartList = new ArrayList<>();
    List<Product> parcalableList = new ArrayList<>();
    Map<Product, Integer> productMap = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cart_items_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {

        for (Product product : parcalableList) {
            if (productMap.isEmpty())
                productMap.put(product, 0);
        }

        for (Product product : parcalableList) {
            for (Map.Entry itemList : productMap.entrySet()) {
                int count = (int) itemList.getValue();
                if (productMap.containsKey(product)) {
                    productMap.put(product, count + 1);
                    break;
                } else {
                    productMap.put(product, 1);
                    break;
                }
            }
        }
        Cart cart;
        for (Map.Entry itemList : productMap.entrySet()) {
             cart = new Cart();
            Product cartItem = (Product) itemList.getKey();
            int productCount = (int) itemList.getValue();
            cart.setProduct(cartItem);
            cart.setProductCount(productCount);
            addtolist(cart);
        }

        RecyclerView itemsList = getActivity().findViewById(R.id.cart_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        CartAdapter cartAdapter = new CartAdapter(this.getActivity(), cartList);
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(cartAdapter);

        cartAdapter.notifyDataSetChanged();

    }

    private void addtolist(Cart cart) {
        cartList.add(cart);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            parcalableList = getArguments().getParcelableArrayList("products");
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_cart);
        if (item != null)
            item.setVisible(false);
    }


}
