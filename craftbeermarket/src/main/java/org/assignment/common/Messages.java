package org.assignment.common;

/**
 * @author phuongnq 
 * Messages
 */
public class Messages {

	private MessageType type;
	private String code;
	private Object[] args;

	public Messages(MessageType type) {
		this.type = type;
	}

	public static Messages success() {
		return new Messages(MessageType.SUCCESS);
	}

	public static Messages info() {
		return new Messages(MessageType.INFO);
	}

	public static Messages warning() {
		return new Messages(MessageType.WARNING);
	}

	public static Messages error() {
		return new Messages(MessageType.ERROR);
	}

	public Messages message(String code, Object... args) {
		this.code = code;
		this.args = args;
		return this;
	}

	public Messages message(String code) {
		this.code = code;
		return this;
	}

	/**
	 * @return the type
	 */
	public MessageType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(MessageType type) {
		this.type = type;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the args
	 */
	public Object[] getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public void setArgs(Object[] args) {
		this.args = args;
	}

}
