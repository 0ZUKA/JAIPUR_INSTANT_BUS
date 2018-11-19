package spy.busdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SPY on 6/14/2017.
 */

public class pathslist extends AppCompatActivity {

  ListView l1;
    TextView t1;
    static ArrayList<String> paths_list = new ArrayList<String>();
    String[] paths_list2;
    static ArrayList<String> paths_list3 = new ArrayList<String>();
    static ArrayList<String> paths_stops = new ArrayList<String>();
     String s1[],start,end;
     String s2="";
  int n;
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(spy.busdatabase.R.layout.paths_list);
    l1=(ListView)findViewById(spy.busdatabase.R.id.list1);
      t1=(TextView)findViewById(spy.busdatabase.R.id.textView1);
      Intent i = getIntent();
      paths_list=i.getStringArrayListExtra("different_Paths_list");
      paths_list2=i.getStringArrayExtra("different_Paths_list2");
    paths_list3=i.getStringArrayListExtra("different_Paths_list3");
      paths_stops=i.getStringArrayListExtra("different_Paths_stop");
      s1=i.getStringArrayExtra("direct route");
    start = i.getStringExtra("Source");
    end = i.getStringExtra("Destination");

      for(int u=0;u<paths_list.size();u++)
      {
          paths_list.set(u,"PATH_NO. "+(u+1)+paths_list.get(u));

      }
    if (s1 != null)
    {

      for(int j=0;j<s1.length;j++)
      {
               n=j;
              if((n==s1.length-1))
              {
                s2=s2+s1[j];
              }
              else{  s2=s2+s1[j]+",";}

      }
        t1.setText("Direct path : " + start + "-->" + s2 + "-->" + end);

    }
    else{
      t1.setText("no direct path");
    }
    if(!paths_list.isEmpty())
    {
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.test_list_item, paths_list);
      l1.setAdapter(adapter);
    }
    l1.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          Intent i = new Intent(getApplicationContext(),stoplist.class);
           // paths_list2.indexOf(paths_list.get(position));
            Log.e("x1", paths_list.get(position));
            Log.e("x1", paths_list.get(0));
            Log.e("x1", paths_list3.get(position));
          Log.e("x1", paths_list2[0]);
          Log.e("x1", String.valueOf(Arrays.asList(paths_list2).indexOf(paths_list3.get(0))));
            i.putExtra("path",paths_stops.get(Arrays.asList(paths_list2).indexOf(paths_list3.get(position))));
            startActivity(i);

        }
    });
  }
}
