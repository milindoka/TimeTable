package in.org.ilugbom;

/**
 * Created by Becody.com on 08,07,2019
 */
public class PagerM {
    private String pagerDescription;
    String[][] TV = new String[10][7];

    public String getPagerDescription() {
        return pagerDescription;
    }

    public void setPagerDescription(String pagerDescription)
    {
        this.pagerDescription = pagerDescription;

            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 7; j++)
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
            TV[3][0]=("13:50");
            TV[4][0]=("14:30");
            TV[5][0]=("15:00");
            TV[6][0]=("15:40");
            TV[7][0]=("16:20");
            TV[8][0]=("17:00");
            TV[9][0]=("17:40");
    }

    void setCell(int r,int c,String str)
    {
        TV[r][c]=str;
    }

    String getCell(int r,int c){return TV[r][c];}



}
