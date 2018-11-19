package spy.busdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by SPY on 6/23/2017.
 */

public class stoplist extends AppCompatActivity {
    TextView t1;
    String s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(spy.busdatabase.R.layout.stop_list);
        t1=(TextView)findViewById(spy.busdatabase.R.id.textView1);
        Intent i =getIntent();
        s=i.getStringExtra("path");
        t1.setText(s);
    }
}