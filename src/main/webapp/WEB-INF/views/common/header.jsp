<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="okhttp3.*" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="java.util.Objects" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <%
        String apiKey = "21ca248509cfaf37971c07ac47bfadf2";
        String baseUrl = "https://api.openweathermap.org/data/2.5/weather";
        OkHttpClient client = new OkHttpClient();

        String cityName = "Unknown";
        String weatherMain = "Unknown";
        String weatherIcon = "";
        double temperature = 0.0;

        double lat = 37.555134;
        double lon = 126.936893;

        Request rq = new Request.Builder()
                .url(baseUrl + "?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey + "&units=metric")
                .build();
        try (Response rp = client.newCall(rq).execute()) {
            if (rp.isSuccessful()) {
                String responseBody = Objects.requireNonNull(rp.body()).string();
                JSONObject weatherJson = new JSONObject(responseBody);
                cityName = weatherJson.getString("name");
                weatherMain = weatherJson.getJSONArray("weather").getJSONObject(0).getString("main");
                weatherIcon = weatherJson.getJSONArray("weather").getJSONObject(0).getString("icon");
                temperature = weatherJson.getJSONObject("main").getDouble("temp");
            }
        }
    %>

    <title>Cookology - Home</title>
    <style type="text/css">

        #loginBox {
            position: absolute;
            left: 1100px;
            top: 10px;
            z-index: 20;
            font-size: 13px;
            text-decoration: none;
        }

        #loginBox a {
            color: black;
        }

        #loginBox a:visited {
            color: black;
        }

        .logout-btn {
            padding: 1px;
        }

    </style>
    <!-- Favicon -->
    <link rel="icon"
          href="/cookology/resources/img/core-img/Cookology_logo.png" />
    <!-- Core Stylesheet -->
    <link href="/cookology/resources/css/style.css" rel="stylesheet" />
    <link href="/cookology/resources/css/responsive.css"
          rel="stylesheet" />
    <script type="text/javascript"
            src="${ pageContext.servletContext.contextPath }/resources/js/jquery-3.6.3.min.js"></script>
    <script type="text/javascript">
        function movePage() {
            location.href = "loginPage.do";
        }
    </script>
</head>

<body>
<!-- ****** Top Header Area Start ****** -->
<div class="top_header_area">
    <div class="container">
        <div class="row">
            <!--  Top Social bar => top_weather_bar start -->
            <div class="col-5 col-sm-6">
                <div class="top_weather_bar">
                    <div class="weather-info">
                        <span> City: <%= cityName %> </span>
                        <img class="weather-icon" src="https://openweathermap.org/img/wn/<%= weatherIcon %>@2x.png" alt="Weather Icon">
                        <span> 현재 날씨 : <%= weatherMain %> </span>
                        <span> 현재 온도 : <%= temperature %>℃ </span>
                    </div>
                </div>
            </div>

            <!--  Login Register Area -->
            <div class="col-7 col-sm-6">
                <div
                        class="signup-search-area d-flex align-items-center justify-content-end">

                    <!-- Login Area Display Start -->
                    <!-- 로그인 안 했을 때 : Session 객체 안에 loginMember 가 없다면 -->
                    <c:if test="${ empty sessionScope.loginUsers }">
                        <div class="login_register_area d-flex">
                            <div class="login">
                                <a href="${pageContext.servletContext.contextPath}/loginPage.do">로그인</a>
                            </div>

                            <div class="register">
                                <a href="${ pageContext.servletContext.contextPath}/usersSignUpPage.do">회원가입</a>
                            </div>

                            <div class="userService">
                                <a href="FAQPage.do">고객지원</a>
                            </div>
                        </div>
                    </c:if>
                    <!-- Login Area Display End -->

                </div>
            </div>

            <!-- 로그인 했을 때 : 일반회원인 경우 -->
            <c:if test="${!empty sessionScope.loginUsers and loginUsers.is_admin eq 'N' }">
                <div id="loginBox" class="lineA"> ${ loginUsers.user_email }님 &nbsp; <a>쪽지</a> &nbsp; &nbsp; <a>메일</a>

                    <!-- 마이페이지 클릭시 연결대상과 전달값 지정 -->
                    <c:url var="userMypage_Info" value="/uMypage_InfoForm.do">
                        <c:param name="user_email" value="${loginUsers.user_email }" />
                    </c:url>
                    <a href="${userMypage_Info}">My Page</a> &nbsp;
                    <button class="logout-btn" onclick="javascript:location.href='userslogout.do';">
                        <span>로그아웃</span>
                    </button>
                        <a href="FAQPage.do">고객지원</a>
                </div>
            </c:if>

            <!-- 로그인 했을 때 : 관리자인 경우 -->
            <c:if test="${!empty sessionScope.loginUsers and loginUsers.is_admin eq 'Y' }">
                <div id="loginBox" class="lineA">
                        ${ loginMember.username } 님 &nbsp; <a
                        href="${ pageContext.servletContext.contextPath}/admin.do">관리
                    페이지로 이동</a> &nbsp;
                    <button class="logout-btn"
                            onclick="javascript:location.href='usersLoggout.do';">
                        <span>로그아웃</span>
                    </button><a href="FAQPage.do">고객지원</a>

                </div>

            </c:if>
            <!-- Login Area Display End -->
        </div>
    </div>
</div>
<!-- ****** Top Header Area End ****** -->

<!-- ****** Header Area Start ****** -->
<header class="header_area">
    <div class="container">
        <div class="row">
            <!-- Logo Area Start -->
            <div class="col-12">
                <div class="logo_area text-center">
                    <a href="${ pageContext.servletContext.contextPath}/main.do"
                       class="yummy-logo"> Cookology</a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <nav class="navbar navbar-expand-lg">
                    <!-- Menu Area Start -->
                    <div class="collapse navbar-collapse justify-content-center"
                         id="yummyfood-nav">
                        <ul class="navbar-nav" id="yummy-nav">
                            <li class="nav-item"><a class="nav-link"
                                                    href="${ pageContext.servletContext.contextPath}/rpage.do">레시피</a></li>
                            <li class="nav-item"><a class="nav-link"
                                                    href="${ pageContext.servletContext.contextPath}/productUserList.do">밀키트</a></li>
                            <li class="nav-item"><a class="nav-link"
                                                    href="${ pageContext.servletContext.contextPath}/eventPage.do">이벤트</a></li>
                            <li class="nav-item"><a class="nav-link"
                                                    href="${ pageContext.servletContext.contextPath}/trackingPage.do">배송조회</a></li>
                            <li class="nav-item">
                                <c:url var="cart" value="cartList.do">
                                    <c:param name="user_email" value="${ loginUsers.user_email }" />
                                </c:url>
                                <a class="nav-link" href="${ cart }">장바구니</a>&nbsp; &nbsp;
                            </li>

                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>

<!-- ****** Header Area End ****** -->

<!-- Jquery-3.6.3 js -->
<script src="/cookology/resources/js/jquery-3.6.3.min.js"></script>
<!-- Popper js -->
<script src="/cookology/resources/js/bootstrap/popper.min.js"></script>
<!-- Bootstrap-4 js -->
<script src="/cookology/resources/js/bootstrap/bootstrap.min.js"></script>
<!-- All Plugins JS -->
<script src="/cookology/resources/js/others/plugins.js"></script>
<!-- Active JS -->
<script src="/cookology/resources/js/active.js"></script>
</body>
</html>