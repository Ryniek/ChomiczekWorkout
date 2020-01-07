$.ajax({
    url: 'weightData',
    success: function (result) {
        var date = JSON.parse(result).date;
        var weigth = JSON.parse(result).weight;
        drawLineChart(date, weigth);
    }
})

function drawLineChart(date, weight) {
    var myChart = Highcharts.chart('container', {
        chart: {
            type: 'line',
            width: 800
        },
        title: {
            text: 'Waga ciała na przestrzeni czasu'
        },
        xAxis: {
            categories: date
        },
        yAxis: {
            title: {
                text: 'Waga[Kg]'
            }
        },
        series: [{
            name: 'Waga',
            data: weight
        }]
    });
}