package in.org.ilugbom;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.viewPager2);
        setUpPagerAdapter();
    }
    /**
     * set up adapter same like you do for RecyclerView or other components
     */
    private void setUpPagerAdapter() {
        PagerAdapter pagerAdapter = new PagerAdapter(fetchDummyData());
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }

    /**
     *
     * @return this method will return dummy data in form of list
     */
    private List<PagerM> fetchDummyData() {
        List<PagerM> pagerMList = new ArrayList<>();
        for (int i=0;i<4;i++)
         {
            PagerM pagerM = new PagerM();
            pagerM.setPagerDescription(String.format("%02d",i));
            pagerMList.add(pagerM);

        }
        return pagerMList;
    }
}

