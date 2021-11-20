package com.example.myvulnerableapp;

public class User {
    private int _id;
    private String _userName;
    private String _password;
    private int _phone;

    public User(){}

    public User(String _userName, String _password, int _phone){
        this._userName = _userName;
        this._password = _password;
        this._phone = _phone;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_userName() {
        return _userName;
    }

    public void set_userName(String _userName) {
        this._userName = _userName;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public int get_phone() {
        return _phone;
    }

    public void set_phone(int _phone) {
        this._phone = _phone;
    }
}
