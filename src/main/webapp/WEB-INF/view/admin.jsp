<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<%@ include file="./components/common_cs_js.jsp"%>

</head>
<body>
	<%@ include file="./components/navbar.jsp"%>

	<%
	List<Category> li = new ArrayList<>();
	li = categoryDao.getAllCategory();
	List<User> listOfAllUsers = new ArrayList<>();
	listOfAllUsers = userDao.getAllUser();
	%>

	<div class="container admin mt-2">
		<%@ include file="./components/message.jsp"%>
		<div class="row mt-3">
			<div class="col-md-4">
				<div class="card hover" data-toggle="modal"
					data-target="#show-users-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="resources/images/totalUser.jpg" alt="users_pic">
						</div>
						
						<h2 class="text-uppercase text-muted">Users</h2>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card hover" data-toggle="modal"
					data-target="#show-category-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="resources/images/brand.jpg" alt="users_pic">
						</div>
						
						<h2 class="text-uppercase text-muted">Total Category</h2>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card hover" data-toggle="modal"
					data-target="#show-product-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="resources/images/products.jpg" alt="users_pic">
						</div>
						
						<h2 class="text-uppercase text-muted">Total Products</h2>
					</div>
				</div>
			</div>
		</div>

		<div class="row mt-3">
			<div class="col-md-4">
				<div class="card hover" data-toggle="modal"
					data-target="#total-order-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="resources/images/orders.jpg" alt="users_pic">
						</div>
						<p class="text-lowercase text-muted mt-2 " style="font-size: 22px">Check here for</p>
						<h2 class="text-uppercase text-muted">Total Orders</h2>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card hover" data-toggle="modal"
					data-target="#add-category-modal">
					<div class="card-body text-center">
						<div class="container md-5">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="resources/images/addbrand.jpg" alt="users_pic">
						</div>
						<p class="text-lowercase text-muted mt-2 " style="font-size: 22px">click
							to add category</p>
						<h2 class="text-uppercase text-muted mt-1">Add Category</h2>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card hover" data-toggle="modal"
					data-target="#add-product-modal">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 120px" class="img-fluid rounded-circle"
								src="resources/images/addproduct.jpg" alt="users_pic">
						</div>
						<p class="text-lowercase text-muted mt-2 " style="font-size: 22px">click
							to add product</p>
						<h2 class="text-uppercase text-muted">Add Product</h2>
					</div>
				</div>
			</div>

		</div>

	</div>

	<!-- add category modal -->

	<div class="modal fade" id="add-category-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLongTitle">Fill
						category details.</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="addcategory" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="name"
								placeholder="Enter Category Title here" required>
						</div>

						<div class="form-group">
							<textarea style="height: 250px" class="form-control"
								name="description" placeholder="Enter Category Description here"
								required></textarea>
						</div>

						<div class="container text-center">
							<button class="btn custom-bg text-white">Add Category</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- end add category modal -->

	<!-- add product modal -->

	<div class="modal fade" id="add-product-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLongTitle">Add Product
						details.</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="addproduct" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<input type="text" class="form-control" name="name"
								placeholder="Enter Product Title here" required>
						</div>

						<div class="form-group">
							<textarea style="height: 150px" class="form-control"
								name="description" placeholder="Enter Product Description here"
								required></textarea>
						</div>
						
						<div class="form-group">
							<input type="number" class="form-control" name="quantity"
								placeholder="Enter Product Quantity here" required>
						</div>

						<div class="form-group">
							<input type="number" class="form-control" name="price"
								placeholder="Enter Product Price here" required>
						</div>

						<div class="form-group">
							<input type="text" class="form-control" name="discount"
								placeholder="Enter Product Discount in (%)" required>
						</div>

						<div class="form-group">
							<select name="categoryId" class="form-control">
								<option value="">Select Category</option>
								<%
								for (Category category : li) {
								%>
								<option value="<%=category.getId()%>"><%=category.getName()%></option>
								<%
								}
								%>
							</select>
						</div>

						<div class="form-group">
							<label>Select Product Pic</label><br> <input type="file"
								class="form-control" name="image" required>
						</div>

						<div class="container text-center">
							<button class="btn custom-bg text-white">Add Product</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- end add product modal -->

	<!-- show users modal -->

	<div class="modal fade" id="show-users-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white text-center">
					<h5 class="modal-title" id="exampleModalLongTitle">Total
						Users</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<table class="table">
							<thead class="custom-bg text-white">
								<tr>
									<th scope="col">User Id</th>
									<th scope="col">First Name</th>
									<th scope="col">Last Name</th>
									<th scope="col">Email Id</th>
									<th scope="col">Mobile</th>
									<th scope="col">Address</th>
								</tr>
							</thead>
							<tbody>

								<%
								for (User u : listOfAllUsers) {
								%>
								<tr>
									<th scope="row" class="mid-align"><%=u.getId()%></th>
									<td class="mid-align"><%=u.getFirstname()%></td>
									<td class="mid-align"><%=u.getLastname()%></td>
									<td class="mid-align"><%=u.getEmailid()%></td>
									<td class="mid-align"><%=u.getMobileno()%></td>
									<td class="mid-align"><%=u.getStreet() + " " + u.getCity() + " " + u.getPincode()%></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- end of show users modal -->

	<!-- show category modal -->

	<div class="modal fade" id="show-category-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white text-center">
					<h5 class="modal-title" id="exampleModalLongTitle">Total
						Category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<table class="table">
							<thead class="custom-bg text-white">
								<tr>
									<th scope="col">Category Id</th>
									<th scope="col">Category Name</th>
									<th scope="col">Category Description</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								for (Category c : categoryDao.getAllCategory()) {
								%>
								<tr>
									<td class="mid-align"><%=c.getId()%></td>
									<td class="mid-align"><%=c.getName()%></td>
									<td class="mid-align"><%=c.getDescription()%></td>
									<td class="mid-align"><a
										href="deletecategory?categoryId=<%=c.getId()%>"><input
											type="submit" class="btn btn-danger" value="Delete"></a></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ********************* -->

	<!-- show Product modal -->

	<div class="modal fade" id="show-product-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white text-center">
					<h5 class="modal-title" id="exampleModalLongTitle">Total Product</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="table-responsive">
						<table class="table">
							<thead class="custom-bg text-white">
								<tr>
									<th scope="col">Product Name</th>
									<th scope="col">Product Image</th>
									<th scope="col">Product Description</th>
									<th scope="col">Product Category</th>
									<th scope="col">Product Price</th>
									<th scope="col">Product Discount</th>
								</tr>
							</thead>
							<tbody>
								<%
								List<Product> lp = productDao.getAllProducts();
								%>

								<%
								for (Product p : lp) {
								%>
								<tr>
									<td class="mid-align"><%=p.getName()%></td>
									<td class="mid-align"><img style="max-width: 70px"
										class="img-fluid"
										src="resources/productpic/<%=p.getImagePath()%>"
										alt="users_pic"></td>
									<td class="mid-align"><%=p.getDescription()%></td>

									<%
									Category cat  = categoryDao.getCategoryById(p.getCategoryId());
									
									%>

									<td class="mid-align"><%=cat.getName()%></td>
									<td class="mid-align"><%=p.getPrice()%></td>
									<td class="mid-align"><%=p.getDiscount()%></td>

								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ********************* -->

	<!-- total order modal -->

	<div class="modal fade bd-example-modal-lg" id="total-order-modal"
		tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg modal-size" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white text-center">
					<h5 class="modal-title" id="exampleModalLongTitle">TOTAL
						ORDERS</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">

					<%
					List<Orders> lor = orderDao.getAllOrder();
					if (lor == null) {
					%>
					<div class="text-center">
						<h1>NO ORDERS MADE BY ANYONE !!</h1>
						<hr>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
					<%
					}

					else {
					%>
					<div class="table-responsive">
						<table class="table">
							<thead class="custom-bg text-white">
								<tr class="text-center">
									<th scope="col">Order Id</th>
									<th scope="col">User Id</th>
									<th scope="col">User Name</th>
									<th scope="col">User Email</th>
									<th scope="col">User Phone</th>
									<th scope="col">Product Image</th>
									<th scope="col">Product Title</th>
									<th scope="col">Qnty</th>
									<th scope="col">Price</th>
									<th scope="col">Ord. date</th>
									<th scope="col">Delivery date</th>
									<th scope="col">Delivery Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>



							<tbody>

								<%
								for (Orders o : lor) {

									Product f = productDao.getProductById(o.getProductId());
									
							
									User u = userDao.getUserById(o.getUserId());
									
								%>
								<tr class="text-center">
									<td class="mid-align"><%=o.getOrderId()%></td>
									<td class="mid-align"><%=u.getId()%></td>
									<td class="mid-align"><%=u.getFirstname()%></td>
									<td class="mid-align"><%=u.getEmailid()%></td>
									<td class="mid-align"><%=u.getMobileno()%></td>
									<td><img
										style="max-height: 100px; max-width: 70px; width: auto;"
										class="img-fluid mx-auto d-block"
										src="resources/productpic/<%=f.getImagePath()%>"
										alt="users_pic"></td>
									<td class="mid-align"><%=f.getName()%></td>
									<td class="mid-align"><%=o.getQuantity()%></td>
									<td class="mid-align"><%=(new Helper().getProductSellingPrice(f.getPrice(), f.getDiscount())) * o.getQuantity()%></td>
									<td class="mid-align"><%=o.getOrderDate()%></td>
									<td class="mid-align"><%=o.getDeliveryDate()%></td>
									<td class="mid-align"><%=o.getDeliveryStatus()%></td>
									<td class="mid-align">
										<form action="updatedeliverydate">

											<input type="hidden" name="orderId" value=<%=o.getOrderId()%>>

											<div class="form-group mx-sm-3 mb-2">
												<input type="text" class="form-control" name="deliveryDate"
													placeholder="Delivery Date" size="85" required>
											</div>
											<div class="form-group mx-sm-3 mb-2">
												<select name="deliveryStatus" class="form-control">
													<option value="Pending">Pending</option>
													<option value="Delivered">Delivered</option>
													<option value="On the Way">On the Way</option>
													<option value="Processing">Processing</option>
												</select>
											</div>
											<button type="submit" class="btn custom-bg text-white mb-2">Set</button>
										</form>
									</td>
								</tr>
								<%
								}
								%>
							</tbody>


						</table>
					</div>
					<hr>

					<div class="text-center">
						<button type="button" class="btn btn-secondary ml-5"
							data-dismiss="modal">Close</button>
					</div>
					<%
					}
					%>

				</div>
			</div>
		</div>
	</div>

	<!--  -->

</body>
</html>