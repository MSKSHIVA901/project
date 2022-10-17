<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Algorithm for Multi Keyword Search Over
Encrypted Data in Cloud Environment</title><!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="css/theme.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700,400italic,700italic" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
<!-- Navigation -->
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
		<i class="fa fa-bars"></i>
		</button>
		<a class="navbar-brand page-scroll" href="index.html">
		Cloud Computing</a>
	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-right navbar-main-collapse">
		<ul class="nav navbar-nav">
			<li>
			<a href="UserHome.jsp">Home</a>
			</li>
			<li>
			<a href="GenratingIndex.jsp">Genrating Index</a>
			</li>
			<li>
			<a href="SearchData.jsp">Search Data</a>
			</li>
			<li>
			<a href="EncryptData.jsp">Encrypt Data</a>
			</li>
			<li>
			<a href="Request.jsp">Request</a>
			</li>
			<li>
			<a href="Response.jsp">Response</a>
			</li>
			<li>
			<a href="index.html">Logout</a>
			</li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</div>
<!-- /.container -->
</nav>
<!-- Intro Header -->
<header class="intro">
<div class="intro-body">
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h1 class="brand-heading">SEARCH ENCRYPTED FILES</h1>
				<p class="intro-text">
					<%
					String uid=(String)session.getAttribute("name");
					%>
					<%=uid %>
				</p>
				<a href="#about" class="btn btn-circle page-scroll">
				<i class="fa fa-angle-double-down animated"></i>
				</a>
			</div>
		</div>
	</div>
</div>
</header>
<!-- About Section -->
<section id="about">
<div class="container content-section text-center">
	<div class="row">
		<h2>SEARCH HERE</h2>
			<form action="FSearch.jsp">
					<table style="width: 1150px; padding-left: -10px; color: black;">
						<!-- <thead>
							 <tr>
								<th  style="color: black;font-size: 22px;">File Name</th>
								<th  style="color: black;font-size: 22px;">Search Keywords</th>
							</tr> 
						</thead> -->
						<tbody>
							<tr>
							<td><input type="text" name="sub" placeholder="Search Keywords" style="width: 150px;"/></td>
							<td ><input type="submit" value="Search" style="width: 150px;color: black;" class="btn btn-circle page-scroll" /></td>
							</tr>
						</tbody>
					</table>
				</form>
				<br/><br/><br/><br/>
			<p>
				<a href="#" class="btnghost"><i class="fa fa-download"></i> Curriculum Vitae</a>
			</p>
		</div>
	</div>
</section>
<!-- jQuery -->
<script src="js/jquery.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<!-- Plugin JavaScript -->
<script src="js/jquery.easing.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/theme.js"></script>
</body>
</html>