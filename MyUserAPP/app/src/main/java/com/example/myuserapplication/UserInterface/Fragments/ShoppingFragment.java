package com.example.myuserapplication.UserInterface.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuserapplication.Application.Product;
import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.Adapter.ProductAdapter;
import com.example.myuserapplication.UserInterface.IProductClicked;

import java.util.ArrayList;
import java.util.List;

import static com.example.myuserapplication.UserInterface.UI.Shopping.products;

public class ShoppingFragment extends Fragment implements IProductClicked{
     List<Product> productsList = new ArrayList<>();
    private static final String TAG = "ShoppingFragment";
    private View view;
    private int position;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            return inflater.inflate(R.layout.shopping_screen_recycler,container,false);

        }catch (Exception e) {
            Log.e(TAG,"on OnCreateVIew of ShoppingFragment");
            return null;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        try {
            super.onViewCreated(view, savedInstanceState);
            intitView(view);
        }catch (Exception e) {
            Log.e(TAG,"in onViewCreated of ShoppingFragment");
        }
    }

    private void intitView(View view) {

        RecyclerView productList=getActivity().findViewById(R.id.shopping_recyclerview);
        ProductAdapter productAdapter=new ProductAdapter(getActivity(),getProductsList());
        productAdapter.setValueEnteredListener(this);
        productList.setLayoutManager(new GridLayoutManager(getActivity(),2));
        productList.setAdapter(productAdapter);




    }

    private List<Product> getProductsList() {


        productsList.add(new Product(R.drawable.mechanical_keyboard,"Mechanical Keyboard",1500));
        productsList.add(new Product(R.drawable.gtx,"Gtx Graphic Card",4500));
        productsList.add(new Product(R.drawable.gtx1060,"Gtx 1060 Graphic Card",7999));
        productsList.add(new Product(R.drawable.monitor,"Monitor",5000));
        productsList.add(new Product(R.drawable.mouse,"Gaming Mouse",3500));
        productsList.add(new Product(R.drawable.predatorcpu,"Acer Predator CPU",59000));
        productsList.add(new Product(R.drawable.razor,"Razor CPU",5000));
        productsList.add(new Product(R.drawable.xbox,"XBOX ONE",69000));

        return productsList;

    }

    @Override
    public void onProductClicked(Product product) {
        Product product1=product;
        products.add(product1);
    }


  /*  @Override
    public void onProductClicked(View view, int position) {
        this.view=view;
        this.position=position;
        products.add(productsList.get(this.position));
    }*/
}


