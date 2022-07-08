async function start(){
    await getAllDetailCinema(rederDetailCinema);
    gioChieuPhim();

}



const url = window.location.search;
const urlParams = new URLSearchParams(url);
sessionStorage.setItem("movieID", urlParams.get("mid"))
const movieID = sessionStorage.getItem("movieID")
start();
async function getAllDetailCinema(callback){
    let api = "/api/phim/" + movieID
    await fetch(api)
        .then( await function(response){
            return response.json();
        })
        .then(callback)
}


function rederDetailCinema(detailCinema){

    let detail = document.querySelector(".detail-cinema");
    let htmls = `
                <div style="display: flex; width: 100%;">
                    <div class="image-cinema">
                        <img src="static/img/${detailCinema.anhPhim}" src="">
</div>
                    <div class="title-cinema">
                        <h2>${detailCinema.tenPhim}</h2>
                        <p><span>Mô tả: </span>${detailCinema.moTa}</p>
                        <p><span>Thời gian: </span>${detailCinema.thoiLuong} phút</p>
                        <p><span>Quốc gia: </span>${detailCinema.quocGia}</p>
                        <p><span>Thể loại: </span>${detailCinema.loaiPhim}</p>
                        <button class="muaVe"><i class="fa-solid fa-ticket muaVe"></i> MUA VÉ</button>
                    </div>
                </div>
                
            `


    detail.innerHTML = htmls;
}

// hàm lấy ngày theo chuẩn
function layNgayTheoChuan(){
    let arr = new Array();
    const today = new Date()
    const yesterday = new Date(today)
    let nam = today.getFullYear();
    let ngay = today.getDate();
    let thang = today.getMonth() + 1;
    if(thang < 10){
        thang = "0" + thang
    }
    let result = nam + "-" +thang + "-"+ngay;
    console.log(yesterday.toDateString());
    arr.push(result)
    for(var i = 1; i <= 5; i++){
        yesterday.setDate(yesterday.getDate() + 1);
        let ngay2 = yesterday.getDate();
        let thang2 = yesterday.getMonth() + 1;
        if(thang2 < 10){
            thang2 = "0" + thang2
        }
        let nam2 = yesterday.getFullYear();
        result = nam2 + "-" +thang2 + "-"+ngay2;
        arr.push(result)
    }
    // console.log(arr);
    return arr;
}
// hàm lấy ngày hôm nay
function LayNgay(){
    let arr = new Array();
    const today = new Date()
    const yesterday = new Date(today)
    let ngay = today.getDate();
    let thang = today.getMonth() + 1;
    if(thang < 10){
        thang = "0" + thang
    }
    let thu;
    var current_day = today.getDay();
    switch (current_day) {
        case 0:
            thu = "CN";
            break;
        case 1:
            thu = "T2";
            break;
        case 2:
            thu = "T3";
            break;
        case 3:
            thu = "T4";
            break;
        case 4:
            thu = "T5";
            break;
        case 5:
            thu = "T6";
            break;
        case 6:
            thu = "T7";
    }
    let result = ngay + "/" + thang + "-" + thu;
    console.log(yesterday.toDateString());
    arr.push(result)
    for(var i = 1; i <= 5; i++){
        yesterday.setDate(yesterday.getDate() + 1);
        let ngay2 = yesterday.getDate();
        let thang2 = yesterday.getMonth() + 1;
        if(thang2 < 10){
            thang2 = "0" + thang2
        }
        let thu2;
        var current_day2 = yesterday.getDay();
        switch (current_day2) {
            case 0:
                thu2 = "CN";
                break;
            case 1:
                thu2 = "T2";
                break;
            case 2:
                thu2 = "T3";
                break;
            case 3:
                thu2 = "T4";
                break;
            case 4:
                thu2 = "T5";
                break;
            case 5:
                thu2 = "T6";
                break;
            case 6:
                thu2 = "T7";
        }
        result = ngay2 + "/" + thang2 + "-" + thu2;
        arr.push(result)
    }
    // console.log(arr);
    return arr;
}

function chuanHoaNgay(){
    let arr = new Array();
    let today = new Date().toLocaleDateString('en-us', {  year:"numeric",day:"numeric", month:"short"}) // "Jul 2021 Friday"
    arr.push(today);
    const yesterday = new Date(today)
    for(var  i = 1; i <= 5; i++){
        yesterday.setDate(yesterday.getDate() + 1);
        // console.log(yesterday.toLocaleDateString('en-us', {  year:"numeric",day:"numeric", month:"short"}));
        arr.push(yesterday.toLocaleDateString('en-us', {  year:"numeric",day:"numeric", month:"short"}))
    }
    return arr;
}

function gioChieuPhim(){
    function moLichChieu(){
        renderNgayThang();
        let muaVe = document.querySelector(".muaVe")
        console.log(muaVe)
            muaVe.addEventListener("click",function(){
                document.querySelector(".ten-phim").innerHTML = `
                <h1>LỊCH CHIẾU - ${sessionStorage.getItem("tenPhim")}</h1>
                `
                // document.querySelector(".ten-phim").innerHTML = `
                // <h1>LỊCH CHIẾU - ${ve.getAttribute("tenPhim")}<h1>
                // `
                console.log("hung day: ", muaVe.getAttribute("value"));
                sessionStorage.setItem("IDPhim",muaVe.getAttribute("value"))
                // sessionStorage.setItem("tenPhim",ve.getAttribute("tenPhim"))
                console.log("bam vo day");
                document.querySelector(".bang-chon-gio").style.display = "block";
                document.querySelector(".lop-phu").style.display = "block";
            })
        document.querySelector(".lop-phu").addEventListener("click",function(){
            document.querySelector(".bang-chon-gio").style.display = "none";
            document.querySelector(".lop-phu").style.display = "none";
        })
    }
    async function loadLanDau(){
        console.log("da load vao")
        let arrChuanHoa = chuanHoaNgay();
        let arrNgayChuan = layNgayTheoChuan();
        type = arrChuanHoa[0] // bằng ngày đầu tiên
        var IDPhimSuatChieu = sessionStorage.getItem("movieID");
        await getAllPhimNgayChieu(renderSuatChieu,IDPhimSuatChieu,arrNgayChuan[0]);
        handleClickbtnSuatChieu();
        var gioChieu = document.querySelectorAll('.gio-chieu')
        console.log(gioChieu);
        gioChieu.forEach((item) => {
            // console.log("my check: ",type, item.getAttribute("type-gio-chieu"));
            if (type == item.getAttribute("type-gio-chieu"))
                item.classList.remove('hide')
            else item.classList.add('hide')
        })
    }
    function dongLichChieu(){
        document.querySelector(".closebtn").addEventListener("click",function(){
            console.log("aaaaaa");
            document.querySelector(".bang-chon-gio").style.display = "none";
            document.querySelector(".lop-phu").style.display = "none";
        })
    }
    // const gioChieu = document.querySelectorAll('.gio-chieu')
    // console.log(gioChieu);
    let type = "";
    moLichChieu();
    const gioChieuBtn = document.querySelectorAll('.gio-chieu-menu button')
    dongLichChieu();
    let muaVePhim = document.querySelectorAll(".muaVe");
    muaVePhim.forEach(e=>{
        e.addEventListener("click", function(){
            console.log("da load lai roi nhe");
            document
                .querySelector('.gio-chieu-menu button.active-gio-chieu')
                .classList.remove('active-gio-chieu')
            document
                .querySelector('.ngay-dau')
                .classList.add('active-gio-chieu')
            loadLanDau();
        })
    })

    // let muaVe = document.querySelectorAll('.muaVe')


    console.log(gioChieuBtn);
    gioChieuBtn.forEach((btn) => {
        btn.addEventListener('click',async (e) => {
            // console.log("hung check: ",sessionStorage.getItem("IDPhim"), btn.innerHTML);
            var IDPhimSuatChieu = sessionStorage.getItem("movieID");
            var ngaySuatChieu = btn.getAttribute("value");
            await getAllPhimNgayChieu(renderSuatChieu,IDPhimSuatChieu,ngaySuatChieu);
            handleClickbtnSuatChieu();
            var gioChieu = document.querySelectorAll('.gio-chieu')
            type = e.target.getAttribute('type-gio-chieu')
            console.log(type);
            // remove and set active fpr button
            document
                .querySelector('.gio-chieu-menu button.active-gio-chieu')
                .classList.remove('active-gio-chieu')
            e.target.classList.add('active-gio-chieu')

            // filter elements
            console.log(gioChieu);
            gioChieu.forEach((item) => {
                console.log(type);
                console.log("my check: ",type, item.getAttribute("type-gio-chieu"));
                if (item.getAttribute('type-gio-chieu') == type)
                    item.classList.remove('hide')
                else item.classList.add('hide')
            })
        })
    })
}
// hiển thị ra các suất chiếu theo ngày
function renderSuatChieu(suatchieus){
    let listSuatChieu = document.querySelector(".gio-chieu-list");
    if(!suatchieus){
        console.log("xu ly loi");
        document.querySelector(".gio-chieu-list").innerHTML = "";
    }
    else{
        let htmls = suatchieus.map( function(suatchieu){
            return `
            <a class="btnSuatChieu" href = "mua-ve" style = " color: #000000; text-decoration: none;">
             <div class="gio-chieu hide" type-gio-chieu = "${suatchieu.ngayChieu}" idSuatChieu = "${suatchieu.idSuatChieu}">${suatchieu.thoiGianBD}
             </div>
             </a>
        `
        })
        listSuatChieu.innerHTML = htmls.join('')
    }
}
function renderNgayThang(){
    let listNgay  = document.querySelector(".gio-chieu-menu");
    let arrNgay = LayNgay();
    let arrNgayChuan = layNgayTheoChuan();
    let arrChuanHoaNgay = chuanHoaNgay();
    listNgay.innerHTML = `
        <div  class="closebtn">&times;</div>
        <button class="active-gio-chieu ngay-dau" type-gio-chieu="${arrChuanHoaNgay[0]}" value = ${arrNgayChuan[0]}>${arrNgay[0]}</button>
        <button type-gio-chieu="${arrChuanHoaNgay[1]}" value = ${arrNgayChuan[1]}>${arrNgay[1]}</button>
        <button type-gio-chieu="${arrChuanHoaNgay[2]}" value = ${arrNgayChuan[2]}>${arrNgay[2]}</button>
        <button type-gio-chieu="${arrChuanHoaNgay[3]}" value = ${arrNgayChuan[3]}>${arrNgay[3]}</button>
        <button type-gio-chieu="${arrChuanHoaNgay[4]}" value = ${arrNgayChuan[4]}>${arrNgay[4]}</button>
        <button type-gio-chieu="${arrChuanHoaNgay[5]}" value = ${arrNgayChuan[5]}>${arrNgay[5]}</button>
    `
}
function handleClickbtnSuatChieu(){
    var btnSuatChieu = document.querySelectorAll('.btnSuatChieu');
    btnSuatChieu.forEach(e => {
        e.addEventListener('click', function (){
            sessionStorage.setItem("idSuatChieu", e.querySelector('.gio-chieu').getAttribute('idSuatChieu'))
        })
    })
}

// hàm gọi api ngày chiếu theo phim
async function getAllPhimNgayChieu(callback,phim,ngay){
    let api = `/api/suat-chieu?phim=${phim}&ngay=${ngay}`;
    await fetch(api)
        .then(await function (reponse){
            return reponse.json();
        })
        .then(callback)
        .catch((error) => {
            console.error('Error:', error);
        });
}
