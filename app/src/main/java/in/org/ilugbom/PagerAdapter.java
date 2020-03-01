package in.org.ilugbom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Becody.com on 08,07,2019
 */
public class PagerAdapter extends RecyclerView.Adapter {
    private List<PagerM> pagerMList;

    class PagerViewHolder extends RecyclerView.ViewHolder {

        private Button btnReset;

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);

            btnReset = itemView.findViewById(R.id.bReset);
        }
    }

    public PagerAdapter(List<PagerM> pagerMList) {
        this.pagerMList = pagerMList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pager, parent, false);
        return new PagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PagerViewHolder viewHolder = (PagerViewHolder) holder;
        PagerM pagerM = pagerMList.get(position);

        viewHolder.btnReset.setText(pagerM.getPagerDescription());
    }

    @Override
    public int getItemCount() {
        return pagerMList.size();
    }
}
