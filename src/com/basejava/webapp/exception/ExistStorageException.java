package com.basejava.webapp.exception;

public class ExistStorageException extends StorageException{
    public ExistStorageException(String uuid) {
        super("Resume with " + uuid + " is existing", uuid);
    }
}
