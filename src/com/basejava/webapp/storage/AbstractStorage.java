package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

abstract class AbstractStorage implements Storage{
    @Override
    abstract public void clear();

    @Override
    abstract public void save(Resume resume);

    @Override
    abstract public Resume get(String uuid);

    @Override
    abstract public void update(Resume resume);

    @Override
    abstract public void delete(String uuid);

    @Override
    abstract public Resume[] getAll();

    @Override
    abstract public int size();
}