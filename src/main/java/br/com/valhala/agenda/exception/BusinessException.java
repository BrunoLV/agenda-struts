package br.com.valhala.agenda.exception;

/**
 * Created by Bruno on 13/09/2014.
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = -5074284007667018961L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
