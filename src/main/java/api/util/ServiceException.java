package api.util;

/**
 * Service层公用的Exception.
 * @author zimu
 * @date 2016-11-05 15:26:21 中国标准时间
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 3583566093089790852L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}