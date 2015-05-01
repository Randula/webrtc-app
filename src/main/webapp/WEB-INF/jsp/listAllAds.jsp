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

<div class="row">

    <div class="col-md-3">
        <p class="lead">Sub Category</p>
        <div class="list-group">
            <a href="#" class="list-group-item active">TV</a>
            <a href="#" class="list-group-item">Camera</a>
            <a href="#" class="list-group-item">Gadgets</a>
        </div>
    </div>

    <div class="col-md-9">

        <c:if test="${fn:length(adItemList) gt 0}">
            <hr style="color: #000000">
            <br>
            <c:forEach begin="0" items="${adItemList}" var="adItem">
            <div class="well">
                <div class="row">
                    <div class="col-md-3">
                        <a class="pull-left" href="#">
                            <img class="img-responsive" src="${adItem.posterUrl}" alt="">
                        </a>
                    </div>
                    <c:url var="displayAd" value="displayItems.htm">
                        <c:param name="adId" value="${adItem.adId}"/>
                    </c:url>
                    <div class="col-md-9">
                        <h3><a href="${displayAd}"> ${adItem.adTopic} </a></h3>
                        <h5>${adItem.date}</h5>
                    </div>
                </div>
            </div>
            </c:forEach>
        </c:if>

    </div>

</div>
    <jsp:include page="includes/footer.jsp"></jsp:include>

</div>

</body>

</html>
