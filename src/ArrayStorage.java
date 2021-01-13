import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        int lastIndex = size();

        storage[lastIndex] = r;
    }

    Resume get(String uuid) {
        return storage[getIndex(uuid)];
    }

    void delete(String uuid) {
        int lastResumeIndex = size() - 1;
        int currentResumeIndex = getIndex(uuid);

        storage[currentResumeIndex] = storage[lastResumeIndex];
        storage[lastResumeIndex] = storage[size()];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int quantityOfResume = 0;

        for (Resume resume : storage) {
            if (resume != null) {
                quantityOfResume += 1;
            }
        }

        return quantityOfResume;
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
