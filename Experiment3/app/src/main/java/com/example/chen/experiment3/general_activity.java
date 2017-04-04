package com.example.chen.experiment3;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Chen on 2016/10/15.
 */

public class general_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generalpage);

        ListView contracts = (ListView)findViewById(R.id.contracts_list);
        final MyAdapter myAdapter = new MyAdapter(this);
        contracts.setAdapter(myAdapter);

        contracts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contract contract = myAdapter.getContracts().get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("contract", contract);

                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(general_activity.this, detail_activity.class);
                startActivity(intent);
            }
        });

        contracts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(general_activity.this);
                alert.setTitle("删除联系人");
                String name = myAdapter.getContracts().get(position).getName();
                alert.setMessage("确定删除联系人"+name+"?");
                alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myAdapter.getContracts().remove(position);
                        myAdapter.notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.create();
                alert.show();
                return true;
            }
        });
    }


}
