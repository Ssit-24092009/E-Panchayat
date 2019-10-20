package example.com.e_panchayat.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import example.com.e_panchayat.Interfaces.ItemClickListener;
import example.com.e_panchayat.R;

public class CertificateAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView mCertificateName,mCertificateUrl,mCommitee,mIssueby;
    public ItemClickListener listener;
    public CertificateAdapter(@NonNull View itemView) {
        super(itemView);

        mCertificateName = itemView.findViewById(R.id.certificate_name);
        mCertificateUrl = itemView.findViewById(R.id.certificate_url);
        mCommitee = itemView.findViewById(R.id.certicate_commitee);
        mIssueby = itemView.findViewById(R.id.issued_by);
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v,getAdapterPosition(),false);
    }
}
