package com.eph.maduka.ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.eph.maduka.R;
import com.eph.maduka.adapters.HomeAdapter;
import com.eph.maduka.databinding.ActivityMainBinding;
import com.eph.maduka.interfaces.HomeAdapterInterface;
import com.eph.maduka.models.Products;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeAdapterInterface {
    private ActivityMainBinding binding;
    RecyclerView recyclerView;
    ImageView imageView;

    List<Products> products = new ArrayList<>();
    String[] names;
    String[] price;
    String[] quantity;
    int[] image = {R.drawable.sugar,R.drawable.sanitizer,R.drawable.omo,R.drawable.fanta,R.drawable.menengai,R.drawable.water___m,R.drawable.rice,R.drawable.pens,R.drawable.a4book,R.drawable.oil,R.drawable.oils,R.drawable.salt};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setUpProducts();

        recyclerView = binding.recyclerView;
        HomeAdapter adapter = new HomeAdapter(this,products,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Log out
        imageView =findViewById(R.id.logoutIcon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(),"Logged out",Toast.LENGTH_LONG).show();
                Intent loginScreen = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginScreen);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();

            ImageView imageView;
            imageView = findViewById(R.id.ProfilePhoto);

            try {
                Picasso.get().load(personPhoto).into(imageView);
            } catch (Exception e){
                Log.v("image error", String.valueOf(e));
            }

            Log.v("gg", String.valueOf(personPhoto));
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
    }

    //Initialize the products
    private void setUpProducts(){
        names = getResources().getStringArray(R.array.productNames);
        price = getResources().getStringArray(R.array.productPrice);
        quantity = getResources().getStringArray(R.array.productQuantity);
        for(int i=0; i < names.length; i++){
            products.add(new Products(image[i], names[i], price[i],quantity[i]));
        }
    }

    @Override
    public void onButtonAddClick(int position) {
        Toast.makeText(MainActivity.this,products.get(position).getNames(),Toast.LENGTH_SHORT).show();
    }
}




























