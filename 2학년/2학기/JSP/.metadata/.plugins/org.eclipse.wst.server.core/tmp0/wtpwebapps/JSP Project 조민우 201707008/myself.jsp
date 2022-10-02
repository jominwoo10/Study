<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script language="javascript">
	// 자바 스크립트 시작 
	function writeCheck() {
		var form = document.writeform;
		if (!form.memo.value) {		// form에 있는 내용 값이 없을 때 
			alert("내용을 입력해주세요");
			form.memo.focus();		// form에 있는 내용 위치로 이동
			return;
		}
		form.submit();
	}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<form name=writeform method=post action="myselfaction.jsp">
		<tr>
			<td>
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr style="text-align: center;">
						<td>자기소개 쓰기</td>
					</tr>
				</table>
				<table>
					<tr>
						<td>&nbsp;</td>
						<td align="center">내용</td>
						<td><textarea name="memo" cols="50" rows="13"></textarea></td>
						<td>&nbsp;</td>
					</tr>
					<tr align="center">
						<td>&nbsp;</td>
						<td colspan="3">
							<input type=button value="등록" OnClick="javascript:writeCheck();"> 
							<input type=button value="취소" onClick="location.href='index.jsp'">
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
		</form>
	</table>
</body>
</html>