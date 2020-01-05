var modalReg = document.getElementById('reg');

var modalLog = document.getElementById('log');

window.onclick = function (event) {
    if (event.target === modalReg) {
        modalReg.style.display = "none";
    }
    
    if (event.target === modalLog) {
       modalLog.style.display = "none";
    }     
}
