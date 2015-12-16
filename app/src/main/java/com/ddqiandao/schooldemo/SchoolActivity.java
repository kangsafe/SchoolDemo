package com.ddqiandao.schooldemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SchoolActivity extends AppCompatActivity {
    public static boolean firstOpening=true;


    // TODO: See init() for initialization!
    // TODO: Title -- Add other items here in strings.xml
    private static String[] titles   = null;

    /**
     *{@value TIPS_SHOW the handler msg to show tips}
     */
    private static final int TIPS_SHOW=0;
    private static final int POP_WINDOW_SHOW=1;

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    //add constant here
    private static final int FILE_CHOOSER=0;
    private static final int FULL_SCREEN_VIDEO=1;
    private static final int TBS_COOKIE=2;
    private static final int JAVA_TO_JS=3;
    private static final int TBS_WEB=4;
    private static final int TBS_VIDEO=5;
    private static final int TBS_IMAGE=6;
    private static final int TBS_DB=7;
    private static final int TBS_FIRST_X5=8;
    private static final int TBS_NEW_WINDOW=9;
    private static final int SYS_WEB=10;
    private static final int TBS_FLASH=11;
    private static final int TBS_WEB_NOTICE=12;
    private static final int TBS_BUILDING=13;
    private static final int TBS_LONG_PRESS=14;

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //for view init
    private Context mContext = null;
    private SimpleAdapter gridAdapter;
    private GridView gridView;
    private ArrayList<HashMap<String, Object>> items ;



    private static boolean main_initialized = false;

    private volatile boolean isX5WebViewEnabled = false;

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mContext = this;
        if (!main_initialized) {
            this.new_init();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    //Activity OnResume
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        this.new_init();

        //this.gridView=(GridView) this.findViewById(R.id.item_grid);
        this.gridView.setAdapter(gridAdapter);
        super.onResume();
    }


    //////////////////////////////////////////////////////////////////////////////////
    //initiate new UI content
    private void new_init(){
        items = new ArrayList<HashMap<String, Object>>();
        this.gridView=(GridView) this.findViewById(R.id.item_grid);
        titles = getResources().getStringArray(R.array.index_titles);
        int[] iconResourse={
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

            item.put("title",titles[i]);
            item.put("icon", iconResourse[i]);


            items.add(item);
        }
        this.gridAdapter = new SimpleAdapter(this, items, R.layout.function_block,
                new String[] { "title" ,"icon"},
                new int[] { R.id.Item_text,R.id.Item_bt });
        if(null!=this.gridView){
            this.gridView.setAdapter(gridAdapter);
            this.gridAdapter.notifyDataSetChanged();
            this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> gridView, View view, int position, long id) {
                    HashMap<String, String> item = (HashMap<String, String>) gridView.getItemAtPosition(position);

                    String current_title = item.get("title");

                    Intent intent = null;

                }});


        }
        main_initialized = true;


    }

}