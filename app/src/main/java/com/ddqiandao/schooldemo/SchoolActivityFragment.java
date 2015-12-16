package com.ddqiandao.schooldemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ddqiandao.schooldemo.R;

public class SchoolActivityFragment extends Fragment {

    private static String[] titles   = null;
    private SimpleAdapter gridAdapter;
    private GridView gridView;
    private ArrayList<HashMap<String, Object>> items ;

    public SchoolActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_school, container, false);
//        Button bt_setting = (Button) v.findViewById(R.id.bt_setting);
//        bt_setting.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//
//        Button bt_help = (Button) v.findViewById(R.id.bt_help);
//        bt_help.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//            }
//        });

        items = new ArrayList<HashMap<String, Object>>();
        this.gridView = (GridView) v.findViewById(R.id.item_grid);
        titles = getResources().getStringArray(R.array.index_titles);
        int[] iconResourse = {
                R.drawable.filechooser,
                R.drawable.fullscreen,
                R.drawable.cookie,
                R.drawable.jsjava,
                R.drawable.tbsweb,
                R.drawable.tbsvideo,
                R.drawable.imageselect,
                R.drawable.tbs_db,
                R.drawable.firstx5,
                R.drawable.webviewtransport,
                R.drawable.sysweb,
                R.drawable.flash,
                R.drawable.webtips,

                R.drawable.securityjs,
                R.drawable.longclick,
        };

        HashMap<String, Object> item = null;
        //HashMap<String, ImageView> block = null;
        for (int i = 0; i < titles.length; i++) {
            item = new HashMap<String, Object>();

            item.put("title", titles[i]);
            item.put("icon", iconResourse[i]);


            items.add(item);
        }
        this.gridAdapter = new SimpleAdapter(v.getContext().getApplicationContext(), items, R.layout.function_block,
                new String[]{"title", "icon"},
                new int[]{R.id.Item_text, R.id.Item_bt});
        if (null != this.gridView) {
            this.gridView.setAdapter(gridAdapter);
            this.gridAdapter.notifyDataSetChanged();
            this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> gridView, View view, int position, long id) {
                    HashMap<String, String> item = (HashMap<String, String>) gridView.getItemAtPosition(position);

                    String current_title = item.get("title");

                    Intent intent = null;

                }
            });


        }
        return v;
    }

    public class SchoolAdapter extends SimpleAdapter{

        /**
         * Constructor
         *
         * @param context  The context where the View associated with this SimpleAdapter is running
         * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
         *                 Maps contain the data for each row, and should include all the entries specified in
         *                 "from"
         * @param resource Resource identifier of a view layout that defines the views for this list
         *                 item. The layout file should include at least those named views defined in "to"
         * @param from     A list of column names that will be added to the Map associated with each
         *                 item.
         * @param to       The views that should display column in the "from" parameter. These should all be
         *                 TextViews. The first N views in this list are given the values of the first N columns
         */
        public SchoolAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }
    }
}
