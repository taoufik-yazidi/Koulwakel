package com.project.koulwakel.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Collection;


@Entity
public class JwtResponse {


    @PrimaryKey
    @NonNull
    private Long id ;

    @ColumnInfo
    private String accessToken;
    @ColumnInfo
    private String type = "Bearer";
    @ColumnInfo
    private String username;
    @Ignore
    private Collection<Object> authorities;

    @Ignore
    public JwtResponse(String accessToken, String type, String username, Collection<Object> authorities) {
        this.accessToken = accessToken;
        this.type = type;
        this.username = username;
        this.authorities = authorities;
    }

    public JwtResponse() {
    }

    @Ignore
    public JwtResponse(String accessToken, String type, String username) {
        this.accessToken = accessToken;
        this.type = type;
        this.username = username;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Object> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<Object> authorities) {
        this.authorities = authorities;
    }


}
