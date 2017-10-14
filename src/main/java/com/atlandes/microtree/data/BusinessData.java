package com.atlandes.microtree.data;

/**
 * Created by XD.Wang on 2017/10/11.
 * business data
 */
public interface BusinessData<T> {

    Integer getId();

    String getName();

    T getData();

    Integer getParent();

}
