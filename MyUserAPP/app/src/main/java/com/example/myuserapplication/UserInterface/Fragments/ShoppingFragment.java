package com.example.myuserapplication.UserInterface.Fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuserapplication.Application.Product;
import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.Adapter.ProductAdapter;
import com.example.myuserapplication.UserInterface.IProductClicked;
import com.example.myuserapplication.UserInterface.UI.Shopping;

import java.util.ArrayList;
import java.util.List;


public class ShoppingFragment extends Fragment implements IProductClicked {
    private static final String TAG = "ShoppingFragment";

    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            return inflater.inflate(R.layout.shopping_screen_recycler, container, false);

        } catch (Exception e) {
            Log.e(TAG, "on OnCreateVIew of ShoppingFragment");
            return null;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        try {
            super.onViewCreated(view, savedInstanceState);
            intitView(view);
        } catch (Exception e) {
            Log.e(TAG, "in onViewCreated of ShoppingFragment");
        }
    }

    private void intitView(View view) {
        RecyclerView productList = view.findViewById(R.id.shopping_recyclerview);
        ProductAdapter productAdapter = new ProductAdapter(getActivity(), getProductsList());
        productAdapter.setValueEnteredListener(this);
        productList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        productList.setAdapter(productAdapter);
    }

    private List<Product> getProductsList() {
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(R.drawable.mechanical_keyboard, "Mechanical Keyboard", 1500));
        productsList.add(new Product(R.drawable.gtx, "Gtx Graphic Card", 4500));
        productsList.add(new Product(R.drawable.gtx1060, "Gtx 1060 Graphic Card", 7999));
        productsList.add(new Product(R.drawable.monitor, "Monitor", 5000));
        productsList.add(new Product(R.drawable.mouse, "Gaming Mouse", 3500));
        productsList.add(new Product(R.drawable.predatorcpu, "Acer Predator CPU", 59000));
        productsList.add(new Product(R.drawable.razor, "Razor CPU", 5000));
        productsList.add(new Product(R.drawable.xbox, "XBOX ONE", 69000));

        return productsList;
    }

    @Override
    public void onProductClicked(Product product) {
        products.add(product);
        Log.e(TAG,"Products size "+products.size());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            NavController navController =  Navigation.findNavController(getActivity(), R.id.shopping_nav_host);

            Cart_Items_Fragment secondfragment = new Cart_Items_Fragment(); //where data needs to be pass
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("products", products);
            secondfragment.setArguments(bundle);

            navController.navigate(R.id.action_shoppingFragment_to_cart_Items_Fragment, bundle);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);
    }

}


