package com.dozygeek.lazyrecipes.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Recipe implements Parcelable {

    private String id;
    private String title;
    private String[] ingredients;
    private String publisher;
    private String imageUrl;
    private float socialRating; //socialUrl in original api response

    public Recipe(String id, String title, String[] ingredients, String publisher, String imageUrl, float socialRating) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
        this.socialRating = socialRating;
    }

    public Recipe() {
    }

    protected Recipe(Parcel in) {
        id = in.readString();
        title = in.readString();
        ingredients = in.createStringArray();
        publisher = in.readString();
        imageUrl = in.readString();
        socialRating = in.readFloat();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getSocialRating() {
        return socialRating;
    }

    public void setSocialRating(float socialRating) {
        this.socialRating = socialRating;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", publisher='" + publisher + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", socialRating=" + socialRating +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeStringArray(ingredients);
        parcel.writeString(publisher);
        parcel.writeString(imageUrl);
        parcel.writeFloat(socialRating);
    }
}
