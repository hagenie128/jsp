<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>회원 목록</title>

			<style>
				table {
					width: 500px;
					border-collapse: collapse;
					table-layout: fixed;
				}

				th,
				td {
					border: 1px solid #ccc;
					padding: 10px;
					text-align: center;
				}

				th {
					background-color: #f2f2f2;
				}

				.password-cell {
					max-width: 180px;
					white-space: nowrap;
					overflow: hidden;
					text-overflow: ellipsis;
				}

				nav a {
					margin-right: 10px;
					text-decoration: none;
					color: #333;
				}

				.search-box {
					display: flex;
					justify-content: center;
					align-items: center;
					gap: 8px;
					padding: 15px 0;
				}

				.search-form {
					display: flex;
					align-items: center;
					gap: 8px;
				}

				.search-form input {
					width: 220px;
					padding: 10px 12px;
					border: 1px solid #ccc;
					border-radius: 8px;
					font-size: 14px;
				}

				.search-form input:focus {
					outline: none;
					border-color: #4a90e2;
				}

				#btnSearch {
					padding: 10px 18px;
					border: none;
					border-radius: 8px;
					background-color: #4a90e2;
					color: white;
					font-size: 14px;
					font-weight: bold;
					cursor: pointer;
				}

				#btnSearch:hover {
					background-color: #357abd;
				}

				#btnSearchCancel {
					padding: 10px 18px;
					border: none;
					border-radius: 8px;
					background-color: #ddd;
					color: #333;
					font-size: 14px;
					font-weight: bold;
					cursor: pointer;
				}

				#btnSearchCancel:hover {
					background-color: #c7c7c7;
				}
			</style>
			<script>
				window.onload = () => {
					//btnDelete 클릭했을 때 삭제할 회원 번호를 no로 저장
					//let no = ?
					//location.href="./delete.do?no="+no
					document.querySelectorAll('.btnDelete').forEach((item) => {
						item.addEventListener('click', () => {
							// 클릭한 버튼이 속한 행의 첫 번째 열(번호)을 가져옵니다.
							let no = item.parentElement.parentElement.firstElementChild.innerText;
							// 확인 후 삭제 경로로 이동합니다.
							if (confirm(no + '번 회원을 정말 삭제할까요?')) {
								location.href = "./delete.do?no=" + no;
							}
						});
					});
					
					//검색 버튼 클릭 이벤트(AJEX 사용 예시)
					document.querySelector('#btnSearch').onclick = async (e) => {
						// let kind = document.querySelector('#kind').value;
						// let search = document.querySelector('#search').value;
						// let url = `./search.do?kind=\${kind}&search=\${search}`;

						// let url = './search.do?'
						// document.querySelectorAll('thead input,thead select').forEach(item =>{
						// 	url += `\${item.id}=\${item.value}&`
						// })

						let btn = e.target;
						let tags = btn.closest('td'); //클릭한 버튼의 부모태그 선택

						const param = new URLSearchParams();
						// td 내부의 input과 select 태그들의 값을 파라미터로 만듭니다.
						tags.querySelectorAll('input,select').forEach(item => {
							param.append(item.id, item.value);
						});

						let url = `./search.do?\${param.toString()}`;
						console.log("요청 URL:", url);

						// 서버로 비동기 요청을 보냅니다.
						let response = await fetch(url);
						let data = await response.json();

						// 서버로부터 받은 JSON 응답을 콘솔에 출력합니다.
						console.log("서버 응답:", data);
						alert(data.msg);
	
						let tbody = document.querySelector("#memberTbody");

						// 기존 목록 비우기
						tbody.innerHTML = "";

						// 조회 결과가 없을 때
						if (data.list.length === 0) {
							tbody.innerHTML = `
								<tr>
									<td colspan="6">조회한 데이터가 없습니다</td>
								</tr>
							`;
							return;
						}

						// 조회 결과가 있을 때
						data.list.forEach(member => {
							let tr = document.createElement("tr");

							tr.innerHTML = `
								<td>\${member.no}</td>
								<td>\${member.id}</td>
								<td class="password-cell">\${member.passwd}</td>
								<td>\${member.userName}</td>
								<td>\${member.nickName}</td>
								<td><button class="btnDelete">삭제</button></td>
							`;

							tbody.appendChild(tr);
						});
					}
				}
			</script>
		</head>

		<body>
			<nav>
				<%-- 세션에 로그인 정보(member)가 없는 경우 --%>
					<c:if test="${sessionScope.member == null }">
						<a href="./loginView.do">로그인</a>
						<a href="./registerView.do">회원 가입</a>
					</c:if>
					<%-- 세션에 로그인 정보(member)가 있는 경우 --%>
						<c:if test="${sessionScope.member != null }">
							<a href="./loginOut.do">로그아웃</a>
							<span><strong>${sessionScope.member.nickName }</strong>님이
								로그인하셨습니다.</span>
						</c:if>
			</nav>

			<hr>

			<h2>전체 회원 정보</h2>

			<table>
				<thead>
					<tr>
						<td colspan="6">
							<div class="search-box">
								<select id="kind">
									<option value="id">아이디</option>
									<option value="username">이름</option>
									<option value="nickname">닉네임</option>
								</select>
								<input type="text" id="search" placeholder="검색어 입력">
								<button type="submit" id="btnSearch">검색</button>
								<button type="button" id="btnSearchCancel"
									onclick="location.href='./main.do'">취소</button>
							</div>
						</td>
					</tr>
					<tr>
						<th>NO</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이름</th>
						<th>닉네임</th>
						<th>삭제</th>
					</tr>
				</thead>

				<tbody id="memberTbody">
					<c:forEach items="${list}" var="member">
						<tr>
							<td>${member.no}</td>
							<td>${member.id}</td>
							<td class="password-cell">${member.passwd}</td>
							<td>${member.userName}</td>
							<td>${member.nickName}</td>
							<td><button class="btnDelete">삭제</button></td>
						</tr>
					</c:forEach>

					<c:if test="${empty list}">
						<tr>
							<td colspan="6">조회한 데이터가 없습니다</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</body>

		</html>