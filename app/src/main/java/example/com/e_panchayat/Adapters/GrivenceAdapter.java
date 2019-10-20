package example.com.e_panchayat.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import example.com.e_panchayat.Interfaces.ItemClickListener;
import example.com.e_panchayat.R;

public class GrivenceAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView mCategory,mFullname,mWard,mDetails,mDate,mTime;
    public ItemClickListener listener;
    public GrivenceAdapter(@NonNull View itemView) {
        super(itemView);

        mCategory = itemView.findViewById(R.id.grivence_category_id);
        mFullname = itemView.findViewById(R.id.grivence_fullname_id);
        mWard = itemView.findViewById(R.id.grivence_ward_no);
        mDetails = itemView.findViewById(R.id.grivence_details);
        mTime = itemView.findViewById(R.id.grivence_time);
        mDate = itemView.findViewById(R.id.grivence_date);
    }

    @Override
    public void onClick(View v) {
        listener.onClick(v,getAdapterPosition(),false);
    }
}
