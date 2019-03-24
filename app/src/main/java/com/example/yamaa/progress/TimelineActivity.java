package com.example.yamaa.progress;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Adapter.TimeLineAdapter;
import Item.ItemInTimeline;
import Item.Time.MyTime;
import Item.Time.TimeAmount;

/**
 * Created by Yamaa on 2019/3/20.
 */

public class TimelineActivity extends AppCompatActivity {

    private List<ItemInTimeline> itemList = new ArrayList<>();
    private String TAG = "TimelineActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        Log.d(TAG,"setContentView");

        initItemList();
        Log.d(TAG,"initItemList");

        RecyclerView timeline = (RecyclerView) findViewById(R.id.timelineitem_RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        timeline.setLayoutManager(layoutManager);
        TimeLineAdapter adapter = new TimeLineAdapter(itemList,this);
        timeline.setAdapter(adapter);
        Log.d(TAG,"endOnCreate");
    }

    private void initItemList() {
        ItemInTimeline moyu = new ItemInTimeline("摸鱼", new MyTime(8,0), new TimeAmount(150));
        ItemInTimeline chuanhuo = new ItemInTimeline("传火", new MyTime(13,0), new TimeAmount(100));
        ItemInTimeline free1 = ItemInTimeline.getFreeItem(moyu,chuanhuo);
        ItemInTimeline dushu = new ItemInTimeline("读书", new MyTime(15,0), new TimeAmount(180));
        ItemInTimeline free2 = ItemInTimeline.getFreeItem(chuanhuo, dushu);
        ItemInTimeline duanlian = new ItemInTimeline("锻炼", new MyTime(20,0), new TimeAmount(80));
        ItemInTimeline free3 = ItemInTimeline.getFreeItem(dushu,duanlian);
        ItemInTimeline xizao = new ItemInTimeline("洗澡", new MyTime(22,0), new TimeAmount(30));
        ItemInTimeline free4 = ItemInTimeline.getFreeItem(duanlian, xizao);

        itemList.add(moyu);
        if(free1!=null){
            itemList.add(free1);
        }
        itemList.add(chuanhuo);
        if(free2!=null){
            itemList.add(free2);
        }
        itemList.add(dushu);
        if(free3!=null){
            itemList.add(free3);
        }
        itemList.add(duanlian);
        if(free4!=null){
            itemList.add(free4);
        }
        itemList.add(xizao);
    }
}
