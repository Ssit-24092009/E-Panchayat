package example.com.e_panchayat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class GrievenceRegActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button send;
    Toolbar mtoolbar;
    Spinner spinner;
    TextInputEditText fullname,address,phonenumber,wardnumber,grivence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grievence_reg);

        fullname = findViewById(R.id.fullname);
        address = findViewById(R.id.address);
        phonenumber = findViewById(R.id.phonenumber);
        wardnumber = findViewById(R.id.wardnumber);
        grivence = findViewById(R.id.grivence);
        send = (Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addgrivence();
            }
        });
        mtoolbar = (Toolbar) findViewById(R.id.g2toolbar);
        mtoolbar.setTitle("Grievence Registration");
        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GrievenceRegActivity.this,GrievenceActivity.class));
                finish();
            }
        });

        spinner = (Spinner) findViewById(R.id.categorySpinner);

        List<String> categories = new ArrayList<String>();
        categories.add("Water Supply");
        categories.add("Leakage Repair");
        categories.add("Hand Pump Repair");
        categories.add("Light Repair");
        categories.add("Drainage Cleaning");
        categories.add("Washroom Cleaning");
        categories.add("Waste Management");
        categories.add("Others");
        categories.add("Instructions");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    private void addgrivence() {



        String saveCurrentTime, saveCurrentDate;

        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());

        SimpleDateFormat currentTime= new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calForDate.getTime());

        final String gid = saveCurrentDate +  saveCurrentTime;

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Data");

        final HashMap<String,Object> grivMap = new HashMap<>();
        grivMap.put("fid", gid);
        grivMap.put("fullname", fullname.getText().toString());
        grivMap.put("address", address.getText().toString());
        grivMap.put("ward", wardnumber.getText().toString());
        grivMap.put("phonenumber", phonenumber.getText().toString());
        grivMap.put("grivence", grivence.getText().toString());
        grivMap.put("date", saveCurrentDate);
        grivMap.put("time", saveCurrentTime);
        grivMap.put("category",spinner.getSelectedItem().toString());

        cartListRef.child("Grivence Data")
                .child(gid)
                .updateChildren(grivMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){


                                            Toast.makeText(GrievenceRegActivity.this,"Complaint is added",Toast.LENGTH_LONG).show();

                                            Intent intent = new Intent(GrievenceRegActivity.this, GrievenceActivity.class);
                                            startActivity(intent);
                                            finish();

                        }
                    }
                });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(GrievenceRegActivity.this,GrievenceActivity.class);
        startActivity(i);
        finish();
    }
}
