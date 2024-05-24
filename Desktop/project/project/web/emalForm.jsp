<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <jsp:include page="_meta.jsp"/>
        <title>Xác nhận Email</title>
    </head>

    <body>
        <jsp:include page="_header1.jsp"/>

        <section class="section-content" style="margin: 100px 0;">
            <div class="card mx-auto" style="max-width: 380px">
                <div class="card-body">
                    <c:if test="${not empty requestScope.successMessage}">
                        <div class="alert alert-success" role="alert">${requestScope.successMessage}</div>
                    </c:if>
                    <c:if test="${not empty requestScope.errorMessage}">
                        <div class="alert alert-danger" role="alert">${requestScope.errorMessage}</div>
                    </c:if>
                        <h4 class="card-title mb-4" style="text-align: center">Xác nhận đăng nhập <br/>
                        Nhập mã từ email được gửi tới email của bạn</h4>
                    <form action="${pageContext.request.contextPath}/confirmEmail" method="post">
                        <div class="mb-3">
                            <label for="inputEmail" class="form-label">Mã xác nhận</label>
                            <input type="email"
                                   class="form-control ${not empty requestScope.violations.emailViolations
                                                         ? 'is-invalid' : (not empty requestScope.values.email ? 'is-valid' : '')}"
                                   id="inputEmail"
                                   name="email"
                                   value="${requestScope.values.email}"
                                   placeholder="Nhập mã xác minh">
                            <c:if test="${not empty requestScope.violations.emailViolations}">
                                <div class="invalid-feedback">
                                    <ul class="list-unstyled">
                                        <c:forEach var="violation" items="${requestScope.violations.emailViolations}">
                                            <li>${violation}</li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </c:if>
                        </div>
                        <button type="submit" class="btn btn-primary w-100">Xác nhận</button>
                    </form>
                </div> <!-- card-body.// -->
            </div> <!-- card.// -->
            <p class="text-center mt-4">Chưa có tài khoản? <a href="signupView.jsp">Đăng ký</a></p>
        </section> <!-- section-content.// -->

        <jsp:include page="_footer.jsp"/>
    </body>

</html>
