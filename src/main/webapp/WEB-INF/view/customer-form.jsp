<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
    <head>
        <title>
            Add Customer Page
        </title>
    </head>
    
    <body>

        <h3>Save Customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="POST">
            First name: <form:input path="firstName" />
            <br><br>
            Last name: <form:input path="lastName" />
            <br><br>
            E-mail: <form:input path="email" />
            <br><br>
            <input type="submit" value="Save" />
        </form:form>


        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back To List</a>
        </p>
    </body>



</html>