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
            var tr = $('<tr>').append(
                $('<td>').text(symbolSpread.symbol),
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
            sortList: [[1,0], [2,0]]
        });
    }
};