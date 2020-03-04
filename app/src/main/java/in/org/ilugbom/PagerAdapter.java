package in.org.ilugbom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Milind on 01,03,2020
 */
public class PagerAdapter extends RecyclerView.Adapter
{
    int TOTALROWS=3,TOTALCOLS=7;
    private List<PagerM> pagerMList;
   int CURRENTPAGE=0;
    class PagerViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {

        private Button btnReset;
        private Button btt[][]=new Button[10][7];

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);

            btnReset = itemView.findViewById(R.id.bReset);

            int i=0,j=0;
            for ( i = 0; i < TOTALROWS; i++)
                for ( j = 0; j < TOTALCOLS; j++)

                    {
                     btt[i][j]=itemView.findViewById(V.T[i][j]);
                     btt[i][j].setOnClickListener(this);
                    }
        }

        @Override
        public void onClick(View v)
        {
            int temprow=0,tempcol=0;
            final int ii = v.getId();
            int i=0,j=0;
            for ( i = 0; i < TOTALROWS; i++)
                for ( j = 0; j < TOTALCOLS; j++)
                    if( V.T[i][j]==ii) {temprow=i;tempcol=j; break;}
            final int    row=temprow;
            final int col=tempcol;

            final Button tempbutton =v.findViewById(ii);

         // showForgotDialog(v.getContext());
            final int V=v.getId();
            final EditText taskEditText = new EditText(v.getContext());
            AlertDialog dialog = new AlertDialog.Builder(v.getContext())
                    .setTitle("Forgot Password")
                    .setMessage("Enter your mobile number?")
                    .setView(taskEditText)
                    .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String task = String.valueOf(taskEditText.getText());
                            tempbutton.setText(task);
                                 }
                    })
                    .setNegativeButton("Cancel", null)
                    .create();
            dialog.show();
        }


         void showForgotDialog(Context c) {
            final EditText taskEditText = new EditText(c);
            AlertDialog dialog = new AlertDialog.Builder(c)
                    .setTitle("Forgot Password")
                    .setMessage("Enter your mobile number?")
                    .setView(taskEditText)
                    .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String task = String.valueOf(taskEditText.getText());
           //                 temp=task;
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create();
            dialog.show();
        }

    }  ////end of class pageviewholder

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
        CURRENTPAGE=position;
        viewHolder.btnReset.setText(pagerM.getPagerDescription());

        int i=0,j=0;
        for ( i = 0; i < TOTALROWS; i++)
            for ( j = 0; j < TOTALCOLS; j++)
            {
                viewHolder.btt[i][j].setText(pagerM.getCell(0, 0));
            }
    }

    @Override
    public int getItemCount() {
        return pagerMList.size();
    }
}
