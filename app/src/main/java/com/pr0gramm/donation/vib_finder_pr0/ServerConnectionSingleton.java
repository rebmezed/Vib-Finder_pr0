package com.pr0gramm.donation.vib_finder_pr0;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class ServerConnectionSingleton {
    private static ServerConnectionSingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private ServerConnectionSingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized ServerConnectionSingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ServerConnectionSingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
