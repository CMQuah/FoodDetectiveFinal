package com.fooddetective.fooddetective;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity implements ListFrag.StoreListener {
    TextView tvDetails;
    Button mapButton;
    ImageView img;
    int[] foodimage= new int[]{R.drawable.peteowcheiw,
            R.drawable.akipancake,
            R.drawable.porkburger02,
            R.drawable.original_koayteow,
            R.drawable.joescoconut,
            R.drawable.roticanai,
            R.drawable.tohsoon,
            R.drawable.lineclear,
            R.drawable.chickenrice,
            R.drawable.hokkien_mee
    };

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        tvDetails=(TextView)findViewById(R.id.tv_detail);
        img=(ImageView)findViewById(R.id.imv_food);
        if(findViewById(R.id.layout_default) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listFragment))
                    .commit();

        }
        else if (findViewById(R.id.layout_landscape) != null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listFragment))
                    .commit();
        }
    }

    @Override
    public void StoreSelected(final int index) {
        if (findViewById(R.id.layout_default)!=null){
            FragmentManager manager =this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFragment))
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .addToBackStack(null)
                    .commit();
        }

        String [] descriptions= getResources().getStringArray(R.array.descriptions);

        tvDetails.setText(descriptions[index]);
        img.setImageResource(foodimage[index]);

        mapButton=(Button)findViewById(R.id.button_map);



        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= Penang Road Famous Teochew Chendul Jalan Penang George Town Penang Malaysia "));
                    startActivity(intent);
                }
                else if (index == 1) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= Aki Pancake, Jalan Nipah, Bayan Lepas, Penang, Malaysia "));
                    startActivity(intent);
                }
                else if (index == 2) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= Ric's Burgers Bayan Baru Bayan Lepas Penang Malaysia"));
                    startActivity(intent);
                }
                else if (index == 3) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= Duck Egg Char Koay Teow Jalan Pasar Bukit Mertajam Penang Malaysia "));
                    startActivity(intent);
                }
                else if (index == 4) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= Joez Coconut George Town Penang Malaysia "));
                    startActivity(intent);
                }
                else if (index == 5) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= Roti Canai Transfer Road Jalan Transfer Georgetown George Town Malaysia"));
                    startActivity(intent);
                }
                else if (index == 6) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= Toh Soon Cafe, Lebuh Campbell, George Town, Penang, Malaysia "));
                    startActivity(intent);
                }
                else if (index == 7) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= Line Clear Nasi Kandar, Jalan Penang, Georgetown, George Town, Penang, Malaysia"));
                    startActivity(intent);
                }
                else if (index == 8) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= Pak Hock Penang Famous Chicken Rice, Jalan Pintal Tali, Georgetown, George Town, Penang, Malaysia "));
                    startActivity(intent);
                }
                else if (index == 9) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0.0?q= 888 Hokkien Mee, Lebuh Presgrave, Georgetown, George Town, Penang, Malaysia"));
                    startActivity(intent);
                }

            }
        });
    }
}
