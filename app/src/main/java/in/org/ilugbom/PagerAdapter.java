package in.org.ilugbom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//import com.google.gson.Gson;

import java.util.List;
import static android.content.Context.MODE_PRIVATE;
import static android.provider.Contacts.SettingsColumns.KEY;

/**
 * Created by Milind on 01,03,2020
 */
public class PagerAdapter extends RecyclerView.Adapter
{
    int TOTALROWS=10,TOTALCOLS=7;
    private List<PagerM> pagerMList;
   int CURRENTPAGE=0;
    class PagerViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {

     //   private Button btnReset;
        private Button btt[][]=new Button[TOTALROWS][TOTALCOLS];

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);

           // btnReset = itemView.findViewById(R.id.bReset);

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
        {    notifyDataSetChanged();
            int temprow=0,tempcol=0;
            final int ii = v.getId();
            int i=0,j=0;
            for ( i = 0; i < TOTALROWS; i++)
                for ( j = 0; j < TOTALCOLS; j++)
                    if( V.T[i][j]==ii) {temprow=i;tempcol=j; break;}
            final int row=temprow;
            final int col=tempcol;

            final Button tempbutton =v.findViewById(ii);
            String presentcontent=pagerMList.get(CURRENTPAGE).getCell(row,col);
            final EditText taskEditText = new EditText(v.getContext());
            taskEditText.setSingleLine();
            taskEditText.setText(presentcontent);

            AlertDialog dialog = new AlertDialog.Builder(v.getContext())
                    .setTitle("Edit Cell")
                    .setMessage("Enter Cell Content")
                    .setView(taskEditText)
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            String task = String.valueOf(taskEditText.getText());
                            pagerMList.get(CURRENTPAGE).setCell(row,col,task);
                            tempbutton.setText(task);
                            SaveData();
                          //  savedata(MainActivity.getAppContext(),pagerMList);
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        PagerViewHolder viewHolder = (PagerViewHolder) holder;
        PagerM pagerM = pagerMList.get(position);
        CURRENTPAGE=position;
       // viewHolder.btnReset.setText(pagerM.getPagerDescription());

        int i=0,j=0;
        for ( i = 0; i < TOTALROWS; i++)
            for ( j = 0; j < TOTALCOLS; j++)
            {
                viewHolder.btt[i][j].setText(pagerM.getCell(i, j));
            }
        viewHolder.btt[0][0].setText(String.format("%02d",CURRENTPAGE));
    }

    @Override
    public int getItemCount() {
        return pagerMList.size();
    }

    String SHARED_PREFS = "TT-PREF";
    String KEY = "ALLTABLES";

    public void SaveData()
    {
        String alldata="";
        for(int t=0;t<pagerMList.size();t++)
        {
            for (int i = 0; i < TOTALROWS; i++)
                for (int j = 0; j < TOTALCOLS; j++)
                {
                    alldata += pagerMList.get(t).getCell(i, j);
                    alldata += "│";
                }

            alldata += pagerMList.get(t).getPagerDescription();
            if(t<pagerMList.size()-1) alldata+="┼"; //no end mark ┼ for last record
        }


        SharedPreferences sharedPreferences = MainActivity.getAppContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY,alldata);
        editor.apply();
    }
/*

    public void savedata(Context context, List<PagerM> callLog) {
        SharedPreferences mPrefs = context.getSharedPreferences("TT-PREFS", context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(callLog);
        prefsEditor.putString("myJson", json);
        prefsEditor.commit();
    }
*/




}
