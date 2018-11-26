package com.example.fikridzakwan.spicyfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class About extends AppCompatActivity {

    @BindView(R.id.imgProfile)
    CircleImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        Glide.with(this).load(R.drawable.profile).into(imgProfile);

    }
}
