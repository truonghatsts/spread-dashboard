dashboard = {
    fetchAllSymbolSpreads: function () {
        $.ajax({
            type: 'GET',
            url: '/data/allSymbolSpreads',
            dataType: 'json',
            success: function (data) {
                dashboard.allSymbolSpreads = data;
                dashboard.showAllSymbolSpreadTable();
            }
        });
    },
    showAllSymbolSpreadTable: function () {
        var table = $('<table></table>').addClass('tablesorter');
        var th = $('<tr>').append(
            $('<th>').text('Symbol'),
            $('<th>').text('Bid Price'),
            $('<th>').text('Ask Price'),
            $('<th>').text('Spread Amount'),
            $('<th>').text('Spread Percentage')
        );
        var thead = $('<thead>').append(th);
        table.append(thead);
        var tbody = $('<tbody>');
        dashboard.allSymbolSpreads.forEach(function (symbolSpread) {
            var button = $('<button>', {
                text: symbolSpread.symbol,
                click: function () {
                    dashboard.selectedSymbol = symbolSpread.symbol;
                    dashboard.showCharts();
                }
            });
            var tr = $('<tr>').append(
                $('<td>').html(button),
                $('<td>').text(symbolSpread.bidPrice),
                $('<td>').text(symbolSpread.askPrice),
                $('<td>').text(symbolSpread.spreadInAmount),
                $('<td>').text(symbolSpread.spreadInPercentage)
            );
            tbody.append(tr);
        });
        table.append(tbody);
        $('#allSymbolSpreadTable').html(table);
        table.tablesorter({
            sortList: [[1, 0], [2, 0]]
        });
    },
    showCharts: function () {
        alert("Showing charts for " + dashboard.selectedSymbol);
        dashboard.showSpreadInPercentageChart(1);
        dashboard.showSpreadInAmountChart(1);
    },
    showSpreadInPercentageChart: function (period) {
        $.ajax({
            type: 'GET',
            url: '/data/' + dashboard.selectedSymbol + '/' + period + '/spreadInPercentage',
            dataType: 'json',
            success: function (data) {
                dashboard.spreadInPercentage = data;
            }
        });
    },
    showSpreadInAmountChart: function (period) {
        $.ajax({
            type: 'GET',
            url: '/data/' + dashboard.selectedSymbol + '/' + period +  '/spreadInAmount',
            dataType: 'json',
            success: function (data) {
                dashboard.spreadInAmount = data;
            }
        });
    },
};