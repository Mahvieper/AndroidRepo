package com.example.myuserapplication.UserInterface.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuserapplication.Application.Product;
import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.IProductClicked;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    IProductClicked iProductClicked;
    private Context mContext;
    private List<Product> productList;


    public ProductAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;

        if (this.productList == null)
            this.productList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.shopping_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        try {

            holder.mProduct_Image.setImageResource(this.productList.get(position).getmProduct_image());
            holder.mProductName.setText(this.productList.get(position).getmProduct_Name());
            holder.mProductPrice.setText(String.valueOf("₹ " + this.productList.get(position).getmProduct_Price()));

            View view = holder.getView();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Product product = productList.get(position);
                    iProductClicked.onProductClicked(product);
                    Log.e(TAG, "In on Click");
                }
            });

        } catch (Exception e) {
            Log.e(TAG, "" + e);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setValueEnteredListener(IProductClicked iProductClicked) {
        this.iProductClicked = iProductClicked;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View view;
        ImageView mProduct_Image;
        TextView mProductName;
        TextView mProductPrice;


        public View getView() {
            return view;
        }

        public ImageView getmProduct_Image() {
            return mProduct_Image;
        }

        public void setmProduct_Image(ImageView mProduct_Image) {
            this.mProduct_Image = mProduct_Image;
        }

        public TextView getmProductName() {
            return mProductName;
        }

        public void setmProductName(TextView mProductName) {
            this.mProductName = mProductName;
        }

        public TextView getmProductPrice() {
            return mProductPrice;
        }

        public void setmProductPrice(TextView mProductPrice) {
            this.mProductPrice = mProductPrice;
        }

        public MyViewHolder(View productview) {
            super(productview);
            view = productview;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e(TAG, "In Product Clicked");
                }
            });


            mProduct_Image = productview.findViewById(R.id.product_image);
            mProductName = productview.findViewById(R.id.product_name);
            mProductPrice = productview.findViewById(R.id.product_price);
        }
    }

}
