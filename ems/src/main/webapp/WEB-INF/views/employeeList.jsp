<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<p>Add Employee<a href="addEmployee">>>>click here>>></a></p>
<table border="2">
	<tr>
		<td>EmpNo</td>
		<td>EmpName</td>
		<td>Salary</td>
		<td>DeptNo</td>
		<td>Edit/Delete</td>
	</tr>
	<c:if test="${!empty empModelList}">
		<c:forEach items="${empModelList}" var="e">
		<tr>
			<td><c:out value="${e.empNo}"></c:out></td>
			<td><c:out value="${e.empName}"></c:out></td>
			<td><c:out value="${e.salary}"></c:out></td>
			<td><c:out value="${e.deptNo}"></c:out></td>
			<td>
				<a href="editEmployee?id=${e.empNo}"><img src="imgs/edit_img.jpg" width="40" height="40"></a>
				&nbsp; &nbsp;
				<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="deleteEmployee?id=${e.empNo}"><img src="imgs/delete_img.png" width="40" height="40"> </a>
				</security:authorize>			
			</td>
		</tr>	
		</c:forEach>
	</c:if>
</table>
<a href="logoutMe">SignOut</a>