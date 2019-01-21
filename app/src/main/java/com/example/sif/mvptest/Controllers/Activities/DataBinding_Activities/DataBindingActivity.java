package com.example.sif.mvptest.Controllers.Activities.DataBinding_Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sif.mvptest.Model.Contact;
import com.example.sif.mvptest.R;
import com.example.sif.mvptest.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_data_binding);

        ActivityDataBindingBinding activityDataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        Contact contact = new Contact("Rakesh", "Vasal Passsed");
        activityDataBindingBinding.setContact(contact);
        setSupportActionBar(activityDataBindingBinding.toolbar);
    }
}
