package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void addElement(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void fillDeleted(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected int getIndex(String uuid) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
            }
        }

        return index;
    }
}
