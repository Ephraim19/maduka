package com.eph.maduka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.eph.maduka.adapters.HomeAdapter;
import com.eph.maduka.databinding.ActivityMainBinding;
import com.eph.maduka.models.Products;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    RecyclerView recyclerView;

    List<Products> products = new ArrayList<>();
    String[] names;
    int[] image = {R.drawable.sugar,R.drawable.sanitizer,R.drawable.omo,R.drawable.fanta,R.drawable.menengai,R.drawable.water___m,R.drawable.rice,R.drawable.pens,R.drawable.a4book,R.drawable.oil,R.drawable.oils,R.drawable.salt};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setUpProducts();

        recyclerView = binding.recyclerView;
        HomeAdapter adapter = new HomeAdapter(this,products);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpProducts(){
        names = getResources().getStringArray(R.array.productNames);

        for(int i=1; i < names.length; i++){
            products.add(new Products(image[i], names[i]));
        }
    }
}




























