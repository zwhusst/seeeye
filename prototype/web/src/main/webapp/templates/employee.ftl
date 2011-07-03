<html>
<head>
<title>Employee</title>
</head>
<body>
	<h1>Employee Information</h1>
	<form action="${employee.id}" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td>${employee.id}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${(employee.name)!}" />
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender"
					value="${(employee.gender)!}" />
				</td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" value="${(employee.age)!}" />
				</td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title"
					value="${(employee.title)!}" />
				</td>
			</tr>
			<tr>
				<td>Manager</td>
				<td><a href="${(employee.manager.id)!}">${(employee.manager.name)!}</a>
				</td>
			</tr>
		</table>
		<input type="submit" value="OK" />
	</form>
	<a href="../employees">Back</a>
</body>
</html>