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
            $('<th>').text('Spread Percentage'),
            $('<th>').text('Timeframe')
        );
        var thead = $('<thead>').append(th);
        table.append(thead);
        var tbody = $('<tbody>');
        dashboard.allSymbolSpreads.forEach(function (symbolSpread) {
            var button = $('<a>', {
                class: 'orange-background btn',
                text: '1M',
                click: function () {
                    dashboard.showCharts(symbolSpread.symbol, 1);
                }
            });
            var tr = $('<tr>').append(
                $('<td>').text(symbolSpread.symbol),
                $('<td>').text(symbolSpread.bidPrice),
                $('<td>').text(symbolSpread.askPrice),
                $('<td>').text(symbolSpread.spreadInAmount),
                $('<td>').text(symbolSpread.spreadInPercentage),
                $('<td>').append(button)
            );
            tbody.append(tr);
        });
        table.append(tbody);
        $('#allSymbolSpreadTable').html(table);
        table.tablesorter({
            sortList: [[1, 0], [2, 0]]
        });
    },
    showCharts: function (symbol, period) {
        $.ajax({
            type: 'GET',
            url: '/data/' + symbol + '/' + period + '/spreadInPercentage',
            dataType: 'json',
            success: function (data) {
                $("#chart").show();
                dashboard.updateChart(symbol, data);
            }
        });
    },
    updateChart: function (symbol, data) {
        var labels = [];
        for (i = 0; i < data.length; i++) {
            labels.push("");
        }
        dashboard.chart;
        dashboard.chart.data.labels = labels;
        dashboard.chart.data.datasets[0].data = data;
        dashboard.chart.options.title.text = symbol;
        dashboard.chart.update();
    },
    chart: null,
    buildChart: function (id) {
        dashboard.chart = new Chart(document.getElementById(id).getContext('2d'), {
            type: 'line',
            data: {
                labels: [],
                datasets: [
                    {
                        label: 'Spread',
                        data: [],
                        backgroundColor: 'rgba(255, 255, 255, 0)',
                        borderColor: 'rgba(255, 198, 16, 1)'
                    }
                ]
            },
            options: {
                title: {
                    display: true,
                    text: "Spread"
                },
                legend: {
                    display: false
                },
                scales: {
                    yAxes: [{
                        gridLines: {
                            display: false
                        }
                    }]
                }
            }
        });
    }
};