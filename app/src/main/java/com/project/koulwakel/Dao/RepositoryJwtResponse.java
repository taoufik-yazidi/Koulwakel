package com.project.koulwakel.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.project.koulwakel.entity.JwtResponse;

@Dao
public interface RepositoryJwtResponse {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addResponse (JwtResponse jwtResponse);

    @Query("SELECT * FROM JwtResponse WHERE id IN (:id)")
    JwtResponse  LoadJwtResponseById(Long id);

    @Update(onConflict = OnConflictStrategy.FAIL)
    void UpdateJwtResponse (JwtResponse jwtResponse);
}
