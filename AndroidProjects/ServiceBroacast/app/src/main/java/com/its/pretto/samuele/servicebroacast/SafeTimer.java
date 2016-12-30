package com.its.pretto.samuele.servicebroacast;

import android.os.Handler;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by Samuele.Pretto on 08/11/2016.
 */

public class SafeTimer {

    public interface ITimer {
        public void onTick();
    }

    private WeakReference<ITimer> mListener;
    private long mTick;
    private Handler mHandler;
    private boolean mIsStopped;
    private SafeTimerRunnable mRunnable;

    private SafeTimer(ITimer aListener, long aTick) {
        mListener = new WeakReference<ITimer>(aListener);
        mTick = aTick;
        mHandler = new Handler();
        mRunnable = new SafeTimerRunnable(this);
        mIsStopped = false;
    }

    public static SafeTimer Create(ITimer aListener, long aTick) {
        return new SafeTimer(aListener, aTick);
    }

    public void start() {
        mIsStopped = false;
        mHandler.post(mRunnable);
    }

    public void stop() {
        mIsStopped = true;
    }

    @Override
    protected void finalize() throws Throwable {
        Log.d("SafeTimer", "finalize SafeTimer");
        super.finalize();
    }

    static class SafeTimerRunnable implements Runnable {
        WeakReference<SafeTimer> mReference;

        public SafeTimerRunnable(SafeTimer aRef) {
            mReference = new WeakReference<SafeTimer>(aRef);

        }

        @Override
        public void run() {
            if (mReference != null) {
                SafeTimer vRef = mReference.get();
                if (vRef != null) {
                    if (vRef.mIsStopped == false) {
                        if (vRef.mListener != null) {
                            if (vRef.mListener.get() != null) {
                                vRef.mListener.get().onTick();
                                vRef.mHandler.postDelayed(this, vRef.mTick);
                            }
                        }
                    }
                }
            }
        }
    }
}
