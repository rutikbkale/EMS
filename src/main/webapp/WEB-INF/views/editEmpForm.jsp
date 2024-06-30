<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="header.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header bg-primary">
                            <h3 class="text-center text-white">Edit Employee Details</h3>
                            <c:if test="${not empty msg}">
                                <p class="text-center text-white">${msg}</p>
                                <c:remove var="msg"></c:remove>
                            </c:if>
                        </div>
                        <div class="card-body">
                            <form method="post" action="editEmpDetails">
                                <input type="hidden" name="id" value="${emp.id}">
                                <div class="mb-3">
                                    <label for="firstName" class="form-label">First Name</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName" value="${emp.firstName}">
                                </div>
                                <div class="mb-3">
                                    <label for="lastName" class="form-label">Last Name</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName" value="${emp.lastName}">
                                </div>
                                <div class="mb-3">
                                    <label for="address" class="form-label">Address</label>
                                    <input type="text" class="form-control" id="address" name="address" value="${emp.address}">
                                </div>
                                <div class="mb-3">address
                                    <label for="dob" class="form-label">Date Of Birth</label>
                                    <input type="date" class="form-control" id="dob" name="dob" value="${emp.dob}">
                                </div>
                                <div class="mb-3">
                                    <label for="salary" class="form-label">Salary</label>
                                    <input type="text" class="form-control" id="salary" name="salary" value="${emp.salary}">
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
