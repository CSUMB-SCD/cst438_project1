package com.firebase.database.DB;



import com.google.firebase.database.*;


public class DB {
    private DatabaseReference mdb;

    public DB()
    {
        mdb = FirebaseDatabase.getInstance().getReference(); //Initialize Database for read/write
    }
}
