$.ajax({
    url: 'weightData',
    success: function (result) {
        var date = JSON.parse(result).date;
        var weight = JSON.parse(result).weight;
        drawWeightChart(date, weight);
    }
})

function drawWeightChart(date, weight) {
    var myChart = Highcharts.chart('weight', {
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