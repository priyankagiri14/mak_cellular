package com.app.mak.cellular;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

import com.app.mak.cellular.AgentsList.AgentsList;
import com.app.mak.cellular.AnyAgentAllocation.AnyAgentAllocation;

public class AgentAllocationTab extends TabActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_allocation_tab);

        String batches[] = new String[getIntent().getExtras().getStringArray("allocation_stock").length];
        batches = getIntent().getExtras().getStringArray("allocation_stock");

        TabHost tabHost=findViewById(android.R.id.tabhost);
        TabHost.TabSpec spec;
        Intent intent;

        spec=tabHost.newTabSpec("Boxno");
        spec.setIndicator("Select Agent");
        intent=new Intent(this, AgentsList.class);
        intent.putExtra("allocation_stock",batches);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Pending stock");
        spec.setIndicator("Search Agent");
        intent=new Intent(this, AnyAgentAllocation.class);
        intent.putExtra("allocation_stock",batches);
        spec.setContent(intent);
        tabHost.addTab(spec);



        tabHost.setCurrentTab(0);
        if(tabHost.getCurrentTab() == 0)
        {
            tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#0C4B50")); // unselected
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title); //Unselected Tabs
            //tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FF0000")); // unselected
            tv.setTextColor(Color.parseColor("#FFFD6E"));
        }

        TextView tv = (TextView) tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title); //Unselected Tabs
        //tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#FF0000")); // unselected
        tv.setTextColor(Color.parseColor("#FFFD6E"));
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

                for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
                    TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
                    tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#098386")); // unselected
                    tv.setTextColor(Color.parseColor("#FFFD6E"));
                }

                tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#0C4B50")); // selected
                TextView tv = (TextView) tabHost.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
                tv.setTextColor(Color.parseColor("#FFFD6E"));

            }
        });
    }
}
