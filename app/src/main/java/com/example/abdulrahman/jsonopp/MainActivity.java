package com.example.abdulrahman.jsonopp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.jsn);
        String s="{\n" +
                "\t\"id\": \"0001\",\n" +
                "\t\"type\": \"donut\",\n" +
                "\t\"name\": \"Cake\",\n" +
                "\t\"ppu\": 0.55,\n" +
                "\t\"batters\":\n" +
                "\t\t{\n" +
                "\t\t\t\"batter\":\n" +
                "\t\t\t\t[\n" +
                "\t\t\t\t\t{ \"id\": \"1001\", \"type\": \"Regular\" },\n" +
                "\t\t\t\t\t{ \"id\": \"1002\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t\t\t{ \"id\": \"1003\", \"type\": \"Blueberry\" },\n" +
                "\t\t\t\t\t{ \"id\": \"1004\", \"type\": \"Devil's Food\" }\n" +
                "\t\t\t\t]\n" +
                "\t\t},\n" +
                "\t\"topping\":\n" +
                "\t\t[\n" +
                "\t\t\t{ \"id\": \"5001\", \"type\": \"None\" },\n" +
                "\t\t\t{ \"id\": \"5002\", \"type\": \"Glazed\" },\n" +
                "\t\t\t{ \"id\": \"5005\", \"type\": \"Sugar\" },\n" +
                "\t\t\t{ \"id\": \"5007\", \"type\": \"Powdered Sugar\" },\n" +
                "\t\t\t{ \"id\": \"5006\", \"type\": \"Chocolate with Sprinkles\" },\n" +
                "\t\t\t{ \"id\": \"5003\", \"type\": \"Chocolate\" },\n" +
                "\t\t\t{ \"id\": \"5004\", \"type\": \"Maple\" }\n" +
                "\t\t]\n" +
                "}";


        try {
            JSONObject object=new JSONObject(s);
            //JSONObject object1=object.getJSONObject("glossary");
            //String s1= object.getString("id");
            JSONObject o1=object.getJSONObject("batters");
            JSONArray array=object.getJSONArray("topping");
            String res="";
            for (int i=0;i<array.length();i++){
                res+=array.getJSONObject(i).getString("id")+" "+array.getJSONObject(i).getString("type")+"\n";
            }
            textView.setText(res);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
