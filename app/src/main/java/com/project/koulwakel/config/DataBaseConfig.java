package com.project.koulwakel.config;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.project.koulwakel.Dao.RepositoryJwtResponse;
import com.project.koulwakel.entity.JwtResponse;

@Database(entities = {JwtResponse.class} ,version = 4)
public  abstract class DataBaseConfig  extends RoomDatabase {



    public abstract RepositoryJwtResponse repositoryJwtResponse ();
}
