package com.example.sif.mvptest.Controllers.Activities.DataBinding_Activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.sif.mvptest.Adapter.RecyclerAdapter;
import com.example.sif.mvptest.Model.RecyclerUser;
import com.example.sif.mvptest.R;
import com.example.sif.mvptest.databinding.ActivityRecyclerDataBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerDataActivity extends AppCompatActivity {

    private ActivityRecyclerDataBinding activityRecyclerDataBinding;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_recycler_data);

        activityRecyclerDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_data);
        activityRecyclerDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityRecyclerDataBinding.recyclerView.setHasFixedSize(true);

        adapter = new RecyclerAdapter(this, prepareList());
        activityRecyclerDataBinding.recyclerView.setAdapter(adapter);

    }

    private List<RecyclerUser> prepareList() {
        List<RecyclerUser> data = new ArrayList<>();

        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> email = Arrays.asList(getResources().getStringArray(R.array.emails));
        int c = 0;
        for (String name : names) {
            data.add(new RecyclerUser(name, email.get(c), R.drawable.com_facebook_button_icon));
            c++;
        }
        return data;
    }
}
