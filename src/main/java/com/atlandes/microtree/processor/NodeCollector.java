package com.atlandes.microtree.processor;

import com.atlandes.microtree.constants.Enums;

import java.util.List;
import java.util.Optional;

/**
 * Created by XD.Wang on 2017/10/15.
 * the processor for node collect
 */
public interface NodeCollector<T> extends Processor<T> {

    Optional<List<Integer>> get();

    Enums.CollectType getCollectType();

    DefaultNodeCollector<T> setCollectType(Enums.CollectType collectType);

}
