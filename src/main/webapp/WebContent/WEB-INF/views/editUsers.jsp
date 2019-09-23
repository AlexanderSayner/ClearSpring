<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url('https://carbonmade-media.accelerator.net/31097855;2400x1600.png');
}
</style>
</head>

<body>
	<br>
	<div style="text-align: center">
		<h2>Users List</h2>
        <table>
            <tr>
                <td><strong>Name</strong></td>
                <td><strong>Email</strong></td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
        </table>
	</div>
</body>

</html>
