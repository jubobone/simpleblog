<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- Header -->
<nav class="navbar navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">Simple Blog</a>
		</div>

		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="isAnonymous()">
					<ul class="nav pull-right">
						<li class="dropdown" id="menuLogin">
						<a href="/simpleblog/login">Login</a>
					</ul>
				</sec:authorize>
				<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
					<!-- Notification -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="glyphicon glyphicon-bell"></i>
							<b class="caret"></b></a>
						<ul class="dropdown-menu alert-dropdown">
							<li><a href="#">Alert Name <span
									class="label label-default">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-primary">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-success">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-info">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-warning">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-danger">Alert Badge</span></a></li>
							<li class="divider"></li>
							<li><a href="#">View All</a></li>
						</ul></li>

					<!-- User display -->

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <i class="fa fa-user"></i> User name <b
							class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
							</li>
							<li class="divider"></li>
							<li><a href="#"><i class="fa fa-fw fa-power-off"></i>
									Log Out</a></li>
						</ul></li>
					<!-- user thumbnel -->
					<li><img src="img/pakpao.jpg" height="50" width="50" /></li>
					<!-- end user thumbnel -->
				</sec:authorize>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>