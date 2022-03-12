package exception;

public class CartEmptyException extends RuntimeException {
	public CartEmptyException(String msg) {//msg에 "카트가 비어있습니다"들어감
		super(msg);
	}
}
