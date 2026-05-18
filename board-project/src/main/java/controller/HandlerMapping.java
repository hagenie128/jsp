package controller;

/**
 * 사용자의 메뉴 선택(no)에 따라 적절한 컨트롤러 객체를 생성하여 반환하는 클래스 싱글톤 패턴으로 구현되어 프로그램 전체에서 하나의 매핑
 * 정보만 관리함
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		if (instance == null)
			instance = new HandlerMapping();
		return instance;
	}

	public Controller createController(String command) {
		Controller controller = null;
		switch (command) {
//		게시판 목록 페이지
		case "main.do":
			controller = new MainController();
			break;
			
//			로그인 컨트롤
		case "loginView.do":
			controller = new LoginViewController();
			break;
		case "login.do":
			controller = new LoginController();
			break;
		case "logOut.do":
			controller = new LogoutController();
			break;
			
//			회원 정보 관리
		case "registerView.do":
			controller = new MemberRegisterViewController();
			break;
		case "register.do":
			controller = new MemberRegisterController();
			break;
		case "checkId.do":
			controller = new CheckIdController();
			break;
		case "delete.do":
			controller = new MemberDeleteContorller();
			break;
		case "search.do":
			controller = new MemberSearchController();
			break;
		case "updateView.do":
			controller = new MemberUpdateViewController();
			break;
		case "update.do":
			controller = new MemberUpdateController();
			break;
			
//			게시판 정보 관리
		case "boardWriteView.do":
			controller = new BoardWriteViewController();
			break;
		case "boardWrite.do":
			controller = new BoardWriteController();
			break;
		}
		return controller;
	}
}