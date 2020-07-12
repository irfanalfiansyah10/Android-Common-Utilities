package com.mcnmr.utilities.wrapper;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.atomic.AtomicBoolean;

public class SingleEventWrapper<T> extends MutableLiveData<T> {
    private static String TAG = "SingleEventWrapper";
    private AtomicBoolean pending = new AtomicBoolean(false);

    @Override
    public void postValue(T value) {
        pending.set(true);
        super.postValue(value);
    }

    @Override
    public void setValue(T value) {
        pending.set(true);
        super.setValue(value);
    }

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull final Observer<? super T> observer) {
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(owner, new Observer<T>() {
            @Override
            public void onChanged(T t) {
                if(pending.compareAndSet(true, false)){
                    observer.onChanged(t);
                }
            }
        });
    }

    public void trigger(){
        setValue(null);
    }

    public void postTrigger(){
        postValue(null);
    }
}
