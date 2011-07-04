<html>
<head>
<title>EMS</title>
</head>
<body>
	<script type="text/javascript" src="../js/management.js"></script>
	<h1>Employee Management System</h1>
	<hr />
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th></th>
				<th></th>
			</tr>
			<#list employees as employee>
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td><a href="employees/${employee.id}">Edit</a></td>
				<td><a href="employees"
					onClick="deleteEmployee(${employee.id})">Delete</a></td>
			</tr>
			</#list>
		</table>
	</div>
	<br/>
	<br/>
	<div>
		<form action="employees" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" /></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>Manager</td>
					<td><input type="text" name="manager" /></td>
				</tr>
			</table>
			<input type="submit" value="Create" />
		</form>
	</div>
</body>
</html>