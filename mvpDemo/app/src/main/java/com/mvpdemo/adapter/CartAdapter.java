package com.mvpdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mvpdemo.R;
import com.mvpdemo.model.LineItem;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends BaseAdapter {
    List<LineItem> lineItems = new ArrayList<>();
    Context mContext;
    LayoutInflater layoutInflater;

    public CartAdapter(Context mContext, List<LineItem> lineItems) {
        this.mContext = mContext;
        this.lineItems = lineItems;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lineItems.size();
    }

    @Override
    public Object getItem(int i) {
        return lineItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder {
        TextView txtName;
        TextView txtPriceInMicros;
        TextView txtQuantity;
        TextView txtCurrencyCode;
        ImageView ivItem;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        LineItem lineItem = lineItems.get(position);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.cart_item, viewGroup, false);
            viewHolder.txtName = (TextView) view.findViewById(R.id.txtName);
            viewHolder.txtPriceInMicros = (TextView) view.findViewById(R.id.txtPriceInMicros);
            viewHolder.txtQuantity = (TextView) view.findViewById(R.id.txtQuantity);
            viewHolder.txtCurrencyCode = (TextView) view.findViewById(R.id.txtCurrencyCode);
            viewHolder.ivItem = (ImageView) view.findViewById(R.id.ivItem);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.txtName.setText(lineItem.getName());
        viewHolder.txtPriceInMicros.setText(String.valueOf(lineItem.getPriceInMicros()));
        viewHolder.txtQuantity.setText(String.valueOf(lineItem.getQuantity()));
        viewHolder.txtCurrencyCode.setText(lineItem.getCurrencyCode());
        if (lineItem.getImgUrl() != null) {
            Glide.with(mContext).load(lineItem.getImgUrl()).into(viewHolder.ivItem);
        }

        return view;
    }

    public void onDestroy() {
        mContext = null;
        lineItems = null;
        layoutInflater = null;
    }
}
