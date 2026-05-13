<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<style>
	* {
		box-sizing: border-box;
	}

	body {
		margin: 0;
		font-family: Arial, sans-serif;
		background-color: #f4f6f8;
	}

	main {
		width: 100%;
		height: 100vh;
		display: flex;
		justify-content: center;
		align-items: center;
	}

	.login-box {
		width: 380px;
		padding: 35px;
		background-color: white;
		border-radius: 12px;
		box-shadow: 0 4px 15px rgba(0, 0, 0, 0.12);
	}

	h2 {
		margin-top: 0;
		margin-bottom: 25px;
		text-align: center;
		color: #333;
	}

	.input-group {
		margin-bottom: 18px;
	}

	.input-group label {
		display: block;
		margin-bottom: 8px;
		font-size: 14px;
		font-weight: bold;
		color: #555;
	}

	.input-group input {
		width: 100%;
		padding: 12px;
		border: 1px solid #ccc;
		border-radius: 8px;
		font-size: 14px;
	}

	.input-group input:focus {
		outline: none;
		border-color: #4a90e2;
	}

	.button-group {
		display: flex;
		gap: 10px;
		margin-top: 25px;
	}

	.button-group button {
		flex: 1;
		padding: 12px;
		border: none;
		border-radius: 8px;
		font-size: 14px;
		font-weight: bold;
		cursor: pointer;
	}

	#btnLogin {
		background-color: #4a90e2;
		color: white;
	}

	#btnLogin:hover {
		background-color: #357abd;
	}

	#btnRegister {
		background-color: #777;
		color: white;
	}

	#btnRegister:hover {
		background-color: #555;
	}

	#btnCancel {
		background-color: #ddd;
		color: #333;
	}

	#btnCancel:hover {
		background-color: #c7c7c7;
	}
</style>

</head>
<body>

	<main>
		<section class="login-box">
			<h2>로그인 페이지</h2>

			<form action="./login.do" method="post">
				<div class="input-group">
					<label for="id">아이디</label>
					<input type="text" id="id" name="id" placeholder="아이디를 입력하세요" required>
				</div>

				<div class="input-group">
					<label for="passwd">비밀번호</label>
					<input type="password" id="passwd" name="passwd" placeholder="비밀번호를 입력하세요" required>
				</div>

				<div class="button-group">
					<button type="submit" id="btnLogin">로그인</button>
					<button type="button" id="btnRegister" onclick="location.href='./registerView.do'">회원가입</button>
					<button type="button" id="btnCancel" onclick="history.back()">취소</button>
				</div>
			</form>
		</section>
	</main>

</body>
</html>