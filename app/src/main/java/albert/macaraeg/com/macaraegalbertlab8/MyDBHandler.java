package albert.macaraeg.com.macaraegalbertlab8;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "details.db";
    public static final String TABLE_DETAILS = "details";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TEXTFULLNAME = "_textfullname";
    public static final String COLUMN_AGE = "_textage";
    public static final String COLUMN_GENDER = "_textgender";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_DETAILS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEXTFULLNAME + " TEXT, " +
                COLUMN_AGE + " TEXT, " +
                COLUMN_GENDER + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DETAILS);
        onCreate(db);

    }

    //Add new row.
    public void addDetails(Details details){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEXTFULLNAME, details.get_textfullname());
        values.put(COLUMN_AGE, details.get_textage());
        values.put(COLUMN_GENDER, details.get_textgender());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DETAILS,null, values);
        db.close();
    }
    //Search details.
    public void searchDetails(String detailsName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("SELECT FROM " + TABLE_DETAILS + "WHERE " + COLUMN_TEXTFULLNAME + "=\"" + detailsName + "\";" );
    }

    //Show details.
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_DETAILS;

        //Cursor.
        Cursor c = db.rawQuery(query, null);
        //Move to first.
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("detailsname"))!=null){
                dbString += c.getString(c.getColumnIndex("detailsname"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }




}
