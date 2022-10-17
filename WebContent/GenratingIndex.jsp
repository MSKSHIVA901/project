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
		<h2>GENERATE INDEX</h2>
				<form class="row login_form" action="GenerateIndex" method="post" style="text-align: left;">
			<table style="width: 1150px; padding-left: 160px; color: black;">
			<thead>
			<tr>
			<th  style="color: black;font-size: 22px;">Keyword 1</th>
			<th  style="color: black;font-size: 22px;">Keyword 2</th>
			<th  style="color: black;font-size: 22px;">Keyword 3</th>
			<th  style="color: black;font-size: 22px;">Symantic Key</th>
			<th  style="color: black;font-size: 22px;">File Keyword</th>
			<th  style="color: black;font-size: 22px;">Genarate Search Index </th></tr>
			</thead>
			<tr>
			<td><input type="text" class="form-control" id="key1" name="key1" placeholder="Enter Keyword 1" style="width: 200px;"></td>
			<td><input type="text" class="form-control" id="key2" name="key2" placeholder="Enter Keyword 2"  style="width: 200px;"></td>
			<td><input type="text" class="form-control" id="key3" name="key3" placeholder="Enter Keyword 3"  style="width: 200px;"></td>
			<td><input type="text" class="form-control" id="sk" name="sk" placeholder="Symantic key"   style="width: 200px;" ></td>
			<td><input type="text" class="form-control" id="keys" name="keys" placeholder="Enter Search Keywords"   style="width: 200px;" ></td>
			<td><button type="submit" value="Genarate" style="width: 150px;color: black;" class="btn btn-circle page-scroll"  >Generate</button></td>
			</tr>
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