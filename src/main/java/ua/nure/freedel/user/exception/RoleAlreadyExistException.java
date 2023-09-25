package ua.nure.freedel.user.exception;

public class RoleAlreadyExistException extends RuntimeException {
    public RoleAlreadyExistException(String message) {
    super(message);
    }
}
