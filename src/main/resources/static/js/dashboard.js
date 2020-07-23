dashboard = {
    selectedPeriod: 1,
    selectedSymbol: null,
    chart: null,
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

            var button = $('<a>', {
                class: 'green-background btn',
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
            sortList: [[3, 0], [4, 0]]
        });
    },
    showTimeFrames: function () {
        timeframes = [
            { label: '1M', period: 1 },
            { label: '5M', period: 5 },
            { label: '10M', period: 10 },
            { label: '15M', period: 15 },
            { label: '30M', period: 30 },
            { label: '1H', period: 60 },
            { label: '4H', period: 4 * 60 },
            { label: '12H', period: 12 * 60 },
            { label: '1D', period: 24 * 60 }
        ];

        timeframes.forEach(function (item) {
            var button = $('<a>', {
                class: 'orange-background btn',
                text: item.label,
                click: function () {
                    dashboard.selectedPeriod = item.period;
                    dashboard.showCharts();
                }
            });
            $('#timeframes').append(button);
        });
    },
    showCharts: function () {
        $.ajax({
            type: 'GET',
            url: '/data/' + dashboard.selectedSymbol + '/' + dashboard.selectedPeriod + '/spreadInPercentage',
            dataType: 'json',
            success: function (data) {
                $("#chart").show();
                dashboard.updateChart(data);
            }
        });
    },
    updateChart: function (data) {
        var labels = [];
        for (i = 0; i < data.length; i++) {
            labels.push("");
        }
        dashboard.chart;
        dashboard.chart.data.labels = labels;
        dashboard.chart.data.datasets[0].data = data;
        dashboard.chart.options.title.text = dashboard.selectedSymbol;
        dashboard.chart.update();
    },
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