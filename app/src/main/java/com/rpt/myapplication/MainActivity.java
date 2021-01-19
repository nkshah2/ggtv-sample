package com.rpt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView countriesList;
    ArrayList<Country> countries = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries.clear();

        for (int i = 0; i < 10; i++) {
            countries.add(new Country("India" + i, "Delhi"));
            countries.add(new Country("United Kingdom" + i, "London"));
            countries.add(new Country("USA" + i, "Washington DC"));
            countries.add(new Country("Hello world" + i, "Test"));
            countries.add(new Country("Hi" + i, "Hello"));
        }

        countriesList = findViewById(R.id.lvCountryList);

        ListAdapter adapter = new ListAdapter(this, countries);
        countriesList.setAdapter(adapter);
    }

    void addCountry(String countryName, String capitol, int index) {
        countries.add(new Country(countryName + index, capitol));
    }
}