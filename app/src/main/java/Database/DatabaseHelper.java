package Database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import modal.User;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User Table Name
    private static final String TABLE_USER = "user";

    // User table column names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        // Drop user table if exists
        sqLiteDatabase.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(sqLiteDatabase);
    }


    public void addUser(User user){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // Inserting row
        sqLiteDatabase.insert(TABLE_USER, null, values);
        sqLiteDatabase.close();
    }


    public void updateUser(User user){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        sqLiteDatabase.update(TABLE_USER, values, COLUMN_USER_ID + " = ?", new String[]{String.valueOf(user.getId())});
        sqLiteDatabase.close();
    }

    public void deleteUser(User user){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        // delete the user record
        sqLiteDatabase.delete(TABLE_USER, COLUMN_USER_ID + " = ?", new String[]{String.valueOf(user.getId())});
        sqLiteDatabase.close();
    }

    public boolean checkUser(String email){

        // array of columns to fetch
        String[] columns =  {COLUMN_USER_ID};

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // querying user table
        Cursor cursor = sqLiteDatabase.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();


        if(cursorCount > 0) {
            return true;
        }


        return false;
    }

    public boolean checkUser(String email, String password){
        // array of columns to fetch
        String[] columns =  {COLUMN_USER_ID};

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND "+ COLUMN_USER_PASSWORD + " = ?";

        // selection argument
        String[] selectionArgs = {email, password};

        // querying user table
        Cursor cursor = sqLiteDatabase.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();


        if(cursorCount > 0) {
            return true;
        }


        return false;
    }

    
}
