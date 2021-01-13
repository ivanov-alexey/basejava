import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10_000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size(), null);
        size = 0;
    }

    void save(Resume resume) {
        int lastIndex = size();

        storage[lastIndex] = resume;
        size += 1;
    }

    Resume get(String uuid) {
        return storage[getIndex(uuid)];
    }

    void delete(String uuid) {
        int lastResumeIndex = size() - 1;
        int currentResumeIndex = getIndex(uuid);

        storage[currentResumeIndex] = storage[lastResumeIndex];
        storage[lastResumeIndex] = storage[size()];
        size -= 1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        return size;
    }

    int getIndex(String uuid) {
        int index = -1;

        for (int i = 0; i < size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                index = i;
            }
        }

        return index;
    }
}
