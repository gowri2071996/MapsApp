package com.example.mapsapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mapsapp.Model.PlaceModel;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AddressStore";
    private static final String TABLE_ADDRESS = "places";

    private static final String KEY_PLACE_ID = "placeID";
    private static final String KEY_PLACE_NAME = "placeName";
    private static final String KEY_PLACE_ADDRESS = "placeAddress";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLACE_TABLE = "CREATE TABLE IF NOT EXISTS "
                + TABLE_ADDRESS + "("
                + KEY_PLACE_ID + " INTEGER (10) PRIMARY KEY, "
//                + KEY_PLACE_ID + " INTEGER (10) PRIMARY KEY AUTOINCREMENT, "
                + KEY_PLACE_NAME + " TEXT, "
                + KEY_PLACE_ADDRESS + " TEXT" + ")";
        db.execSQL(CREATE_PLACE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRESS);
        onCreate(db);
    }

    // Add New Address
    public void addAddress(PlaceModel place) {
        SQLiteDatabase db = this.getWritableDatabase();

        //Content values use KEY-VALUE pair concept

        ContentValues values = new ContentValues();
        values.put(KEY_PLACE_ID, place.getPlaceID());
        values.put(KEY_PLACE_NAME, place.getPlaceName());
        values.put(KEY_PLACE_ADDRESS, place.getPlaceAddress());
        db.insert(TABLE_ADDRESS, null, values);
        db.close();
    }

    // Getting All Address
    public List<PlaceModel> getAlladdress() {
        List<PlaceModel> studentList = new ArrayList<PlaceModel>();
        String selectQuery = "SELECT  * FROM " + TABLE_ADDRESS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                PlaceModel place = new PlaceModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2));

                studentList.add(place);
            } while (cursor.moveToNext());
        }
        // return Address list
        return studentList;
    }


}