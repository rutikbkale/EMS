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
                <div class="col-md-12">
                    <div>
                        <h3 class="text-center text-primary fs-2">Employee List</h3>
                        <c:if test="${not empty msg}">
                            <p class="text-center text-primary">${msg}</p>
                            <c:remove var="msg"></c:remove>
                        </c:if>
                    </div>
                    <table class="table table-striped table-hover mt-3">
                        <thead>
                            <tr>
                                <th scope="col" class=" text-primary text-center fs-5">Emp Id</th>
                                <th scope="col" class=" text-primary text-center fs-5">First Name</th>
                                <th scope="col" class=" text-primary text-center fs-5">Last Name</th>
                                <th scope="col" class=" text-primary text-center fs-5">Address</th>
                                <th scope="col" class=" text-primary text-center fs-5">DOB</th>
                                <th scope="col" class=" text-primary text-center fs-5">Salary</th>
                                <th scope="col" class=" text-primary text-center fs-5">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${empList}" var="emp">
                                <tr>
                                    <th class="text-center">${emp.id}</th>
                                    <td class="text-center">${emp.firstName}</td>
                                    <td class="text-center">${emp.lastName}</td>
                                    <td class="text-center">${emp.address}</td>
                                    <td class="text-center">${emp.dob}</td>
                                    <td class="text-center">${emp.salary}</td>
                                    <td class="text-center">
                                        <a href="editEmp?id=${emp.id}" class="btn btn-warning">Edit</a>
                                        <a href="deleteEmp?id=${emp.id}" class="btn btn-danger ms-3">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
