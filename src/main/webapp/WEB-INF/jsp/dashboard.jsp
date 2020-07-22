<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <title>Spread Dashboard</title>
    <link rel="stylesheet" href="/css/blue/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/jquery.tablesorter.min.js"></script>
    <script src="/js/chart.min.js"></script>
    <script src="/js/chartjs-plugin-annotation.min.js"></script>
    <script src="/js/dashboard.js"></script>
    <script>
        $(document).ready(function() {

        });
    </script>
</head>
<body style="font-family:arial; font-size: 8pt;">
</body>
    <div class="container-sm">
        <div id="datatable">

        </div>
        <div id="spreadInAmount">

        </div>
        <div id="spreadInPercentage">

        </div>
        <div id="histogram">

        </div>
    </div>
</html>
