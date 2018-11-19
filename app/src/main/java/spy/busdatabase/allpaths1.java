package spy.busdatabase;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SPY on 6/21/2017.
 */
class allpaths1 extends AppCompatActivity {
    databaseHelper myDb;
    static int dim = 5, size = 0,t,n;
    static boolean[] color = new boolean[dim + 1];
    static int[][] graph = {{},{0,0, 1, 1, 1, 1},
            {0,1 ,0 ,1 ,1 ,1},
            {0,1, 1, 0, 1, 1},
            {0,1 ,1 ,1 ,0, 1},
            {0,1, 1 ,1 ,1 ,0},};
    static String array1[]={"","AC1","AC2","AC5","3A","1A"};
    static ArrayList<Integer> al = new ArrayList<Integer>();
    static ArrayList<String> paths = new ArrayList<String>();
    static ArrayList<String> inbetween_list = new ArrayList<String>();
    static ArrayList<String> path_stop = new ArrayList<String>();
    static int a=1,l=1,m=1,v=1,b1,b2;
    static String S="SOURCE";
    static String D="DESTINATION",x="",q1,q2;
    static String PATH,inbetween_stops,p,o;
    String[] X;
    String[] Y;
    Context c1;



    public  allpaths1(Context context,String s,String d)
     {
         c1 = context;
         S=s;
         D=d;
         q1=s;
         q2=d;
     }


    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        Arrays.fill(color, false);

    }


    public int convert(String z)
    {
        return Arrays.asList(array1).indexOf(z);      //Source node

    }

    public ArrayList<String>  dfs(int src, int dst) {

        al.add(src);
        size++;
        color[src] = true;
        if (src == dst) {       // tests for base condition to stop

            PATH="-->"; inbetween_stops="-->";
            for(int i=1;i<al.size();i++)
            {
                n=i;
                Log.e("paths","x="+x );
                 p="";o="";
                p=array1[al.get(i-1)];
                o=array1[al.get(i)];
                Log.e("paths",p+" & "+o );

                //***********to correct


                   myDb=new databaseHelper(c1);
                 X= myDb.fetch1stop(p,o);
                Log.e("paths", Arrays.toString(X));
                t=X.length;
                if (t==0)
                {
                    x=null;
                }
                 else
                {
                    x=X[(t-1)];
                }
                 Log.e("paths", Arrays.toString(X)+"& length = "+t+"#"+x);

                //  *****************

                Y = myDb.getallbetweenstops(p, q1, x);
                //PATH=PATH+p+"-->"+"CP"+i+ Arrays.toString(X)+" -->"+o+" than ";
                PATH=PATH+p+"-->"+"CP."+i+")"+x+" -->"+o+" than ";
                inbetween_stops=inbetween_stops+" "+q1+" -->"+i+" "+Arrays.toString(Y)+" -->";
                Log.e("final","PATH = "+ PATH);
                Log.e("final","inbetween_stops = "+inbetween_stops);
                Log.e("asdf","Y ="+ Arrays.toString(Y)+"& length = "+Y.length);
                Log.e("getallbetweenstops"," value of q1 "+q1+" value of q2 "+q2+" value of o "+o+" value of p "+p+" value of x "+x);
               /* if (n==(al.size()-1))
                {

                    Y = myDb.getallbetweenstops(o,x,q2);


                }
*/




/*
                     for(int k=0;k<Y.length;k++)
                     {
                         inbetween_stops= inbetween_stops+" "+m+"."+Y[k]+" ";
                        m++;
                     }*/

                Log.e("getallbetweenstops", "main"+ Arrays.toString(myDb.getallbetweenstops("AC1","sanganer town","kundan nagar")));
                Log.e("getallbetweenstops", "mainsadas"+ Arrays.toString(myDb.getallbetweenstops(p,q1,x)));

                q1 = x;
                Log.e("getallbetweenstops","allpaths1");
                Log.e("getallbetweenstops", "p="+p+"&"+"q1="+q1+"&"+"x="+x);
                Log.e("getallbetweenstops", "Y="+Arrays.toString(Y));
                Log.e("getallbetweenstops", "LENGTH OF Y="+Y.length);

b1=i+1;b2=i;
            }
            Log.e("final1","o="+o+" q1="+q1+" q2="+q2+" b1="+b1+" i="+b2);
            PATH = ") "+S+PATH+D;
            Y = myDb.getallbetweenstops(o, q1, q2);
            inbetween_stops=inbetween_stops+" "+q1+" -->"+b1+" "+Arrays.toString(Y)+" -->";
            inbetween_stops = v+") "+inbetween_stops+D;
            Log.e("final"," fullPATH = "+ PATH);
            Log.e("final","fullinbetween_stops = "+inbetween_stops);
            m=1;
            v++;
            l++;
            q1=S;

            paths.add(PATH);
            inbetween_list.add(inbetween_stops);

            Log.e("index", String.valueOf(paths.indexOf(PATH))+"->"+PATH);
            Log.e("index", String.valueOf(inbetween_list.indexOf(inbetween_stops))+"->"+inbetween_stops);
            Log.e("index",String.valueOf(paths.indexOf(PATH))+"->"+ paths.get(paths.indexOf(PATH)));
            Log.e("index",String.valueOf(inbetween_list.indexOf(inbetween_stops))+"->"+ inbetween_list.get(inbetween_list.indexOf(inbetween_stops)));



        }
        for (int I = 1; I < dim+1; I++) {
            if (graph[src][I] == 1) {
                if (color[I] == false) {
                    dfs(I, dst);        // These lines do
                    color[I] = false;   // main job of backtracking
                    size--;
                    al.remove(size);
                }
            }
        }
        Log.e("check", "a="+String.valueOf(a)+" & "+"l="+String.valueOf(l));
        Log.e("check", String.valueOf(size)+"*"+al.size()+"*"+paths.size());
        a++;
      /*  for(int w=0;w<paths.size();w++)
        {
            Log.e("testing", " PATHS "+w+" "+paths.get(w));
        }
        for(int w=0;w<inbetween_list.size();w++)
        {
            Log.e("testing"," STOPS "+w+" "+ inbetween_list.get(w));
        }*/
        path_stop=inbetween_list;
        return paths;
    }
    public ArrayList<String> getpathstop()
    {
           return path_stop;
    }
}
