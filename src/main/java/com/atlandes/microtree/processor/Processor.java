package com.atlandes.microtree.processor;

import com.atlandes.microtree.tree.Node;

/**
 * Created by XD.Wang on 2017/10/14.
 * processor
 */
public interface Processor<T> {

    void process(Node<T> node);

}
