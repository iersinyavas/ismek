<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/rehberKayit.js"></script>
<title>Kayıt Sayfası</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<form action="rehberKayit?metod=EKLE" method="post">
				<table>
					<tr>
						<td>İsim</td>
						<td>:</td>
						<td><input id="isim" type="text" name="isim"
							placeholder="isim" /></td>
					</tr>
					<tr>
						<td>Telefon</td>
						<td>:</td>
						<td><input id="telefon" type="text" name="telefon"
							placeholder="telefon" /></td>
					</tr>
				</table>
				<br /> <input type="hidden" name="id" id="id" /> <input
					type="submit" value="Kaydet" />
			</form>
		</div>
		<div>
			<table id="table" class="table table-striped">
				<thead>
					<th></th>
					<th></th>
					<th>Id</th>
					<th>İsim</th>
					<th>Telefon</th>
				</thead>
				<tbody>
					<c:forEach items="${rehberListesi}" var="kayit">
						<tr>
							<td><a class="btn btn-danger"
								href="rehberKayit?metod=SIL&id=${kayit.id}">Sil</a></td>
							<td><a class="btn btn-warning" onclick="duzenle(${kayit.id})">Düzenle</a></td>
							<td><c:out value="${kayit.id}"></c:out></td>
							<td><c:out value="${kayit.isim}"></c:out></td>
							<td><c:out value="${kayit.telefon}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
