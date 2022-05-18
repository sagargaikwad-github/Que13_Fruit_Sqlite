package com.example.que13_sqlite_fruitdata;

public class FruitData {
    int id;
    int image;
    String name;
    String short_desc;
    String desc;
    String email;
    int favourite;



    public FruitData(int id, int image, String name, String short_desc, String desc, String email, int favourite) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.short_desc = short_desc;
        this.email = email;
        this.favourite=favourite;


    }

    public FruitData(DBManager dbManager) {
    }


    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
