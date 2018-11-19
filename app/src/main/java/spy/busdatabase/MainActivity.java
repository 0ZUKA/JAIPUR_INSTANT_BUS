package spy.busdatabase;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static android.R.layout;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
   databaseHelper myDb;
   allpaths1 paths;
   Spinner spin1,spin2,spin3;

   Button b1,b2;
   String[] source;
   String[] destination;
    String[] all_routes;
  String[] q,r,g,t;
    String[] inbetween_stops;
    String s,d,w,x,route,start,end;
    Context c2;
   int m,n,z,y;

   ArrayList<String> getpath = new ArrayList<String>();
    ArrayList<String> k = new ArrayList<String>();
   ArrayList<String> getpath2 = new ArrayList<String>();
    ArrayList<String> getpath3 = new ArrayList<String>();
    ArrayList<String> stop1 = new ArrayList<String>();
    ArrayList<String> stop2 = new ArrayList<String>();
    String[] route_list,paths_stop_list ;
   @Override
   protected void onCreate(final Bundle savedInstanceState)  {
       super.onCreate(savedInstanceState);
       setContentView(spy.busdatabase.R.layout.activity_main);
       Resources res = getResources();
       source=res.getStringArray(spy.busdatabase.R.array.source);
       destination=res.getStringArray(spy.busdatabase.R.array.source);
       all_routes=res.getStringArray(spy.busdatabase.R.array.all_routes);
       myDb=new databaseHelper(this);
        c2 = getApplicationContext();

       b1=(Button)findViewById(spy.busdatabase.R.id.button1);
       b2=(Button)findViewById(spy.busdatabase.R.id.button2);
       spin1 = (Spinner) findViewById(spy.busdatabase.R.id.spinner1);
       spin2 = (Spinner) findViewById(spy.busdatabase.R.id.spinner2);
       spin3 = (Spinner) findViewById(spy.busdatabase.R.id.spinner3);
       spin1.setOnItemSelectedListener(this);
       spin2.setOnItemSelectedListener(this);
       spin3.setOnItemSelectedListener(this);

       //Creating the ArrayAdapter instance having the country list
       ArrayAdapter aa1 = new ArrayAdapter(this, layout.simple_spinner_dropdown_item,source);
       ArrayAdapter aa2 = new ArrayAdapter(this, layout.simple_spinner_dropdown_item,destination);
       ArrayAdapter aa3 = new ArrayAdapter(this, layout.simple_spinner_dropdown_item,all_routes);
       //Setting the ArrayAdapter data on the Spinner
       spin1.setAdapter(aa1);
       spin2.setAdapter(aa2);
       spin3.setAdapter(aa3);

      /*for(int i=0;i<q.length;i++) {

          for(int j=0;j<r.length;j++) {

              getpath.addAll(paths.dfs(paths.convert(q[i]), paths.convert(r[j])));

          }
      }*/
       b2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            Log.e("asdr", s+"$"+d );
             //Toast.makeText(getApplicationContext(), s+"  $   "+d ,Toast.LENGTH_SHORT).show();
             q = myDb.fetchid(s);
             r = myDb.fetchid(d);
             w="i";
             x="i";
             Log.e("asd", q[0]+" $ "+r[0]);
             Log.e("asd", Integer.toString(q.length));
           //  Toast.makeText(getApplicationContext(), "Your choose :"+myDb.fetchFare(s),Toast.LENGTH_SHORT).show();
              for(int i=0;i<q.length;i++)
              {
                w =  w.concat("&");
                w =  w.concat(q[i]);
                  for(int j=0;j<r.length;j++)
                  {
                      if(q[i].equals(r[j]))
                      {
                          w = w.concat(" same ");
                          w=w.concat(r[j]);
                          w=w.concat(" next ");
                      }
                      else
                      {
                          Log.e("asd5", q[i]+" $ "+r[j]);
                          //fetch stop having id equal to s_id and d_id;
                          t=myDb.fetch1stop(q[i],r[j]);
                          Log.e("asd3","entered" );
                          Log.e("asd3",Integer.toString(t.length) );
                          if(t.length!=0) {
                              for (int i1 = 0; i1 < t.length; i1++)
                              {
                                  Log.e("asd3", t[i1]);
                                  x = x.concat("%");
                                  x = x.concat(t[i1]);
                                  Log.e("asd3", x);
                              }
                          }



                              Log.e("asd5", q[i]+" $ "+r[j]);
                              //fetch stop having id equal to s_id and d_id;
                              t=myDb.fetch2stop(q[i],r[j]);
                              Log.e("asd3","entered fetch2" );
                              Log.e("asd3",Integer.toString(t.length) );
                              for (int i1 = 0;i1<t.length;i1++)
                              {
                                  Log.e("asd3",t[i1] );
                                  x=x.concat("%");
                                  x=x.concat(t[i1]);
                                  Log.e("asd3",x );
                              }
                              Log.e("asd3","hii" );



                          Log.e("asd3","hello" );
                      }

                  }
                  Log.e("asd2", q[i]);

              }



             for(int i=0;i<r.length;i++)
             {
                 x= x.concat("&");
                x= x.concat(r[i]);
             }
            // Toast.makeText(getApplicationContext(), "Your choose :"+r,Toast.LENGTH_SHORT).show();
              inbetween_stops = myDb.getallbetweenstops("AC2","bosch limited","patel marg");
             y=inbetween_stops.length;

             Log.e("getallbetweenstops", "main"+ Arrays.toString(inbetween_stops)+"&"+y);

               route_list=myDb.getallstops(route);

              z=route_list.length;
             start = route_list[0];
             end = route_list[z-1];
             Log.e("getallstops", Arrays.toString(route_list)+"&"+z);

             Intent i = new Intent(getApplicationContext(),routelist.class);
             i.putExtra("route_list",route_list);

             i.putExtra("Source",start);
             i.putExtra("Destination",end);
             startActivity(i);
            Arrays.fill(route_list,null);
             route_list=new String[0];
             start=null;
             end=null;


         }
     });
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.e("paths",s+"  & "+d );

               if(s.equals(d))
               {
                   g = myDb.fetchid(s);

               }
              else
               {
                   q = myDb.fetchid(s);
                   r = myDb.fetchid(d);
                   Log.e("paths", q.length + "  & " + r.length);
                   if(Arrays.equals(q,r))
                   {
                       g=myDb.fetchid(s);

                   }
                 else
                     {

                       for (int i = 0; i < q.length; i++) {
                           for (int j = 0; j < r.length; j++) {
                               if (q[i].equals(r[j])) {
                                   // g=g+q[i];
                                //  g[i] = q[i];
                                   k.add(q[i]);
                                   g=new String[k.size()];
                                   for(int h=0;h<k.size();h++)
                                   {
                                       g[h]=k.get(h);

                                   }

                                   continue;
                               } else {
                                   paths = new allpaths1(c2, s, d);
                                   m = paths.convert(q[i]);
                                   n = paths.convert(r[j]);

                                   Log.e("paths", m + "  & " + n);
                                   Log.e("paths", q[i] + "  & " + r[j]);

                                   getpath2.clear();
                                   stop2.clear();
                                   getpath2 = paths.dfs(m, n);
                                    stop2 = paths.getpathstop();

                                   Log.e("paths", String.valueOf(getpath2));

                                   getpath.addAll(getpath2);
                                   stop1.addAll(stop2);

                                   Log.e("paths1234", String.valueOf(getpath));


                               }

                               // important part
                               //      **********
                               paths.size = 0;
                               paths.al.clear();
                               paths.paths.clear();
                               paths.inbetween_list.clear();
                               paths.PATH = "";
                               paths.inbetween_stops="";
                               paths.a = 1;
                               paths.l = 1;
                               paths.v=1;
                               paths.m=1;
                               Arrays.fill(paths.color, false);
                               //     ********
                               Log.e("paths1234", String.valueOf(getpath));
                           }
                           Log.e("paths1234", String.valueOf(getpath));
                       }

                         Log.e("paths1234", String.valueOf(getpath));
                   }
                   Log.e("paths1234", String.valueOf(getpath));
               }
                 //getpath3=getpath;
               Intent i = new Intent(getApplicationContext(),pathslist.class);
               Log.e("paths12345", String.valueOf(getpath));
               paths_stop_list=new String[getpath.size()];
                for(int i1=0;i1<getpath.size();i1++)
                {
                    paths_stop_list[i1]=getpath.get(i1);
                }
               Log.e("paths123456", Arrays.toString(paths_stop_list));

              // *********** sort in ascending

               Comparator<String> stringLengthComparator = new Comparator<String>()
               {
                   @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                  @Override
                   public int compare(String o1, String o2)
                   {
                       return Integer.compare(o1.length(), o2.length());
                   }
               };

               Collections.sort(getpath, stringLengthComparator);

               i.putStringArrayListExtra("different_Paths_list3",getpath);
             /*  for(int u=0;u<getpath.size();u++)
               {
                   getpath.set(u,"PATH_NO. "+(u+1)+getpath.get(u));

               }*/

               // **********
               Log.e("test1", String.valueOf(getpath));
               Log.e("test1", String.valueOf(g));

                   i.putStringArrayListExtra("different_Paths_list",getpath);
                   i.putExtra("different_Paths_list2",paths_stop_list);
                   i.putStringArrayListExtra("different_Paths_stop",stop1);
                   i.putExtra("direct route",g);

                   i.putExtra("Source",s);
                   i.putExtra("Destination",d);

               startActivity(i);
                k.clear();
                g=new  String[0];
               getpath.clear();
           }
       });



   }

   @Override
   public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {

       if(arg0.getId() == spy.busdatabase.R.id.spinner1)
       {
           Toast.makeText(this, "Your choose :" + source[position],Toast.LENGTH_SHORT).show();
           s=source[position];
           Log.e("test2",s );
       }
       if(arg0.getId() == spy.busdatabase.R.id.spinner2)
       {
           Toast.makeText(this, "Your choose :" + destination[position],Toast.LENGTH_SHORT).show();
           d=destination[position];
       }
       if(arg0.getId() == spy.busdatabase.R.id.spinner3)
       {
           Toast.makeText(this, "Your choose :" + all_routes[position],Toast.LENGTH_SHORT).show();
           route=all_routes[position];
       }
   }


   @Override
   public void onNothingSelected(AdapterView<?> parent) {

   }
}



