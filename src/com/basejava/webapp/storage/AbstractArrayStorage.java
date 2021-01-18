package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);

        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("ERROR: uuid " + uuid + " not found");

            return null;
        }
    }

    protected abstract int getIndex(String uuid);
}
