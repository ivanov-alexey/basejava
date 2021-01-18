package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{
    @Override
    public void clear() {

    }

    @Override
    public void save(Resume resume) {

    }

    @Override
    public void update(Resume resume, Resume newResume) {

    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        // TODO: отсортировать массив
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
