<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 
    If the user is anonymous (not logged in), show the login form
    and social sign in buttons.
-->
<sec:authorize access="isAnonymous()">
    <!-- Login form -->
    <div class="panel panel-default">
        <div class="panel-body">
            <!--
                Error message is shown if login fails.
            -->
            <c:if test="${param.error eq 'bad_credentials'}">
                <div class="alert alert-danger alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <spring:message code="text.login.page.login.failed.error"/>
                </div>
            </c:if>
            <!-- Specifies action and HTTP method -->
            <form action="${pageContext.request.contextPath}/login/authenticate" method="POST" role="form">
                <!-- Add CSRF token -->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="row">
                    <div id="form-group-email" class="form-group col-lg-4">
                        <label class="control-label" for="user-email">email :</label>
                        <!-- Add username field to the login form -->
                        <input id="user-email" name="username" type="text" class="form-control"/>
                    </div>
                </div>
 
                <div class="row">
                    <div id="form-group-password" class="form-group col-lg-4">
                        <label class="control-label" for="user-password">password :</label>
                        <!-- Add password field to the login form -->
                        <input id="user-password" name="password" type="password" class="form-control"/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-4">
                        <!-- Add submit button -->
                        <button type="submit" class="btn btn-default">Login</button>
                    </div>
                </div>
            </form>
            <div class="row">
                <div class="form-group col-lg-4">
                    <!-- Add create user account link -->
                    <a href="${pageContext.request.contextPath}/register">Create user account</a>
                </div>
            </div>
        </div>
    </div>
</sec:authorize>
<!-- 
    If the user is already authenticated, show a help message instead
    of the login form and social sign in buttons.
-->
<sec:authorize access="isAuthenticated()">
    <p><spring:message code="text.login.page.authenticated.user.help"/></p>
</sec:authorize>