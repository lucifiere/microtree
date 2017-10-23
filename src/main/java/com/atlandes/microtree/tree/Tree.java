package com.atlandes.microtree.tree;

import com.atlandes.microtree.data.BusinessData;
import com.atlandes.microtree.processor.Processor;

import java.util.List;
import java.util.Map;

/**
 * Created by XD.Wang on 2017/10/14.
 * general tree interface
 */
public interface Tree<T> {

    void rebuild(List<BusinessData<T>> businessData);

    Map<Integer, Node<T>> dict();

    List<Node<T>> getNodeList();

    Node<T> getRoot();

    List<Integer> getAncestors(Node<T> origin);

    List<Integer> getPosterity(Node<T> origin);

    void downwardTravel(Node<T> curNode, Processor<T> processor);

    void ancestorSearch(Node<T> curNode, Processor<T> processor);

    void downwardTravel(Processor<T> processor);

}
