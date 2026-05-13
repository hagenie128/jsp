<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	window.onload=()=>{
		document.querySelector("#btnIdCheck").onclick =(e)=>{
			let id = document.querySelector("#id").value;
			//alert(id);
			
			fetch('./checkId.do?id='+id)
			.then(response => response.json())
			.then(data =>{
				console.log(data);
			})
			
		}
	}
</script>
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

.register-box {
	width: 420px;
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

.id-row {
	display: flex;
	gap: 8px;
}

.id-row input {
	flex: 1;
}

#btnIdCheck {
	width: 90px;
	border: none;
	border-radius: 8px;
	background-color: #777;
	color: white;
	font-size: 13px;
	font-weight: bold;
	cursor: pointer;
}

#btnIdCheck:hover {
	background-color: #555;
}

#idCheckResult {
	margin-top: -10px;
	margin-bottom: 15px;
	font-size: 13px;
	color: #666;
	min-height: 18px;
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
	font-size: 15px;
	font-weight: bold;
	cursor: pointer;
}

#btnRegister {
	background-color: #4a90e2;
	color: white;
}

#btnRegister:hover {
	background-color: #357abd;
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
		<section class="register-box">
			<h2>회원가입 페이지</h2>

			<form action="./register.do" method="post">

				<div class="input-group">
					<label for="id">아이디</label>
					<div class="id-row">
						<input type="text" id="id" name="id" placeholder="아이디 입력" required>
						<button type="button" id="btnIdCheck">중복확인</button>
					</div>
				</div>

				<div id="idCheckResult"></div>

				<div class="input-group">
					<label for="passwd">비밀번호</label> <input type="password" id="passwd"
						name="passwd" placeholder="비밀번호 입력" required>
				</div>

				<div class="input-group">
					<label for="username">이름</label> <input type="text" id="username"
						name="username" placeholder="이름 입력" required>
				</div>

				<div class="input-group">
					<label for="nickname">닉네임</label> <input type="text" id="nickname"
						name="nickname" placeholder="닉네임 입력" required>
				</div>

				<div class="button-group">
					<button type="submit" id="btnRegister">가입하기</button>
					<button type="button" id="btnCancel" onclick="history.back()">취소</button>
				</div>

			</form>
		</section>
	</main>

</body>
</html>