package com.ecommerce.bitirme.ecommerce.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ecommerce.bitirme.ecommerce.Activity.adapter;
import com.ecommerce.bitirme.ecommerce.Activity.katagori;
import com.ecommerce.bitirme.ecommerce.Classes.OfferHouse;
import com.ecommerce.bitirme.ecommerce.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class OfferFragment extends Fragment implements ValueEventListener {
    ListView listoffer;
    adapter offeradap;
    String ilanIdOffer;
    List<katagori> offer = new ArrayList<>();
    Firebase mRef;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_offer, container, false);
        listoffer = mview.findViewById(R.id.offerlist);
        ilanIdOffer = getArguments().getString("ilanid");
        //// TODO: 5.01.2018 sorgu firebaseden offer doldurulacak
        Firebase.setAndroidContext(mview.getContext());
        mRef = new Firebase("https://ecommerce-1-28620.firebaseio.com/");
        mRef.addValueEventListener(this);


        return mview;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        offer.clear();
        for (DataSnapshot gelenler : dataSnapshot.child("teklifler").child(ilanIdOffer).getChildren()) {
            try {
                offer.add(new katagori("teklif",
                        gelenler.getValue(OfferHouse.class).getOfferFiyat() + " , " + gelenler.getValue(OfferHouse.class).getOfferm2() + " , " + gelenler.getValue(OfferHouse.class).getOfferDate() + "----" + gelenler.getKey(), ""));
            } catch (Exception e) {

                continue;
            }

        }

        offeradap = new adapter(this.getActivity(), offer);
        listoffer.setAdapter(offeradap);
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }


}