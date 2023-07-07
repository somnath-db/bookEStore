
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Search</title>
</head>
<body>

<h1>Book Search</h1>
  
  <form action="/searchhandler" method="GET">
    <label for="filter">Filter:</label>
    <select id="filter" name="filter">
      <option value="title">search by title</option>
      <option value="author">search by author</option>
    </select>
    <input type="text" id="query" name="query">
    
    <button type="submit">Search</button>
  </form>
  
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

</body>
</html>