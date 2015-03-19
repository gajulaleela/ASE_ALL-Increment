package mpg12.ase.umkc.sqllite;

/**
 * Created by VINAYA on 2/24/2015.
 */
import android.provider.BaseColumns;

/**
 * Created by Leela Gajula on 02/24/15.
 */
public class Tabledata {
    public Tabledata(){

    }
    public static abstract class TableInfo implements BaseColumns{


        public static final String NAME = "name" ;
        public static final String USER_NAME = "username" ;
        public static final String USER_PASS = "user_pass";
        public static final String CNF_PASS = "cnf_pass";
        public static final String MAIL_ID = "mailid" ;
        public static final String PHONE_NO = "phoneno" ;
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "Table_Info";
    }
}
