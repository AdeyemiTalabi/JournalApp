package com.example.google.journal_app.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.google.journal_app.model.Register;

import java.util.ArrayList;
import java.util.List;

// 1.
public class DatabaseHelper extends SQLiteOpenHelper {

    // 4.     //  ===== start =======
    private static final int DATABASE_VERSION = 1;

//    private static final String DATABASE_NAME = "UserManager.db";
//    private static final String COLUMN_USER_ID = "user_id";
//    private static final String COLUMN_USER_NAME = "user_name";
//    private static final String COLUMN_USER_EMAIL = "user_email";
//    private static final String COLUMN_USER_PASSWORD = "user_password";


    private static final String DATABASE_NAME = "MyJournal.db";
    private static final String TABLE_REGISTER = "register";
    private static final String COLUMN_REGISTER_ID = "reg_id";
    private static final String COLUMN_REGISTER_NAME = "reg_name";
    private static final String COLUMN_REGISTER_EMAIL = "reg_email";
    private static final String COLUMN_REGISTER_PASSWORD = "reg_password";

    // 3.
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION); // 5.
    }

    // 2.
    // 7.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_REGISTER + " (" +
                        COLUMN_REGISTER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_REGISTER_NAME + " TEXT," +
                        COLUMN_REGISTER_EMAIL + " TEXT," +
                        COLUMN_REGISTER_PASSWORD + " TEXT" +
                        ")";

        // 8.
        db.execSQL(query);

        // 9.
        String delete_query =
                "DROP TABLE IF EXISTS " + TABLE_REGISTER;
    }

    // 10.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // 11.  Create tables again
        onCreate(db);

    }

    // 12.
    public void addRegister(Register register) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_REGISTER_NAME, register.getName());
        values.put(COLUMN_REGISTER_EMAIL, register.getEmail());
        values.put(COLUMN_REGISTER_PASSWORD, register.getPassword());

        //13. Inserting Row
        db.insert(TABLE_REGISTER, null, values);
        db.close();
    }

    // 14. Array fetch all registered users and list them
    public List<Register> getAllUser() {
        String[] columns = {
                COLUMN_REGISTER_ID,
                COLUMN_REGISTER_EMAIL,
                COLUMN_REGISTER_NAME,
                COLUMN_REGISTER_PASSWORD

        };
        // 15. sorting the rows in ascending order
        String sortOrder =
                COLUMN_REGISTER_NAME + " ASC";
        List<Register> userList = new ArrayList<Register>();
        SQLiteDatabase db = this.getReadableDatabase();

        // 16. to fetch records from register table.
        Cursor cursor = db.query(TABLE_REGISTER,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

        // 17. added all list
        if (cursor.moveToFirst()) {
            do {
                Register user = new Register();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_REGISTER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_REGISTER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_REGISTER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_REGISTER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

     // 18. to update register record
    public void updateUser(Register register) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_REGISTER_NAME, register.getName());
        values.put(COLUMN_REGISTER_EMAIL, register.getEmail());
        values.put(COLUMN_REGISTER_PASSWORD, register.getPassword());

        // 19. updating row
        db.update(TABLE_REGISTER, values, COLUMN_REGISTER_ID + " = ?",
                new String[]{String.valueOf(register.getId())});
        db.close();
    }

    // 20. to check if user exist or not
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_REGISTER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_REGISTER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // 21. to select register user table with where clause condition

        Cursor cursor = db.query(TABLE_REGISTER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    //  ===== end =======
}

