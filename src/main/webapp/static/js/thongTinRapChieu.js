start();
async function start(){
    await getRapChieu(renderRapChieu)

}
async function getRapChieu(callback){
    let api = '/api/rap/' + sessionStorage.getItem('idRap');
    await fetch(api)
        .then(response => response.json())
        .then(callback)
}
function renderRapChieu(data){
    const infoCinema = document.querySelector('.info_cinema')
    const html = `<span style="font-family: 'Permanent Marker', cursive;">${data.tenRap}</span>
        <img src="https://files.betacorp.vn/files/ecm/2018/07/04/35359362-242694916502971-7052850785574453248-n-103924-040718-45.png" alt="">
        <p>
            ${data.thongTin}
        </p>`;
    console.log(html, infoCinema);
    infoCinema.innerHTML = html;
}
export {getRapChieu, renderRapChieu}
