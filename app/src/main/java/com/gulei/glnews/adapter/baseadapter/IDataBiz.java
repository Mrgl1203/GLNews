package com.gulei.glnews.adapter.baseadapter;

import java.util.List;

/**
 * Created by gl152 on 2018/1/31.
 */

public interface IDataBiz<T> {
    void add(T element);

    void remove(T element);

    void addAll(List<T> elements);

    void removeAll(List<T> elements);

    void addAt(int position, T element);

    void removeAt(int position);

    void addAllAt(int position, List<T> elements);

    void clear();

    List<T> getAll();

    T get(int position);

    void replace(T oldElem, T newElem);

    void replaceAt(int position, T oldElem);

    void replaceAll(List<T> elements);

    int getSize();


}

