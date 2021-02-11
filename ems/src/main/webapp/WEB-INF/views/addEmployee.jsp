<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="save" method="post" modelAttribute="emp">
	<Table>
		<tr><td>empNo</td><td><form:input path="empNo"/></td></tr>
		<tr><td>empName</td><td><form:input path="empName"/></td></tr>
		<tr><td>salary</td><td><form:input path="salary"/></td></tr>
		<tr><td>deptNo</td><td><form:input path= "deptNo"/></td></tr>
		<tr><td colspan="3"><input type="submit" value="SUBMIT"></td></tr>
	</Table>
</form:form>
<a href="logoutMe">SignOut</a>