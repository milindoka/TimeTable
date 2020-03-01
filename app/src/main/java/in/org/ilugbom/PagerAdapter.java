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
 * Created by Becody.com on 08,07,2019
 */
public class PagerAdapter extends RecyclerView.Adapter {
    private List<PagerM> pagerMList;

    class PagerViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {

        private Button btnReset;
        private Button btnb00,btnb01,btnb02;

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);

            btnReset = itemView.findViewById(R.id.bReset);
            btnb00  = itemView.findViewById(R.id.b00);
            btnb00.setOnClickListener(this); // calling onClick() method

            btnb01  = itemView.findViewById(R.id.b01);
            btnb01.setOnClickListener(this); // calling onClick() method

            btnb02  = itemView.findViewById(R.id.b02);
            btnb02.setOnClickListener(this); // calling onClick() method

        }

        @Override
        public void onClick(View v)
        {
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



                            switch (V) {

                                case R.id.b00:
                                    btnb00.setText(task);
                                    break;

                                case R.id.b01:
                                    btnb01.setText(task);
                                    break;

                                case R.id.b02:
                                    btnb02.setText(task);
                                    break;

                                default:
                                    break;
                            }
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

        viewHolder.btnReset.setText(pagerM.getPagerDescription());
    }

    @Override
    public int getItemCount() {
        return pagerMList.size();
    }
}
