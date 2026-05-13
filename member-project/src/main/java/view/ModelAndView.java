package view;

public class ModelAndView {
	//경로 접두사
	private static final String PREFIX = "/WEB-INF/views/";
	//경로 접미사
	private static final String SURFFIX = ".jsp";
	//이동할 페이지 경로
	private String path;
	//forward? redirect? true -> 리다이렉트
	private boolean redirect;
	
	public ModelAndView(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}
	
	public String getPath() {
		if(!redirect)//forward 경우
			return PREFIX + path + SURFFIX;
		//redirect 경우
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public static String getPreffix() {
		return PREFIX;
	}
	public static String getSurffix() {
		return SURFFIX;
	}
}
