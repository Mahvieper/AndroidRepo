package com.example.myuserapplication.UserInterface.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.example.myuserapplication.UserInterface.Fragments.ShoppingFragment;
import com.example.myuserapplication.UserInterface.IProductClicked;
import com.example.myuserapplication.UserInterface.UI.Shopping;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static androidx.constraintlayout.widget.Constraints.TAG;
import static com.example.myuserapplication.UserInterface.UI.Shopping.products;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    IProductClicked iProductClicked;
    private Context mContext;
    private List<Product> productList;

    private int position1;

    public ProductAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;

        if (this.productList == null)
            this.productList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.shopping_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        try {
           //this.position1=position+1;
            holder.mProduct_Image.setImageResource(this.productList.get(position).getmProduct_image());
            holder.mProductName.setText(this.productList.get(position).getmProduct_Name());
            holder.mProductPrice.setText(String.valueOf("Rs."+this.productList.get(position).getmProduct_Price()));

            View view=holder.getView();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // products.add(productList.get(position1));
                   Product product= productList.get(position);
                   iProductClicked.onProductClicked(product);
                 //  productClicked.onProductClicked(view,position1);
                   Log.e(TAG,"In on Click");
                }
            });
           /* holder.mProduct_Image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  *//*  Log.e(TAG,"In Product Clicked");
                    addtocart(position);
*//*
                }
            });*/
        }catch (Exception e)
        {
            Log.e(TAG,""+e);
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setValueEnteredListener(IProductClicked iProductClicked) {
        this.iProductClicked=iProductClicked;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public Product product;
        ImageView mProduct_Image;
        TextView mProductName;
        TextView mProductPrice;
        int position;

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
            view=productview;
           view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  /*Bitmap image=((BitmapDrawable)mProduct_Image.getDrawable()).getBitmap();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] imageInByte = stream.toByteArray();
                    ByteArrayInputStream bis = new ByteArrayInputStream(imageInByte);
                   products.add(new Product(bis, mProductName,mProductPrice));*/
                    //position=getAdapterPosition();
                    Log.e(TAG,"In Product Clicked");
                }
            });


            mProduct_Image=productview.findViewById(R.id.product_image);
            mProductName=productview.findViewById(R.id.product_name);
            mProductPrice=productview.findViewById(R.id.product_price);
        }
    }

    public void addtocart(int position)
    {
        Product product;
        product=productList.get(position);
        products.add(product);
    }
}
