
import * as thongTinRap from './thongTinRapChieu.js'
start1();
async function rap(callback){
    var api = '/api/rap';
    await fetch(api)
        .then(response => response.json())
        .then(callback)
}
function renderRap(data){
    var cinemas = document.getElementById('cinemas')
    let select = true
    var html = data.map(e => {
        if(select){
            select = false
            return `
            <option idrap="${e.idRap}" class="first-cinema" value="${e.tenRap}">${e.tenRap}</option>`
        }
        else{
            return `
        <option idrap="${e.idRap}" value="${e.tenRap}">${e.tenRap}</option>`
        }
    })
    cinemas.innerHTML = html.join(' ')
}
async function start1(){
    await rap(renderRap)
    var cinemas = document.getElementById('cinemas')

    let firstCinema = cinemas.options[cinemas.selectedIndex].getAttribute('idrap');
    // cinemas.addEventListener("change", function (){
    //     console.log(cinemas.value)
    // })
    changeCinema(cinemas)
}

function changeCinema(cinemas){
    let firstCinema = cinemas.options[cinemas.selectedIndex].getAttribute('idrap');
    if(!sessionStorage.getItem("idRap")){
        sessionStorage.setItem("idRap", firstCinema)
    }
    cinemas.addEventListener("change", function(){
        firstCinema = cinemas.options[cinemas.selectedIndex].getAttribute('idrap')
        sessionStorage.setItem('idRap', firstCinema)
        // cinemas.options[cinemas.selectedIndex].setAttribute("selected","selected")
        console.log(firstCinema)
        thongTinRap.getRapChieu(thongTinRap.renderRapChieu);
    })

    cinemas.options[sessionStorage.getItem('idRap') - 1].setAttribute("selected", "selected")
}





