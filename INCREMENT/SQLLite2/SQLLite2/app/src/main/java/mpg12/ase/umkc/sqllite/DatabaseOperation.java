package mpg12.ase.umkc.sqllite;

/**
 * Created by VINAYA on 2/24/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.internal.widget.ContentFrameLayout;
import android.util.Log;

/**
 * Created by Leela Gajula on 02/24/15.
 */
public class DatabaseOperation extends SQLiteOpenHelper {
    public static final int database_version =1;
    public String CREATE_QUERY = "CREATE TABLE "+ Tabledata.TableInfo.TABLE_NAME+"("+ Tabledata.TableInfo.NAME+" TEXT,"+ Tabledata.TableInfo.USER_NAME+" TEXT,"+ Tabledata.TableInfo.USER_PASS+" TEXT,"+Tabledata.TableInfo.CNF_PASS+ " TEXT,"+ Tabledata.TableInfo.MAIL_ID+" TEXT,"+ Tabledata.TableInfo.PHONE_NO+" TEXT);";
    public DatabaseOperation(Context context) {
        super(context, Tabledata.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("DatabaseOperations","DatabaseCreated");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("DatabaseOperations","TableCreated");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void putInformation(DatabaseOperation dob,String name,String uname,String password,String cnfpswd,String mailid,String phnno){
        SQLiteDatabase SQ = dob.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(Tabledata.TableInfo.NAME,name);
        cv.put(Tabledata.TableInfo.USER_NAME,uname);
        cv.put(Tabledata.TableInfo.USER_PASS,password);
        cv.put(Tabledata.TableInfo.CNF_PASS,phnno);
        cv.put(Tabledata.TableInfo.MAIL_ID,mailid);
        cv.put(Tabledata.TableInfo.PHONE_NO,phnno);

        long k=SQ.insert(Tabledata.TableInfo.TABLE_NAME,null,cv);
        Log.d("DatabaseOperations","OneRowInserted");

    }
    public Cursor getInformation(DatabaseOperation dbp){
        SQLiteDatabase SQ = dbp.getReadableDatabase();
        String[] columns = {Tabledata.TableInfo.NAME, Tabledata.TableInfo.USER_NAME,Tabledata.TableInfo.USER_PASS, Tabledata.TableInfo.CNF_PASS, Tabledata.TableInfo.MAIL_ID, Tabledata.TableInfo.PHONE_NO};
        Cursor CR= SQ.query(Tabledata.TableInfo.TABLE_NAME,columns,null,null,null,null,null);
        return CR;
    }
}
