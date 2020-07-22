<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <title>Spread Dashboard</title>
    <link rel="stylesheet" href="/css/blue/style.css">
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/jquery.tablesorter.min.js"></script>
    <script src="/js/chart.min.js"></script>
    <script src="/js/chartjs-plugin-annotation.min.js"></script>
    <script src="/js/dashboard.js"></script>
    <script>
        $(document).ready(function() {
            dashboard.fetchAllSymbolSpreads();
        });
    </script>
</head>
<body>

    <div class="container-sm">
        <div id="allSymbolSpreadTable">

        </div>
        <div id="spreadInAmount">

        </div>
        <div id="spreadInPercentage">

        </div>
        <div id="histogram">

        </div>
    </div>

</body></html>
