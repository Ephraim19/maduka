package com.eph.maduka.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eph.maduka.R;
import com.eph.maduka.databinding.ProductsBinding;
import com.eph.maduka.interfaces.HomeAdapterInterface;
import com.eph.maduka.models.Products;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    Context context;
    List<Products> products;
    private final HomeAdapterInterface homeAdapterInterface;

    public HomeAdapter(Context context,List<Products> products,HomeAdapterInterface homeAdapterInterface) {
        this.context = context;
        this.products = products;
        this.homeAdapterInterface = homeAdapterInterface;
    }

    @NonNull
    @Override
    public HomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.products,parent,false);
        return new HomeAdapter.MyViewHolder(view,homeAdapterInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.MyViewHolder holder, int position) {
        holder.productImage.setImageResource(products.get(position).getImage());
        holder.textView.setText(products.get(position).getNames());
        holder.textPrice.setText(products.get(position).getPrice());
        holder.textQuantity.setText(products.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView textView, textPrice,textQuantity;
        public MyViewHolder(@NonNull View itemView,HomeAdapterInterface homeAdapterInterface) {
            super(itemView);
            productImage = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textPrice = itemView.findViewById(R.id.Price);
            textQuantity = itemView.findViewById(R.id.Quantity);

            itemView.findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(homeAdapterInterface != null){
                        int itemPosition = getAdapterPosition();

                        if(itemPosition != RecyclerView.NO_POSITION){
                            homeAdapterInterface.onButtonAddClick(itemPosition);
                        }
                    }
                }
            });
        }
    }
}












