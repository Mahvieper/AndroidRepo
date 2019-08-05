package com.example.myuserapplication.UserInterface.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuserapplication.Application.Item;
import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.IValueEntered;
import com.example.myuserapplication.UserInterface.ItemAdapter;
import com.example.myuserapplication.Utility.DialogUtil;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeFragment extends Fragment implements IValueEntered {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       try {
           View view= inflater.inflate(R.layout.home_screen,container,false);
          return view;
       }catch (Exception e)
       {
           Log.e(TAG,"Home Fragment onCreateView method Called");
           return null;
       }
        
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        try {
            super.onViewCreated(view, savedInstanceState);
            initView(view);
            
        }catch (Exception e) {
            Log.e(TAG,"Home Fragment onViewCreated method Called");
        }
    }

    private void initView(View view) {
        RecyclerView itemsList=getActivity().findViewById(R.id.recycleView);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        ItemAdapter itemAdapter=new ItemAdapter(getActivity(),getDummyItemsList());
        itemAdapter.setValueEnteredListner(this);
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(itemAdapter);

        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        try {
        super.onCreate(savedInstanceState);
        }catch(Exception e) {
            Log.e(TAG,"HomeFragment onCreate Called");
        }
    }


    private List<Item> getDummyItemsList() {
        List<Item> itemList = new ArrayList<>();
        Item item;

        item = new Item();
        item.setName("Peter England");
        item.setSubTitle("Android Developer");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("John Cena");
        item.setSubTitle("Java Developer");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Ronny Prest");
        item.setSubTitle("Android Developer");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Matt Hardy");
        item.setSubTitle("Flutter");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Prem Singh");
        item.setSubTitle("React Developer");
        item.setImage(R.drawable.dummy);
        itemList.add(item);

        item = new Item();
        item.setName("Albereto Singh");
        item.setSubTitle("Android Developer");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Kingston Shret");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        itemList.add(item);

        item = new Item();
        item.setName("Lavando Petricks");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Flamingo Shret");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        item = new Item();
        item.setName("Jisper Falls");
        item.setSubTitle("Android Dev");
        item.setImage(R.drawable.dummy);
        item.setDate("08/05/2019");
        itemList.add(item);

        return itemList;

    }


    @Override
    public void onTitleClicked(String text) {
        try {
            new DialogUtil().Dialog(getActivity(),"You have entered :"+" "+text);
        }catch(Exception e) {
            Log.e(TAG,"HomeFragment onTitleClicked Called");
        }
    }
}
