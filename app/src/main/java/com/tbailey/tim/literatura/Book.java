package com.tbailey.tim.literatura;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Tim on 5/30/2018.
 */

public class Book implements Serializable{
    private String openLibraryId;
    private String author;
    private String title;
    private String isbn;


    public String getOpenLibraryId(){
        return openLibraryId;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCoverUrl(){
        return "https://covers.openlibrary.org/b/olid/" + openLibraryId + "-M.jpg?default=false";
    }

    public String getLargeCoverUrl(){
        return "http://covers.openlibrary.org/b/olid/" + openLibraryId + "-L.jpg?default=false";
    }

    public static Book fromJSon(JSONObject jsonObject){
        Book book = new Book();
        try{
            if (jsonObject.has("cover_edition_key")){
                book.openLibraryId = jsonObject.getString("cover_edition_key");
            }else if(jsonObject.has("edition_key")){
                final JSONArray ids = jsonObject.getJSONArray("edition_key");
                book.openLibraryId = ids.getString(0);
            }
            book.title = jsonObject.has("title_suggest") ? jsonObject.getString("title_suggest"): "";
            book.author = getAuthor(jsonObject);
            book.isbn = getIsbn(jsonObject);
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
        return book;
    }
    private static String getAuthor(JSONObject jsonObject){
        try{
            final JSONArray authors = jsonObject.getJSONArray("author_name");
            int numAuthors = authors.length();
            final String[] authorStrings = new String[numAuthors];
            for (int i = 0; i < numAuthors; i++){
                authorStrings[i] = authors.getString(i);
            }
            return TextUtils.join(", ", authorStrings);

        } catch (JSONException e){
            return "";
        }
    }
    private static String getIsbn(JSONObject jsonObject){
        try{
            final JSONArray isbn = jsonObject.getJSONArray("isbn");
            int numIsbn = isbn.length();
            final String[] isbnStrings = new String[numIsbn];
            for (int i = 0; i < numIsbn; i++){
                isbnStrings[i] = isbn.getString(i);
            }
            return isbnStrings[0];

        } catch (JSONException e){
            return "";
        }
    }
    public static ArrayList<Book> fromJson(JSONArray jsonArray){
        ArrayList<Book> books = new ArrayList(jsonArray.length());

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject bookJson = null;
            try{
                bookJson = jsonArray.getJSONObject(i);
            } catch (Exception e){
                e.printStackTrace();
                continue;
            }
            Book book  = Book.fromJSon(bookJson);
            if (books != null) {
                books.add(book);
            }
        }
        return books;
    }
}


