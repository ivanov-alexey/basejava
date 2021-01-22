package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);

        if (index < 0) {
            if (size < STORAGE_LIMIT) {
                addElement(resume, index);
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
        }

        System.out.println("ERROR: uuid " + uuid + " not found");

        return null;

    }

    public void update(Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);

        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: uuid " + uuid + " not found");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index >= 0) {
            fillDeleted(index);
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

    protected abstract void addElement(Resume resume, int index);

    protected abstract void fillDeleted(int index);

    protected abstract int getIndex(String uuid);
}
