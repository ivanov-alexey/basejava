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
        String uuid = resume.getUuid();
        int index = getIndex(uuid);

        if (index < 0) {
            if (size < storage.length) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: storage is full");
            }
        } else {
            System.out.println("ERROR: resume with " + uuid + " is existing");
        }
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

    public void update(Resume resume, Resume newResume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);

        if (index >= 0) {
            storage[index] = newResume;
        } else {
            System.out.println("ERROR: uuid " + uuid + " not found");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR: uuid " + uuid + " not found");
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
}
