package com.rpt.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

class ListAdapter extends ArrayAdapter {
    List<Country> countries;
    Context context;

    public ListAdapter(Context context, List<Country> countries) {
        super(context, 0, countries);
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Country currentCountry = this.countries.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.country_list_item, parent, false);
        }

        TextView countryName = convertView.findViewById(R.id.tvCountryName);
        Button button = convertView.findViewById(R.id.btClickMe);

        countryName.setText(currentCountry.name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, currentCountry.capitol, Toast.LENGTH_SHORT).show();
                countries.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
