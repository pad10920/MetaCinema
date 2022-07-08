const idSuatChieu = sessionStorage.getItem('idSuatChieu')
async function start(){

    await getAllGhe(rederGhe);
    await loadPhim(renderVePhim)
    getID();
}
start();
async function getAllGhe(callback){
    console.log("t");

    let api = DIACHI_API + "/ghe?suat-chieu=" + idSuatChieu;
    await fetch(api)
        .then(async function(response){
            return await response.json();
        })
        .then(callback)

}
function getID(){
    let hung = document.querySelectorAll(".ghe");
    let result = new Array();
    let lstIdGhe = new Array();
    let kq = document.querySelector(".kq");

    function xoa(arr,del){
        for(let i = 0; i < arr.length; i++){
            if(arr[i] == del){

                arr.splice(i,1);
            }
        }
        console.log("aaa",arr);
    }

    hung.forEach((e,index) => {
        e.addEventListener("click",function(){
            console.log( e.getAttribute("value"));
            if(e.getAttribute("value") == "false"){
                e.classList.toggle("dachon")
                if(e.classList.length > 1){
                    console.log("vvvv");
                    result.push(e.getAttribute("xa"));
                    lstIdGhe.push(e.getAttribute("idGhe"));
                    test(lstIdGhe)
                }
                else{
                    console.log("rrrr");
                    xoa(result,e.getAttribute("xa"));
                    xoa(lstIdGhe,e.getAttribute("idGhe"));
                    test(lstIdGhe)
                }
            }
            result.sort();
            console.log("aaaaa",result);

            console.log("bbbb",lstIdGhe);
            // console.log("bbbbb",result[0]);
            let s = "";
            for(let i = 0 ; i < result.length; i++){
                if(result[i]){
                    s += result[i] + ", ";
                }
                // console.log(result[i])
            }

            kq.innerHTML = s;
        })



    });

    muaVe(result, lstIdGhe)
}
// let arr = new Array();
function dataID(data){
    // console.log(data.value);
    IDCheck = data.value;
}
function rederGhe( ghes){
    let listGhe = document.querySelector(".list-ghe");

    let htmls =  ghes.map((ghe) =>{
        // console.log(ghe.trangThai);
        if(ghe.trangThai == true){
            return`
                <div class="ghe ${ghe.trangThai}" idghe="${ghe.idGhe}" value = "${ghe.trangThai}"  xa = "${ghe.gheSo}" style="margin-top: 20px;"><div class="chinh"> ${ghe.gheSo}</div></div>
            `
        }
        return`
            <div class="ghe" value = "${ghe.trangThai}" idghe="${ghe.idGhe}" xa = "${ghe.gheSo}" style="margin-top: 20px;"><div class="chinh"> ${ghe.gheSo}</div></div>
        `
    })
    listGhe.innerHTML = htmls.join('');
}




async function loadPhim(callback){

    let api = DIACHI_API + '/suat-chieu/' + idSuatChieu
    await fetch(api)
        .then(response => response.json())
        .then(callback)
}
function renderVePhim(data){
    const phimMuaVe = document.querySelector('.phim-mua-ve');
    let html = `<div class="row">
      <div class="tieu-de">
        <div class="anh-phim">
            <img src="static/img/${data.phim.anhPhim}" alt="">
        </div>
      </div>
      <div class="du-lieu">
        <h2 style="margin-top: 30px; color: #244C95;">${data.phim.tenPhim}</h2>
        
      </div>
    </div>
    <div class="row" style="margin-top: 30px;">
      <div class="tieu-de" style="text-align: center;">
        <p>Thể loại</p>
      </div>
      <div class="du-lieu">
        <span style="font-weight: bold;">${data.phim.loaiPhim}</span>
      </div>
    </div>
    <div class="row" style="margin-top: 30px;">
      <div class="tieu-de" style="text-align: center;">
        <p>Thời lượng</p>
      </div>
      <div class="du-lieu">
        <span style="font-weight: bold;">${data.phim.thoiLuong} phút</span>
      </div>
    </div>
    <div class="row" style="margin-top: 30px;">
      <div class="tieu-de" style="text-align: center;">
        <p>Rạp chiếu</p>
      </div>
      <div class="du-lieu">
        <span style="font-weight: bold;">${data.phongChieu.rap.tenRap}</span>
      </div>
    </div>
    <div class="row" style="margin-top: 30px;">
      <div class="tieu-de" style="text-align: center;">
        <p>Ngày chiếu</p>
      </div>
      <div class="du-lieu">
        <span style="font-weight: bold;">${data.ngayChieu}</span>
      </div>
    </div>
    <div class="row" style="margin-top: 30px;">
      <div class="tieu-de" style="text-align: center;">
        <p>Giờ chiếu</p>
      </div>
      <div class="du-lieu">
        <span style="font-weight: bold;">${data.thoiGianBD}</span>
      </div>
    </div>
    <div class="row" style="margin-top: 30px;">
      <div class="tieu-de" style="text-align: center;">
        <p>Phòng chiếu</p>
      </div>
      <div class="du-lieu">
        <span style="font-weight: bold;">${data.phongChieu.tenPhong}</span>
      </div>
    </div>
    <div class="row" style="margin-top: 30px;">
      <div class="tieu-de" style="text-align: center;">
        <p>Ghế ngồi</p>
      </div>
      <div class="du-lieu" style="float: left;">
        <span style="font-weight: bold;width: 50px;height: 100px; overflow: scroll;" class="kq" ></span>
      </div>
    </div>`
    console.log(html)
    phimMuaVe.innerHTML = html;
    getDataMuaVeRap(data.ngayChieu, data.thoiGianBD, data.phongChieu.tenPhong)
}
function test(arr){
    var btnMuaVe = document.querySelector('.btn-mua-ve')
    if(arr.length > 0){
        btnMuaVe.style.display = "block";
    }
    else{
        btnMuaVe.style.display = "none";
    }
}

function muaVe(arr1, arr2){
    var btnMuaVe = document.querySelector('.btnMuaVe');
    btnMuaVe.addEventListener('click', function (){
        sessionStorage.setItem('lstGhe', arr1);
        sessionStorage.setItem('lstIdGhe', arr2);

    })
}
function getDataMuaVeRap(ngay, gio, phong) {
    sessionStorage.setItem('ngay', ngay);
    sessionStorage.setItem('gio', gio);
    sessionStorage.setItem('phong', phong)
}