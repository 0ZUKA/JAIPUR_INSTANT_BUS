package spy.busdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by SPY on 6/22/2017.
 */

public class routelist extends AppCompatActivity {

    ListView l1;
    TextView t1,t2;

    String s1,route_list[],start,end;
    int z;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(spy.busdatabase.R.layout.route_list);
        l1=(ListView)findViewById(spy.busdatabase.R.id.list1);
        t1=(TextView)findViewById(spy.busdatabase.R.id.textView1);
        t2=(TextView)findViewById(spy.busdatabase.R.id.textView2);
        Intent i = getIntent();
        route_list=i.getStringArrayExtra("route_list");

        z=route_list.length;
        start = i.getStringExtra("Source");
        end = i.getStringExtra("Destination");
            if(z!=0)
            {
                t2.setText("Total Stops : " +z);
            }

        if(route_list!=null)
        {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.test_list_item, route_list);
            l1.setAdapter(adapter);
        }
        if (!(start.isEmpty())&& !(end.isEmpty())) {
            t1.setText("Start : " +start + "       End : " +end);
        }

    }
}
