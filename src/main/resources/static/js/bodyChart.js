$.ajax({
    url: 'bodyData',
    success: function (result) {
        var date = JSON.parse(result).date;
        var armSize = JSON.parse(result).armSize;
        var calfSize = JSON.parse(result).calfSize;
        var chestSize = JSON.parse(result).chestSize;
        var forearmSize = JSON.parse(result).forearmSize;
        var thighSize = JSON.parse(result).thighSize;
        drawLineChart(date, armSize, calfSize, chestSize, forearmSize, thighSize);
    }
})

function drawLineChart(date, armSize, calfSize, chestSize, forearmSize, thighSize) {
    var myChart = Highcharts.chart('body', {
        chart: {
            type: 'line',
            width: 800
        },
        title: {
            text: 'Pozostałe parametry ciała na przestrzeni czasu'
        },
        xAxis: {
            categories: date
        },
        yAxis: {
            title: {
                text: 'Rozmiar[Cm]'
            }
        },
        series: [{
            name: 'Obwód ramienia',
            data: armSize
        }, {
            name: 'Obwód łydki',
            data: calfSize
        }, {
            name: 'Obwód klatki piersiowej',
            data: chestSize
        }, {
            name: 'Obwód przedramienia',
            data: forearmSize
        }, {
            name: 'Obwód uda',
            data: thighSize
        }]
    });
}