package com.atlandes.microtree.tree;

import com.atlandes.microtree.pojo.BusinessData;
import com.atlandes.microtree.pojo.Node;
import com.atlandes.microtree.processor.Processor;

import java.util.List;
import java.util.Map;

/**
 * Created by XD.Wang on 2017/10/14.
 * general tree interface
 */
public interface Tree<T> {

    Node<T> rebuild(List<BusinessData<T>> businessData);

    Map<Integer, Node<T>> getNodeDict();

    List<Node<T>> getNodeList();

    Node<T> getRoot();

    void downwardTravel(Node<T> curNode, Processor<T> processor);

    void ancestorSearch(Node<T> curNode, Processor<T> processor);

    void downwardTravel(Processor<T> processor);

}
