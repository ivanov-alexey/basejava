package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void addElement(Resume resume, int index) {
        int elementIndex = -index - 1;

        System.arraycopy(storage, elementIndex, storage, elementIndex + 1, size - elementIndex);
        storage[elementIndex] = resume;
    }

    @Override
    protected void fillDeleted(int index) {
        int elementIndex = size - index - 1;

        if (elementIndex > 0) {
            System.arraycopy(storage, index + 1, storage, index, elementIndex);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);

        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
