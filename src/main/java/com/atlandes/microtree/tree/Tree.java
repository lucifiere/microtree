package com.atlandes.microtree.tree;

import com.atlandes.microtree.pojo.BusinessData;
import com.atlandes.microtree.pojo.Node;
import com.atlandes.microtree.processor.Processor;

import java.util.List;

/**
 * Created by XD.Wang on 2017/10/14.
 * general tree interface
 */
public interface Tree<T> {

    Node<T> build(List<BusinessData<T>> businessData);

    Node<T> getRoot();

    void travel(Node<T> curNode, Processor<T> processor);

    void travel(Processor<T> processor);

}
