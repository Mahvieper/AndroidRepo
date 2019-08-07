package com.example.myuserapplication.UserInterface.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myuserapplication.Application.Item;
import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.IValueEntered;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private IValueEntered valueEnteredListner;
    private List<Item> itemList;

    public ItemAdapter(Context context, List<Item> itemsList) {
        this.mContext = context;
        this.itemList = itemsList;

        if (this.itemList == null)
            this.itemList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        try {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview, parent, false);
            return new ItemsViewHolder(view);
        }catch(Exception e) {
            Log.e(TAG,"ItemAdapter onCreateViewHolder Called");
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            try {
            final Item item = itemList.get(position);
            final ItemsViewHolder itemsViewHolder = (ItemsViewHolder) holder;
            itemsViewHolder.itemImage.setImageResource(item.getImage());

            itemsViewHolder.itemTitle.setText(item.getName());
            itemsViewHolder.itemTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String ShowText = itemsViewHolder.editInfo.getText().toString();

                    if (valueEnteredListner != null) {
                        valueEnteredListner.onTitleClicked(ShowText);
                    }
                }
            });
            itemsViewHolder.itemSubTitle.setText(item.getSubTitle());
            itemsViewHolder.date.setText(item.getDate());
            }catch(Exception e) {
                Log.e(TAG,"ItemAdapter onBindViewHolder Called");
            }
        /*catch (Exception e) {
            Log.e(TAG,"OnBindViewHolder method Called");
        }*/
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ItemsViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemSubTitle;
        TextView date;
        EditText editInfo;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.dummy_user);
            itemTitle = itemView.findViewById(R.id.user_title);
            itemSubTitle = itemView.findViewById(R.id.user_subtitle);
            date = itemView.findViewById(R.id.user_date);
            editInfo = itemView.findViewById(R.id.et_user);
        }
    }

    public void setValueEnteredListner(IValueEntered valueEnteredListner) {
        this.valueEnteredListner = valueEnteredListner;
    }
}

