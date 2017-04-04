package com.example.chen.experiment3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Chen on 2016/10/16.
 */

public class detail_activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailpage);

        Bundle bundle = getIntent().getExtras();
        Contract contract = (Contract)bundle.getSerializable("contract");
        String Name = contract.getName();
        String Type = contract.getType();
        String Phone = contract.getPhone();
        String Belonging = contract.getBelonging();
        String Background = contract.getBackground();

        RelativeLayout top = (RelativeLayout)findViewById(R.id.top);
        top.setBackgroundColor(Color.parseColor(Background));

        String[] operations = new String[] {"编辑联系人","分享联系人", "加入黑名单", "删除联系人"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.operation, operations);
        ListView operation = (ListView)findViewById(R.id.operations);
        operation.setAdapter(arrayAdapter);

        ImageButton back = (ImageButton)findViewById(R.id.back);
        back.setBackground(getResources().getDrawable(R.drawable.back));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(detail_activity.this, general_activity.class);
                startActivity(intent);
            }
        });

        final ImageButton star = (ImageButton)findViewById(R.id.star);
        star.setBackground(getResources().getDrawable(R.drawable.empty_star));
        star.setTag(0);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag = (int)star.getTag();
                if (flag == 0) {
                    star.setBackground(getResources().getDrawable(R.drawable.full_star));
                    star.setTag(1);
                } else {
                    star.setBackground(getResources().getDrawable(R.drawable.empty_star));
                    star.setTag(0);
                }
            }
        });

        TextView detailName = (TextView)findViewById(R.id.detailName);
        detailName.setText(Name);

        TextView phone = (TextView)findViewById(R.id.Phone);
        phone.setText(Phone);

        TextView type = (TextView)findViewById(R.id.Type);
        type.setText(Type);

        TextView belonging = (TextView)findViewById(R.id.Belonging);
        belonging.setText(Belonging);

    }
}
