package com.example.loan.ticktok.facebook.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AzimioAdapter extends BaseAdapter
{


    Context context;
    private final String [] values;
    private final String [] numbers;
    private final int [] images;

    public AzimioAdapter(Context context, String[] values, String[] numbers, int[] images){
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.values = values;
        this.numbers = numbers;
        this.images = images;
    }

    public AzimioAdapter(String[] values, String[] numbers, int[] images) {
        this.values = values;
        this.numbers = numbers;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        AzimioAdapter.ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new AzimioAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.single_list_item, parent, false);
            viewHolder.partytxt = (TextView) convertView.findViewById(R.id.partytxt);
            viewHolder.leadertxt = (TextView) convertView.findViewById(R.id.leadertxt);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.appIconIV);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AzimioAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.partytxt.setText(values[position]);
        viewHolder.leadertxt.setText( numbers[position]);
        viewHolder.icon.setImageResource(images[position]);

        return convertView;
    }

    static class ViewHolder {

        TextView partytxt;
        TextView leadertxt;
        ImageView icon;

    }
}
