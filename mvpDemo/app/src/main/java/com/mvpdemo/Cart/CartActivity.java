package com.mvpdemo.Cart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mvpdemo.R;
import com.mvpdemo.adapter.CartAdapter;
import com.mvpdemo.model.Cart;

public class CartActivity extends AppCompatActivity implements CartView {
    private ListView lvCart;
    private RelativeLayout rlProgress;
    private TextView txtCreditCard;
    private TextView txtName;

    private CartPresenter cartPresentor;
    private CartAdapter cartAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rlProgress = (RelativeLayout) findViewById(R.id.rlProgress);
        lvCart = (ListView) findViewById(R.id.lvCart);
        txtName = (TextView) findViewById(R.id.txtName);
        txtCreditCard = (TextView) findViewById(R.id.txtCreditCard);

        cartPresentor = new CartPresenterImpl(this);
        cartPresentor.fetchCartDetails();
    }

    @Override
    public void showLoading() {
        if (rlProgress != null) {
            rlProgress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideLoading() {
        if (rlProgress != null) {
            rlProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void setCartInfo(Cart cart) {
        txtName.setText(cart.getBuyer());
        txtCreditCard.setText(cart.getCreditCard());
        cartAdapter = new CartAdapter(getApplicationContext(), cart.getLineItems());
        lvCart.setAdapter(cartAdapter);
    }

    @Override
    protected void onDestroy() {
        cartAdapter.onDestroy();
        cartPresentor.onDestroy();
        cartPresentor = null;
        lvCart = null;
        rlProgress = null;
        txtCreditCard = null;
        txtName = null;

        super.onDestroy();
    }
}
