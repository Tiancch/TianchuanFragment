package com.example.user.tianchuanfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentOne extends Fragment {

    ListView listView;
    ArrayAdapter<String> adapter;
    String[] cities = {"New York","London","Shanghai","Calgary","Paris"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1,container,false);
        listView = (ListView)view.findViewById(R.id.list_view);

        adapter = new ArrayAdapter<String>(getActivity(),R.layout.listview,R.id.row_item,cities);
//        adapter = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item, cities);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTwo fragmentTwo = (FragmentTwo)getFragmentManager().findFragmentById(R.id.fr_2);
                Toast.makeText(fragmentTwo.getActivity(),cities[position]+ " is a wonderful city",Toast.LENGTH_LONG).show();

            }
        });
        return view;
    }




}
