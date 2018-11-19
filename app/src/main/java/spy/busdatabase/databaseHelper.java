package spy.busdatabase;

/**
 * Created by SPY on 5/31/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


class databaseHelper extends SQLiteOpenHelper  {
public static final String DATABASE_NAME = "busdatabase.db";
public static final String TABLE_NAME1 = "route_table";

public static final String COL1 = "route_id1";
public static final String COL2 = "stops";
public static final String COL3 = "station_order";

/*public static final String TABLE_NAME2 = "checkpoint_table";

public static final String COL4 = "route_id2";
public static final String COL5 = "AC1";
public static final String COL6 = "AC2";
public static final String COL7 = "AC5";
public static final String COL8 = "1A";
public static final String COL9 = "3A";*/

public databaseHelper(Context context) {
   super(context, DATABASE_NAME, null, 1);

}

@Override
public void onCreate(SQLiteDatabase db) {
   db.execSQL(" create table " + TABLE_NAME1 + "(" + COL1 + " TEXT ," + COL2 + " TEXT," + COL3 + " TEXT,"+"PRIMARY KEY("+COL1+","+COL3+"));");
   insertData(db);
}

@Override
public void onUpgrade(SQLiteDatabase db, int i, int i1) {
   db.execSQL("DROP TABLE IF EXISTS "+" " + TABLE_NAME1);
}

public void insertData(SQLiteDatabase db) {

   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC1', 'sanganer town', '1');");
  db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC1', 'sanganer stadium', '2');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC1', 'kundan nagar', '3');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC1', 'sanganer thana', '4');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC1', 'datti vada', '5');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC1', 'thadi market', '6');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC2', 'mahatma gandhi hospital', '1');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC2', 'bosch limited', '2');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC2', 'goner railway fatak', '3');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC2', 'chatrala circle', '4');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC2', 'genpat sitapura', '5');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC2', 'patel marg', '6');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC2', 'kundan nagar', '7');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC5', 'agarwal farm', '1');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC5', 'thadi market', '2');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC5', 'vijay path', '3');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC5', 'meera marg', '4');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('AC5', 'patel marg', '5');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('1A', 'vki roadno.17', '1');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('1A', 'vki roadno.14', '2');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('1A', 'vki roadno.12', '3');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('1A', 'nanda canteen', '4');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('1A', '32 dukane', '5');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('3A', 'sanganer town', '1');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('3A', 'sanganer stadium', '2');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('3A', 'kundan nagar', '3');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('3A', 'sanganer thana', '4');");
   db.execSQL("insert into " + TABLE_NAME1 + " (" + COL1 + ", " + COL2 + ", " + COL3
           + ") values('3A', 'datti vada', '5');");
}

public String[] fetchid(String s) {

   String[] result;
  /* if (s.equals(d)) {
       result[0]="0";
       return result;
   }*/
   Cursor res;

   SQLiteDatabase db = this.getReadableDatabase();

   try
   {

           res = db.rawQuery("select * from " + TABLE_NAME1 + " where " + COL2 + " = '" + s + "'", null);


         result=new String[res.getCount()];
         res.moveToFirst();
         Log.e("asd1",Integer.toString(res.getCount()));
         for (int i=0;i<res.getCount();i++)
          {
           result[i] = res.getString(res.getColumnIndex(COL1));
           res.moveToNext();
           Log.e("asd1.1",result[i]);
         }
       return result;
   }



   finally {
       db.close();

   }

}

public  String[] fetch1stop(String s,String d) {

   String[] result;


   Cursor res1;

   SQLiteDatabase db = this.getReadableDatabase();


   Log.e("asd4",s+"&"+d);
   try
   {

       res1 = db.rawQuery( "select "+COL2+" from " + TABLE_NAME1 + " where " + COL1 + " = '" + s + "'" +" INTERSECT " +
               " select "+COL2+" from " + TABLE_NAME1 + " where " + COL1 + " = '" + d + "'", null);

       Log.e("asd4",Integer.toString(res1.getCount()));
       result=new String[res1.getCount()];
       res1.moveToFirst();


       for (int i=0;i<res1.getCount();i++)
       {

           result[i] = res1.getString(res1.getColumnIndex(COL2));
           Log.e("asd4",result[i]);
           res1.moveToNext();
       }
       return result;
   }



   finally {
       db.close();

   }

}

public String[] fetch2stop(String s,String d) {
   String result[];
   Cursor res2;
   SQLiteDatabase db = this.getReadableDatabase();
   Log.e("fetch2",s+" & "+ d);
 try
 {
     res2 =db.rawQuery(" select " + COL1 + " from (select distinct "+ COL1 +" from "+ TABLE_NAME1 +" where "+
                     COL2 +" IN(select "+ COL2 +" from "+TABLE_NAME1+" where "+COL1+" = '"+s+"') " +
                     "intersect select distinct "+ COL1 +" from "+TABLE_NAME1+" where "+ COL2 +" IN(select "+COL2+
                     " from "+TABLE_NAME1+" where "+COL1+" = '"+d+"')) where "+COL1+" NOT IN('"+s+"' , '"+d+"')"

       ,null);
     Log.e("fetch2",Integer.toString(res2.getCount()));
     result = new String[res2.getCount()];
       res2.moveToFirst();
     for(int i=0;i<res2.getCount();i++) {

     result[i]=res2.getString(res2.getColumnIndex(COL1));
         Log.e("fetch2",result[i] );
         res2.moveToNext();
     }

   return result;
  }
   finally
   {
       db.close();
   }
}

    public String[] getallstops(String s) {
        String result[];
        Cursor res3;
        SQLiteDatabase db = this.getReadableDatabase();
        Log.e("getallstops",s);
        try
        {
            res3 =db.rawQuery(" select " + COL2+"," +COL3+ " from "+ TABLE_NAME1 +" where "+COL1+" = '"+s+"' "+
                    " order by "+COL3,null);


            Log.e("getallstops",Integer.toString(res3.getCount()));
            result = new String[res3.getCount()];
            res3.moveToFirst();
            for(int i=0;i<res3.getCount();i++) {

                result[i]=res3.getString(res3.getColumnIndex(COL2));
                Log.e("getallstops",result[i] );
                res3.moveToNext();
            }

            return result;
        }
        finally
        {
            db.close();
        }
    }
    public String[] getallbetweenstops(String id,String s1,String s2) {
        String result[];
        Cursor res4;
        SQLiteDatabase db = this.getReadableDatabase();
        Log.e("getallbetweenstops",id+"&"+s1+"&"+s2);
        try
        {
            res4 =db.rawQuery(" select "+ COL2+","+COL3+" from "+TABLE_NAME1+" where "+COL1+" = '"+id+"'  and ("+COL3+" > " +
                    "(select "+COL3+" from "+TABLE_NAME1+" where "+COL1+" = '"+id+"' and "+COL2+" = '"+s1+"') and " +COL3+
                    " < (select "+ COL3+ " from "+ TABLE_NAME1+ " where "+COL1+" = '"+id+"' and "+COL2+" = '"+s2+"'))" ,null);

            Log.e("getallbetweenstops",Integer.toString(res4.getCount()));
            result = new String[res4.getCount()];
            res4.moveToFirst();
            for(int i=0;i<res4.getCount();i++) {

                result[i]=res4.getString(res4.getColumnIndex(COL2));
                Log.e("getallbetweenstops",result[i] );
                res4.moveToNext();
            }

            return result;
        }
        finally
        {
            db.close();
        }
    }


}

