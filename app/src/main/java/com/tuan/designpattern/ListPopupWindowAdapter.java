package com.tuan.designpattern;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class ListPopupWindowAdapter extends BaseAdapter {
    private final List<String> mDataSource;
    private final LayoutInflater layoutInflater;
    private final OnClickDeleteButtonListener clickDeleteButtonListener;

    public ListPopupWindowAdapter(Activity activity, List<String> dataSource, @NonNull OnClickDeleteButtonListener clickDeleteButtonListener) {
        this.mDataSource = dataSource;
        layoutInflater = activity.getLayoutInflater();
        this.clickDeleteButtonListener = clickDeleteButtonListener;
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public String getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_window_list, parent, false);
            holder.tvTitle = convertView.findViewById(R.id.text_title);
            holder.constraintLayout = convertView.findViewById(R.id.itemLayout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.tvTitle.setHeight(700);
        // bind data
        holder.tvTitle.setText(getItem(position));
        holder.constraintLayout.setOnClickListener(v -> clickDeleteButtonListener.onItemClick(position));

        return convertView;
    }

    // interface to return callback to activity
    public interface OnClickDeleteButtonListener {
        void onItemClick(int position);
    }

    public static class ViewHolder {
        private TextView tvTitle;
        private ConstraintLayout constraintLayout;
    }
}

