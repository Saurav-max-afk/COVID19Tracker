package com.aptron.covid19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class MyCustomAdapter1 extends ArrayAdapter<CountryModel2> {

    private Context context;
    private List<CountryModel2> countryModelslist3;
    private List<CountryModel2> countryModelslistFiltered3;

    public MyCustomAdapter1( Context context, List<CountryModel2> countryModelslist3) {
        super(context, R.layout.listcustom,countryModelslist3);
        this.context=context;
        this.countryModelslist3=countryModelslist3;
        this.countryModelslistFiltered3= countryModelslist3;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listcustom,null,true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);

        tvCountryName.setText(countryModelslistFiltered3.get(position).getState());



        return view;
    }

    @Override
    public int getCount() {
        return countryModelslistFiltered3.size();
    }

    @Nullable
    @Override
    public CountryModel2 getItem(int position) {
        return countryModelslistFiltered3.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter=new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults=new FilterResults();
                if(constraint== null || constraint.length() == 0)
                {
                    filterResults.count = countryModelslist3.size();
                    filterResults.values = countryModelslist3;


                }

                else {
                    List<CountryModel2> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (CountryModel2 itemsModel:countryModelslist3)
                    {
                        if(itemsModel.getState().toLowerCase().contains(searchStr)) {
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count= resultsModel.size();
                        filterResults.values=resultsModel;
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                countryModelslistFiltered3=(List<CountryModel2>) results.values;
                Main3Activity.countryModelslist3=(List<CountryModel2>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }
}
