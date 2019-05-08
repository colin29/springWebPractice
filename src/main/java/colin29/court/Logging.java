package colin29.court;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

	private static final Logger logger = LoggerFactory.getLogger(Logging.class);

	public static void main(String[] args) {
		logger.info("Example log from {}", Logging.class.getSimpleName());
	}

	private static Logger tempLog;

	/**
	 * Gets the name of the nearest calling class (from the top of the stack), besides this one
	 * 
	 * @return
	 */
	private static String getCallingClassName() {
		StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
		for (int i = 1; i < stElements.length; i++) {
			StackTraceElement ste = stElements[i];
			if (!ste.getClassName().equals(Logging.class.getName())
					&& ste.getClassName().indexOf("java.lang.Thread") != 0) {
				return ste.getClassName();
			}
		}
		return null;
	}

	/**
	 * Logs that this request was received. Must call this method directly for method name to display correctly
	 */
	public static void logRequest() {

		// logger.debug(getCallingClassName());
		tempLog = LoggerFactory.getLogger(getCallingClassName());

		tempLog.info("Got a request on '" + new Throwable()
				.getStackTrace()[1]
						.getMethodName()
				+ "'");
	}
}