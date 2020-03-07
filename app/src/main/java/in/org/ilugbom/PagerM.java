package in.org.ilugbom;

/**
 * Created by Milind com on 08,07,2019
 */
public class PagerM {
    String title;
    int TOTALROWS=3,TOTALCOLS=7;
    String[][] TV = new String[TOTALROWS][TOTALCOLS];


    public String getPagerDescription() {
        return title;
    }

    public void setPagerDescription(String pagerDescription)
    {
        this.title = pagerDescription;

            for (int i = 0; i < TOTALROWS; i++)
                for (int j = 0; j < TOTALCOLS; j++)
                { TV[i][j]="";
                }

            TV[0][1]=("Mon");
            TV[0][2]=("Tue");
            TV[0][3]=("Wed");
            TV[0][4]=("Thu");
            TV[0][5]=("Fri");
            TV[0][6]=("Sat");

            TV[1][0]=("12:30");
            TV[2][0]=("13:10");
         /*
            TV[3][0]=("13:50");
            TV[4][0]=("14:30");
            TV[5][0]=("15:00");
            TV[6][0]=("15:40");
            TV[7][0]=("16:20");
            TV[8][0]=("17:00");
            TV[9][0]=("17:40");

          */
    }

    void setCell(int r,int c,String str)
    {
        TV[r][c]=str;
    }

    String getCell(int r,int c){return TV[r][c];}



}
