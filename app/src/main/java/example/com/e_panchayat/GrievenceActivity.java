package example.com.e_panchayat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import example.com.e_panchayat.Adapters.GrivenceAdapter;
import example.com.e_panchayat.Models.GrivenceModel;

public class GrievenceActivity extends AppCompatActivity {

    Toolbar mtoolbar;
    FloatingActionButton mfab;
    private RecyclerView mRecyclerView;
    private DatabaseReference mRef;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grievence);

        mtoolbar = (Toolbar) findViewById(R.id.g1toolbar);
        mtoolbar.setTitle("Grievence & Suggestions");
        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GrievenceActivity.this,DashboardActivity.class));
                finish();
            }
        });

        mfab = (FloatingActionButton) findViewById(R.id.fab);
        mfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GrievenceActivity.this,GrievenceRegActivity.class));
            }
        });


        mRecyclerView = findViewById(R.id.rv_data);


        layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);



        mRef = FirebaseDatabase.getInstance().getReference().child("Data").child("Grivence Data");
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(GrievenceActivity.this,DashboardActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<GrivenceModel> options
                = new FirebaseRecyclerOptions.Builder<GrivenceModel>()
                .setQuery(mRef, GrivenceModel.class)
                .build();



        FirebaseRecyclerAdapter<GrivenceModel, GrivenceAdapter> adapter =
                new FirebaseRecyclerAdapter<GrivenceModel, GrivenceAdapter>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull GrivenceAdapter holder, int i, @NonNull final GrivenceModel model) {

                        holder.mCategory.setText(model.getCategory());
                        holder.mFullname.setText(model.getFullname());
                        holder.mWard.setText(model.getWard());
                        holder.mDate.setText(model.getDate());
                        holder.mTime.setText(model.getTime());
                        holder.mDetails.setText(model.getGrivence());
                    }

                    @NonNull
                    @Override
                    public GrivenceAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grivence_item,parent,false);
                        GrivenceAdapter holder = new GrivenceAdapter(view);
                        return holder;
                    }
                };
        mRecyclerView.setAdapter(adapter);

        adapter.startListening();


    }
}
