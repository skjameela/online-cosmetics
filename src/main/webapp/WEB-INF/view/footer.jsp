<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Model Store</title>
    <link rel="stylesheet" href="css/footer.css">
	<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    
</head>
<body>
<footer>
	<div id="about" class="subscript">
		<div data-aos="fade-up" data-aos-offset="200">
			<h1>Subscribe</h1>
			<p>Make Subscribe to my WebSite rate your product.</p>
		</div>
		<div class="n-text" data-aos="fade-up-right" data-aos-offset="200">
			<label>
				<input type="text" name="" placeholder="Enter your email">
				<button>Subscribe</button>

			</label>
		</div>
	</div>	


	<div class="f-contact" data-aos="zoom-in-up" data-aos-offset="200">
		<div>
			<h1>Information</h1>
			<p>Model Store Team from ITCrats.</p>
			
			<i class="fa fa-whatsapp"></i>
			<i class="fa fa-instagram"></i>
			<i class="fa fa-telegram"></i>
			<i class="fa fa-twitter"></i>
		</div>


		<div>
			<h1>Useful links</h1>
			<p>About us</p>
			<p>Home page</p>
			<p>Pricing plans</p>

		</div>

		<div>
			<h1>Details</h1>
			
			<p>About us</p>
			<p>Contact us</p>

		</div>

		<div>
			<h1>Help & Support</h1>
			<p>Privacy policy</p>
			<p>Term & conditions</p>
			<p>Technical support</p>
			<p>Customer care</p>

		</div>
	</div>
</footer>

<!-- <script
  src="https://code.jquery.com/jquery-3.6.3.min.js"
  integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
  crossorigin="anonymous"></script> -->

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous">
</script>



<script src="https://unpkg.com/isotope-layout@3/dist/isotope.pkgd.min.js"></script>


<script>
	$('.portfolio-item').isotope({
  // options
  itemSelector: '.item',
  layoutMode: 'fitRows'
});
		$('.portfolio-menu ul li').click(function(){
		$('.portfolio-menu ul li').removeClass('active');
		$(this).addClass('active');

			var selector = $(this).attr('data-filter');
		$('.portfolio-item').isotope({
			filter:selector
		});
		return false;
	});
</script>


<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>


<script>
  AOS.init();
</script>

</body>
</html>