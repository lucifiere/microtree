package com.atlandes.microtree.pojo;

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
