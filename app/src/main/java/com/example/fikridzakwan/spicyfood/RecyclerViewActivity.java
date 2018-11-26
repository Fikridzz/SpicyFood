package com.example.fikridzakwan.spicyfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {

    int[] gambarMakanan;
    String[] namaMakanan, detailMakanan;
    @BindView(R.id.myRecyclerView)
    RecyclerView myRecyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_profile:
                intent = new Intent(this, Profile.class);
                startActivity(intent);
                break;

                            case R.id.action_about:
                                intent = new Intent(this, About.class);
                                startActivity(intent);
                                break;



        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ButterKnife.bind(this);


        namaMakanan = getResources().getStringArray(R.array.nama_makanan);
        detailMakanan = getResources().getStringArray(R.array.detaill_makanan);
        gambarMakanan = new int[]{R.drawable.samyang, R.drawable.seblak, R.drawable.mieabangade, R.drawable.ayamgeprek, R.drawable.firechiken, R.drawable.mieaceh, R.drawable.ayamricarica, R.drawable.karuhun, R.drawable.maichi};

        Adapter adapter = new Adapter(this, gambarMakanan, namaMakanan, detailMakanan);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerView.setAdapter(adapter);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);




    }
}
