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

import com.example.myuserapplication.Application.Cart;
import com.example.myuserapplication.Application.Product;
import com.example.myuserapplication.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;

    private List<Cart> productCart;

    public CartAdapter(Context mContext, List<Cart> products) {
        this.mContext = mContext;
        this.productCart = products;

        if (productCart == null)
            productCart = new ArrayList<>();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        try {
            View view = LayoutInflater.from(mContext).inflate(R.layout.cart_items_cardview, parent, false);
            return new CartViewHolder(view);
        } catch (Exception e) {
            Log.e(TAG, "IN CardAdapter onCreateViewHolder");
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {

            Cart cart = productCart.get(position);
            final CartAdapter.CartViewHolder itemsViewHolder = (CartAdapter.CartViewHolder) holder;
            Product product1 = cart.getProduct();
            itemsViewHolder.mProduct_Image.setImageResource(product1.getmProduct_image());
            itemsViewHolder.mProductName.setText(product1.getmProduct_Name());
            itemsViewHolder.mProductPrice.setText(String.valueOf("₹ " + product1.getmProduct_Price()));
            itemsViewHolder.mProductCount.setText(String.valueOf("count : " + cart.getProductCount()));

        } catch (Exception e) {
            Log.e(TAG, " " + e);
        }
    }


    @Override
    public int getItemCount() {
        return productCart.size();
    }


    public class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView mProduct_Image;
        TextView mProductName;
        TextView mProductPrice;
        TextView mProductCount;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            mProduct_Image = itemView.findViewById(R.id.cart_image);
            mProductName = itemView.findViewById(R.id.product_name);
            mProductPrice = itemView.findViewById(R.id.product_price);
            mProductCount = itemView.findViewById(R.id.cart_items);
        }

        public TextView getmProductCount() {
            return mProductCount;
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


    }
}
