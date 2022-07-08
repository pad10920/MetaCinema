

let idUser = sessionStorage.getItem("idUser")
var api = DIACHI_API + "/lich-su?id-user=" + idUser;

start();
async function start(){
    await getLichSu(renderLichSu)
}
async function getLichSu(callback){
    await fetch(api)
        .then(response => response.json())
        .then(callback)
}
function renderLichSu(datas){
    const listMuaVe = document.querySelector('.danh-sach-ls-mua-ve')
    let index = 1;
    let html = datas.map(function (e){
        return `<div style="display: flex; flex-wrap: wrap;">
    <div class="nav Stt">${index++}</div>
    <div class="nav Phim">${e.tenPhim}</div>
    <div class="nav SoGhe">${e.soGhe}</div>
    <div class="nav GiaTien">${format(e.giaVe)}</div>
    <div class="nav NgayMua">${e.ngayMua}</div>
</div>`
    })
    listMuaVe.innerHTML = html.join(' ');

}
function format(n) {
    n = n + ""
    let s = ""
    let arr = new Array();
    n = n.split('').reverse().join('');
    arr = (n.match(/.{1,3}/g))
    for(let i = arr.length - 1; i >0; --i){
        arr[i] = arr[i].split('').reverse().join('');
        s += arr[i] + "."
    }
    s+= arr[0] + "đ"
    return s;

}
