package in.org.ilugbom;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements Cell_Entry_Dialog.cell_Entry_Dialog_Listener {
    private ViewPager2 viewPager2;
    List<PagerM> pagerMList = new ArrayList<>();

    private static Context context;
    int TOTALROWS=10,TOTALCOLS=7;
    SharedPreferences sharedPreferences;
    String SHARED_PREFS = "TT-PREF";
    String KEY = "ALLTABLES";
    String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        sharedPreferences = this.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(KEY, "");


        viewPager2 = findViewById(R.id.viewPager2);
        setUpPagerAdapter();
        ////////
       MainActivity.context = getApplicationContext();



    }



    public static Context getAppContext()
    {
        return MainActivity.context;
    }
    /**
     * set up adapter same like you do for RecyclerView or other components
     */
    private void setUpPagerAdapter() {
        PagerAdapter pagerAdapter = new PagerAdapter(fetchDummyData());
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

            }




            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
      getSupportActionBar().setTitle(pagerMList.get(position).getPagerDescription());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);

            }
        });
    }

    /**
     *
     * @return this method will return dummy data in form of list
     */
    private List<PagerM> fetchDummyData() {

    String defaulttitle[]={"My Own","Extra-01","Extra-02","Extra-03"};
      pagerMList.removeAll(pagerMList);
       if(!text.contains("┼")) ///create default table
         {
            for (int i=0;i<4;i++)
            {
                PagerM pagerM = new PagerM();
                pagerM.setPagerDescription(defaulttitle[i]);
                pagerMList.add(pagerM);

            }
            return pagerMList;
        }


        String[] temp,temp2;

        temp2=text.split("┼");


        int totaltimetables= temp2.length;
       // Msg.Show(String.format("%d",totaltimetables),this);
        //   Msg.Show(String.format("%d",temp2.length),this);
       int t=0;
        //int arrsize=0;    ///Create required Timetables
        for( t=0;t<totaltimetables;t++)

        {
            PagerM pagerM = new PagerM();
           // pagerM.setPagerDescription(String.format("My %02d",t));
            pagerMList.add(pagerM);

        }

        for( t=0;t<totaltimetables;t++) ///post each time table in TD object
        {
            if(!temp2[t].contains("│")) break;
            else {
                temp = temp2[t].split("│");
            }

            int index=0;
            for (int i = 0; i < TOTALROWS; i++)
                for (int j = 0; j < TOTALCOLS; j++)
                {  if(index<temp.length)
                {
                    pagerMList.get(t).setCell(i, j, temp[index]);
             //      if(i==0 && t==0)
               //     Msg.Show(temp[index],this);
                    index++;
                } else break;

                }
            pagerMList.get(t).title=temp[index];
        }
        return pagerMList;
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
//            Snackbar.make(getWindow().getDecorView().getRootView(), "Replace with your own action", Snackbar.LENGTH_LONG)
  //                  .setAction("Action", null).show();
      ShowCellEntryDialog();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

void ShowCellEntryDialog()
{
    Cell_Entry_Dialog ced=new Cell_Entry_Dialog();
    ced.show(getSupportFragmentManager(),"Edit Cell");
}


    @Override
    public void applyText(String celltext) {
    Msg.Show(celltext,this);
    }
}


