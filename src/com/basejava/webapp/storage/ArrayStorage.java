package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int lastIndex = size;

        storage[lastIndex] = resume;
        size ++;
    }

    public Resume get(String uuid) {
        if (hasUuid(uuid)) {
            return storage[getIndex(uuid)];
        } else {
            System.out.println("ERROR: uuid not found");

            return null;
        }
    }

    public void delete(String uuid) {
        if (hasUuid(uuid)) {
            int index = getIndex(uuid);

            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size --;
        } else {
            System.out.println("ERROR: uuid not found");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
            }
        }

        return index;
    }

    private boolean hasUuid(String uuid) {
        return getIndex(uuid) >= 0;
    }
}
