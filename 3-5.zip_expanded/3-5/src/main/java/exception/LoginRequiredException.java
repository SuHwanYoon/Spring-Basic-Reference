package exception;

public class LoginRequiredException extends RuntimeException {

	public LoginRequiredException(String msg) {//msg에 로그인되어있지 않습니다가 들어감
		super(msg);
	}
}
