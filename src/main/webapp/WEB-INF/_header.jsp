<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
    List<String> colors = new ArrayList<>();
    colors.add("Default");
    colors.add("Red");
    colors.add("Green");
//adding colors as attribute
//    request.setAttribute("colors", colors);
    // intelliJ doesn't like it but it works. we are defining the colors only within the page instead of globally by using request.setAttribute
    pageContext.setAttribute("colors", colors);
%>

<header class="clearfix">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <c:if test="${empty sessionScope.user}">
                            <a class="nav-link" href='showlogin.do'>Login</a>
                        </c:if>
                        <c:if test="${!empty sessionScope.user}">
                            <a class="nav-link" href='logout.do'>Logout ${user.name}</a>
                        </c:if>

                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Color
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <c:choose>
                                <c:when test="${!empty user}">
                                    <c:forEach items="${colors}" var="color">
                                        <li>${color}</li>
                                    </c:forEach>

                                </c:when>
                                <c:otherwise>
                                    <li>No User Logged In</li>
                                </c:otherwise>
                            </c:choose>


                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>