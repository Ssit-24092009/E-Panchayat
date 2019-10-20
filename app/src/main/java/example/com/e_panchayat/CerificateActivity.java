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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import example.com.e_panchayat.Adapters.CertificateAdapter;
import example.com.e_panchayat.Models.CertificateModel;

public class CerificateActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DatabaseReference mRef;
    RecyclerView.LayoutManager layoutManager;
    Toolbar mtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerificate);

        mtoolbar = (Toolbar) findViewById(R.id.certitoolbar);
        mtoolbar.setTitle("Certificate");
        mtoolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CerificateActivity.this,DashboardActivity.class));
                finish();
            }
        });

        mRecyclerView = findViewById(R.id.rv_certificate_data);


        layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);



        mRef = FirebaseDatabase.getInstance().getReference().child("Cerificate");


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(CerificateActivity.this,DashboardActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<CertificateModel> options
                = new FirebaseRecyclerOptions.Builder<CertificateModel>()
                .setQuery(mRef, CertificateModel.class)
                .build();



        FirebaseRecyclerAdapter<CertificateModel, CertificateAdapter> adapter =
                new FirebaseRecyclerAdapter<CertificateModel, CertificateAdapter>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull CertificateAdapter holder, int i, @NonNull final CertificateModel model) {

                        holder.mCertificateName.setText(model.getCertificate_name());
                        holder.mIssueby.setText(model.getIssued_by());
                        holder.mCommitee.setText(model.getCommitee());
//                        holder.mCertificateUrl.setText(model.getCertificate_url());

                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getApplicationContext(), CerActivity.class);
                                intent.putExtra("certificate_url",model.getCertificate_url());
                                startActivity(intent);
                            }
                        });
                    }

                    @NonNull
                    @Override
                    public CertificateAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.certificate_row,parent,false);
                        CertificateAdapter holder = new CertificateAdapter(view);
                        return holder;
                    }
                };
        mRecyclerView.setAdapter(adapter);

        adapter.startListening();


    }
}
