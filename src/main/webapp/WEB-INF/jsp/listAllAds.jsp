<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="includes/resources.jsp"/>
</head>

<body>

<!-- Navigation -->

<jsp:include page="includes/navbar.jsp"/>

<!-- Page Content -->
<div class="container">

    <c:if test="${fn:length(adItemList) gt 0}">
    <br>
    <c:forEach begin="0" items="${adItemList}" var="adItem" varStatus="rowCounter">


        <c:if test="${rowCounter.count % 3 == 1}">
            <div class="row">
            <tr>
        </c:if>
        <div class="col-md-4">
            <div class="well">
                <td><h3>${adItem.adTopic}</h3>
                    <a href="#">  <img class="img-responsive" src="${adItem.posterUrl}" alt=""> </a>
                    <br/>Price : ${adItem.itemPrice}
                    <br/>${adItem.script}</td>
            </div>
        </div>
        <c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(values)}">
            </tr>
            </div>
        </c:if>


</c:forEach>
</c:if>

</div>

<jsp:include page="includes/footer.jsp"></jsp:include>


</body>

</html>
