package com.example.chen.experiment3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Chen on 2016/10/16.
 */

public class MyAdapter extends BaseAdapter {
    private List<Contract> contracts;
    private Context context;
    public MyAdapter(Context _context) {
        context = _context;
        contracts = new ArrayList<>();
        contracts.add(new Contract("Aaron", "17715523654", "手机", "江苏苏州电信", "#BB4C3B"));
        contracts.add(new Contract("Elvis", "18825653224", "手机", "广东揭阳移动", "#c48d30"));
        contracts.add(new Contract("David", "15052116654", "手机", "江苏无锡移动", "#4469b0"));
        contracts.add(new Contract("Edwin", "18854211875", "手机", "山东青岛移动", "#20A17B"));
        contracts.add(new Contract("Frank", "13955188541", "手机", "安徽合肥移动", "#BB4C3B"));
        contracts.add(new Contract("Joshua", "13621574410", "手机", "江苏苏州移动", "#c48d30"));
        contracts.add(new Contract("Ivan", "15684122771", "手机", "山东烟台联通", "#4469b0"));
        contracts.add(new Contract("Mark", "17765213579", "手机", "广东珠海电信 ", "#20A17B"));
        contracts.add(new Contract("Joseph", "13315466578", "手机", "河北石家庄电信", "#BB4C3B"));
        contracts.add(new Contract("Phoebe", "17895466428", "手机", "山东东营移动", "#c48d30"));
    }
    public List<Contract> getContracts() {
        return contracts;
    }
    @Override
    public int getCount() {
        if (contracts == null) {
            return 0;
        }
        return contracts.size();
    }

    @Override
    public Object getItem(int position) {
        if (contracts == null) {
            return null;
        }
        return contracts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
        }
        TextView Initial = (TextView)convertView.findViewById(R.id.Initial);
        TextView Name = (TextView)convertView.findViewById(R.id.Name);


        Initial.setText(contracts.get(position).getName().substring(0, 1));
        Name.setText(contracts.get(position).getName());

        return convertView;
    }
}

