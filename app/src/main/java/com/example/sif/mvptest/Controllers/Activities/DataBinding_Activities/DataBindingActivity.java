package com.example.sif.mvptest.Controllers.Activities.DataBinding_Activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sif.mvptest.Model.Contact;
import com.example.sif.mvptest.Model.User;
import com.example.sif.mvptest.R;
import com.example.sif.mvptest.databinding.ActivityDataBindingBinding;

public class DataBindingActivity extends AppCompatActivity {


    private ClickHandler handler;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_data_binding);

        ActivityDataBindingBinding activityDataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        Contact contact = new Contact("Rakesh", "Vasal Passsed");
        user = new User();
        user.setFirstName("Rakesh");
        user.setLastname("Vasal");
        activityDataBindingBinding.setUser(user);
        //activityDataBindingBinding.setContact(contact);
        setSupportActionBar(activityDataBindingBinding.toolbar);
        handler = new ClickHandler(activityDataBindingBinding.content.txtfName, activityDataBindingBinding.content.txtlName);
        activityDataBindingBinding.content.setClickHandler(handler);
    }

    public class ClickHandler {

        private EditText fName, lName;
        private Context context;

        ClickHandler(EditText fName, EditText lName) {
            this.fName = fName;
            this.lName = lName;
        }

        public void handleButtonClick(View view) {
            //Toast.makeText(context, "Clicked the button", Toast.LENGTH_SHORT).show();
            user.setFirstName(fName.getText().toString());
            user.setLastname(lName.getText().toString());
            fName.setText("");
            lName.setText("");
        }

        public boolean handleButtonLongClick(View view) {
            Toast.makeText(context, "Clicked the Long Click button", Toast.LENGTH_SHORT).show();
            return false;
        }

        public void handleButtonClickwithParam(View view, Contact contact) {
            Toast.makeText(context, "Clicked the button" + contact.firstName, Toast.LENGTH_SHORT).show();
        }

    }
}
