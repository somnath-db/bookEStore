
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400&display=swap"
	rel="stylesheet" />
<style>
* {
	font-family: "Poppins", sans-serif;
	box-sizing: border-box;
}

h3 {
	margin-left: 40%;
	font-size: 30px;
}

h4 {
	margin-left: 5%;
	font-size: 15px;
}

.main {
	width: 50%;
	margin-left: 25%;
	border-radius: 5px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table td, table th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

table tr:nth-child(even) {
	background-color: #f2f2f2;
}

table tr:hover {
	background-color: #ddd;
}

table th {
	background-color: #4CAF50;
	color: white;
}

.button {
	padding: 6px 12px;
	background-color: #5dc4e3;
	border: none;
	color: white;
	border-radius: 4px;
	cursor: pointer;
}

nav {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 4px;
	background-color: #2b2e2b;
	color: white;
}

.nav-buttons button {
	background-color: #5dc4e3;
	border: none;
	color: white;
	border-radius: 6px;
	cursor: pointer;
	padding: 5px 10px;
}
</style>
</head>
<body>
	<nav>
		<h4>Book-E-Store</h4>
		<div class="nav-buttons">
			<button onclick="window.location.href='http://localhost:9090/search';">Search</button>
			<button onclick="window.location.href='http://localhost:9090/cart';">Cart</button>
		</div>
	</nav>
	<h3>Books Available</h3>
	<div class="main">
		<table>
			<tr>
				<th>Image</th>
				<th>Barcode</th>
				<th>Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Cart</th>
			</tr>
		
			<tr th:each="book : ${booklist}">
				<td><img src="https://www.epw.in/system/files/book%20rev.png"
					alt="Book Image" height="50"></td>
				<td th:text="${book.barcode}"></td>
				<td th:text="${book.name}"></td>
				<td th:text="${book.author}"></td>
				<td th:text="${book.price}"></td>
				<td th:text="${book.quantity}"></td>
				<td>
					<button class="button" onclick="addtoCart()">Add to Cart</button>
				</td>
			</tr>
			
		</table>
	</div>
</body>
</html>