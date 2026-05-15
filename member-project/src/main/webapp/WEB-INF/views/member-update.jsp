<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<script>
			/** 모든 필드가 올바르게 입력되었는지 확인하는 함수입니다. */
			async function checkField() {
				let result = true;
				// 2. 모든 input 태그에 값이 입력되었는지 확인
				let input = document.querySelectorAll("input");
				input.forEach(item => {
					if (item.value.trim() == '')
						result = false;
				});
				return result;
			}

			window.onload = () => {
					// 비동기 통신(fetch)으로 중복 여부 확인
					fetch('./checkId.do?no='+no+'&id='+id)
						.then(response => response.json())
						.then(data => {
							console.log(data);
							let checkArea = document.querySelector("#idCheckResult");
							if (data.result == 1) {
								// 사용 가능한 경우 (파란색)
								checkArea.style.fontWeight = 'bold';
								checkArea.style.color = 'blue';
							} else {
								// 중복된 경우 (빨간색)
								checkArea.style.fontWeight = 'bold';
								checkArea.style.color = 'red';
							}
							checkArea.innerHTML = data.msg;
						})
				}

				// --- 폼 제출(가입하기 버튼) 이벤트 ---
				document.querySelector('form').onsubmit = async (e) => {
					// 기본 제출 기능을 막고 검증을 수행합니다.
					// 태그는 기본적으로 설정된 이벤트
					// 하이퍼링크는 페이지 이동
					// submit 버튼 누르면 해당 경로로 데이터 전송
					// preventDefault는 기본적으로 설정되어 있는 이벤트를 무력화 시킴
					e.preventDefault();

					let result = await checkField();

					if (result) {
						// 검증 통과 시 실제 데이터를 전송합니다.
						e.target.submit();
					} else {
						alert('입력 항목을 다시 확인해 주세요.');
					}
				}

				// --- 취소 버튼 클릭 이벤트 ---
				document.querySelector("#btnCancel").onclick = () => {
					history.back(); // 이전 페이지(로그인 등)로 돌아감
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

.update-box {
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

#btnUpdate {
	background-color: #4a90e2;
	color: white;
}

#btnUpdate:hover {
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
		<section class="update-box">
			<h2>회원 정보 수정 페이지</h2>

			<form action="./update.do" method="post" id="updateForm">
				<input type="hidden" id="no" name="no" value="${member.no }">
				<div class="input-group">
					<label for="id">아이디</label>
					<div class="id-row">
						<input type="text" id="id" readonly name="id"
							value="${member.id }">
					</div>
				</div>
				<div class="input-group">
					<label for="passwd">비밀번호</label> <input type="password" id="passwd"
						name="passwd" placeholder="비밀번호 입력">
				</div>

				<div class="input-group">
					<label for="userName">이름</label> <input type="text" id="userName"
						name="userName" value="${member.userName }">
				</div>

				<div class="input-group">
					<label for="nickName">닉네임</label> <input type="text" id="nickName"
						name="nickName" value="${member.nickName }">
				</div>

				<div class="button-group">
					<button id="btnUpdate">수정하기</button>
					<button type="button" id="btnCancel">취소</button>
				</div>
			</form>
		</section>
	</main>

</body>

</html>