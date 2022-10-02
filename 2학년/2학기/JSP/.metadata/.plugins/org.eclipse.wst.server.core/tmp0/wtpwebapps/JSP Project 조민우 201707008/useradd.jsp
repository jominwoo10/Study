<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script language="javascript">
	// 자바 스크립트 시작 
	function writeCheck() {
		var form = document.writeform;
		if (!form.name.value) {		// form에 있는 내용 값이 없을 때 
			alert("이름을 입력해주세요");
			form.name.focus();		// form에 있는 내용 위치로 이동
			return;
		}
		if (!form.idd.value) {		// form에 있는 내용 값이 없을 때 
			alert("id를 입력해주세요");
			form.id.focus();		// form에 있는 내용 위치로 이동
			return;
		}
		if (!form.password.value) {
			alert("패스워드를 입력해주세요");
			form.pass.focus();		// form에 있는 내용 위치로 이동
			return;
		}
		if (!form.email.value) {
			alert("이메일을 입력해주세요");
			form.email.focus();		// form에 있는 내용 위치로 이동
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
<jsp:include page="Header.jsp" />
</head>
<body>
     <div class="container">
    <div class="row">
    <div class="col-sm-12 text-center" >
    <div class="col-sm-3"></div>
     
    <div class="col-sm-6">
    <h2>회원가입</h2>
    <form name=writeform method=post action="useraddaction.jsp">
        <table class="table table-boardered">
        	 <tr>
                <th>이름</th>
                <td><input type="text" class="form-control" name="name" placeholder="이름을 입력하세요"></td>        
            </tr>
            <tr>
                <th>아이디</th>
                <td><input type="text" class="form-control" name="idd" placeholder="id를 넣으세요"></td>        
            </tr>
            <tr>
                <th>패스워드</th>
                <td><input type="password" class="form-control" name="password" placeholder="비밀번호는 영문만 넣어주세요"></td>      
            </tr> 
            <tr>
                <th>이메일</th>
                <td><input type="email" class="form-control" name="email" placeholder="이메일을 입력 하세요"></td>       
            </tr>                        
            <tr align="center">
                <td colspan="2">
                <input type="button" class="btn btn-primary" value="전송" onClick="javascript:writeCheck();">
                <input type="button" class="btn btn-danger" value="취소" onClick="location.href='index.jsp'">
                </td>
            </tr>
        </table>
    </form>
    </div>
    </div>
    </div>
</div>
</body>
</html>