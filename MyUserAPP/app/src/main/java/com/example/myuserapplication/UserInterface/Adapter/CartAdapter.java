package com.example.myuserapplication.UserInterface.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuserapplication.Application.Product;
import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.IProductClicked;
import com.example.myuserapplication.UserInterface.UI.Shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.example.myuserapplication.UserInterface.UI.Shopping.products;

public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<Product> productCart;



    public CartAdapter(Context mContext, List<Product> products) {
        this.mContext = mContext;
        this.productCart=products;

        if (productCart == null)
            productCart = new ArrayList<>();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        try {
            View view = LayoutInflater.from(mContext).inflate(R.layout.cart_items_cardview, parent, false);
            return new CartViewHolder(view);
        }catch (Exception e)
        {
            Log.e(TAG,"IN CardAdapter onCreateViewHolder");
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        try {
           /* HashMap<String, Product> productMap = new HashMap<>();
            for (Product product : products) {
                productMap.put(product.getmProduct_Name(), product);
            }*/

            final CartAdapter.CartViewHolder itemsViewHolder = (CartAdapter.CartViewHolder) holder;
            itemsViewHolder.mProduct_Image.setImageResource(products.get(position).getmProduct_image());
            itemsViewHolder.mProductName.setText(products.get(position).getmProduct_Name());
            itemsViewHolder.mProductPrice.setText(String.valueOf("Rs." + products.get(position).getmProduct_Price()));
        }catch (Exception e) {
            Log.e(TAG," "+e);
        }
    }


    @Override
    public int getItemCount() {
        return products.size();
    }



    public class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView mProduct_Image;
        TextView mProductName;
        TextView mProductPrice;



        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            mProduct_Image=itemView.findViewById(R.id.cart_image);
            mProductName=itemView.findViewById(R.id.product_name);
            mProductPrice=itemView.findViewById(R.id.product_price);

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
