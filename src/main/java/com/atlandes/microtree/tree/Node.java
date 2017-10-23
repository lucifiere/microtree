package com.atlandes.microtree.tree;

import com.atlandes.microtree.constants.Enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XD.Wang on 2017/10/11.
 * tree node definition
 */
public class Node<T> {

    /**
     * node ID, keep global unique
     */
    private Integer id;
    /**
     * node business name
     */
    private String name;
    /**
     * node level
     */
    private Integer level;
    /**
     * whether spread
     */
    private Integer spread;
    /**
     * whether children choose but parent not choose
     */
    private Integer halfChoice;
    /**
     * whether show
     */
    private Integer display;
    /**
     * whether check
     */
    private Integer check;
    /**
     * node parent ID
     */
    private Integer parent;
    /**
     * children list
     */
    private List<Node<T>> children;
    /**
     * node ancestor
     */
    private List<Integer> ancestor;
    /**
     * node posterity
     */
    private List<Integer> posterity;
    /**
     * business data
     */
    private T data;

    public Node() {
        children = new ArrayList<>();
        spread = Enums.Spread.NO.ordinal();
        check = Enums.Checked.NO.ordinal();
        display = Enums.Display.YES.ordinal();
        halfChoice = Enums.HalfChoose.NO.ordinal();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSpread() {
        return spread;
    }

    public void setSpread(Integer spread) {
        this.spread = spread;
    }

    public Integer getHalfChoice() {
        return halfChoice;
    }

    public void setHalfChoice(Integer halfChoice) {
        this.halfChoice = halfChoice;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    public List<Integer> getAncestor() {
        return ancestor;
    }

    public void setAncestor(List<Integer> ancestor) {
        this.ancestor = ancestor;
    }

    public List<Integer> getPosterity() {
        return posterity;
    }

    public void setPosterity(List<Integer> posterity) {
        this.posterity = posterity;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
