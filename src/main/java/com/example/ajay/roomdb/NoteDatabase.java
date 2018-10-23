package com.example.ajay.roomdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import java.lang.invoke.ConstantCallSite;

@Database(entities = {Note.class} , version = 1,exportSchema = false)
@TypeConverters({DateRoomConverter.class})
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase noteDb;

    public abstract NoteDao getnoteDao();

    public static NoteDatabase getInstance(Context context){

        if(noteDb==null){
            noteDb = buildNoteDataBaseInstance(context);
        }
        return noteDb;
    }

    public void closeDb(){
        noteDb=null;
    }


    private static NoteDatabase buildNoteDataBaseInstance(Context ctx){
        return Room.databaseBuilder(ctx,NoteDatabase.class,"note_db").allowMainThreadQueries().build();
    }

}
