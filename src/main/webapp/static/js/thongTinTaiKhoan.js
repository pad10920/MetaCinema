
start();
async function start(){
    await getUser(renderUser)

        updateData()
        inputTrong();

        test()
}

async function getUser(callback){
    let api = DIACHI_API  + '/user?id=' + sessionStorage.getItem('idUser');
    await fetch(api)
        .then(response => response.json())
        .then(callback)
}


function checkInput(){
    let input = document.querySelectorAll('input')
    let check = true
    console.log(input)
    input.forEach(e => {
        if(!nullInput(e.value) && check){
            check = false

        }
    })
    return check;

}
function inputTrong(){
    let input = document.querySelectorAll('input')

    input.forEach(e => {
        e.addEventListener("input", function (){
            if(!nullInput(e.value)){
                e.placeholder = "Không được để trống";

            }

        })
    })
}

function arletInput(){
    let input = document.querySelectorAll('input')
    let check = true
    input.forEach(e => {
        if(!nullInput(e.value) & check){
            check = false;
            window.alert( e.name + " không được để trống");

        }
    })
}

function nullInput(input){
    if(input == null || input == ""){
        return false;
    }
    else{
        return true;
    }
}

function renderUser(data){
    const thongTin = document.querySelector('.container')

    var html = `<div class="shadown">
        <div class="thuoc-tinh">
            <span>
                Tên đăng nhập
            </span>
        <input style="cursor: no-drop;" type="text" name="userName" id="userName" value="${data.userName}" disabled="disabled">

    </div>
    
    <div class="thuoc-tinh">
            <span>
                Họ tên
            </span>
        <input type="text" name="Họ tên" id="hoTen" value="${data.hoTen}">

    </div>
    <div class="thuoc-tinh">
            <span>
                Địa chỉ
            </span>
        <input type="text" name="Địa chỉ" id="diaChi" value="${data.diaChi}">

    </div>
    <div class="thuoc-tinh">
            <span>
                Số điện thoại
            </span>
        <input type="text" name="Số điện thoại" id="sdt" value="${data.sdt}">

    </div>
    <div class="thuoc-tinh">
            <span>
                Email
            </span>
        <input type="email" name="Email" id="email" value="${getEmail(data.email)}" style="width: 70%;">
        <span style="display: inline; font-size: 12px;">@gmail.com</span>
    </div>
    
    <a class="doi-mat-khau">Đổi mật khẩu</a>
</div>`;
    thongTin.innerHTML = html;
}

function data(){
    let formData = new FormData();
    formData.append("idUser", sessionStorage.getItem("idUser"));
    formData.append("hoTen", document.getElementById("hoTen").value);
    formData.append("diaChi", document.getElementById("diaChi").value)
    formData.append("sdt", document.getElementById("sdt").value);
    formData.append("email", document.getElementById("email").value + "@gmail.com");
    return formData;
}

function updateData(){


    const btnCapNhat = document.querySelector(".btnCapNhatThongTin");
    btnCapNhat.addEventListener("click", async function (){
        formData = data();
        if(checkInput()){
            await updateUser(formData)
            window.alert("Cập nhật thông tin thành công");
            window.location.reload()
        }
        else{
            arletInput();
        }



        // checkInput()

    })
}

async function updateUser(formData){
    let api = DIACHI_API + "/user";
    await fetch(api, {
        method: 'PUT',
        body: formData
    })
        .then(respone => respone.json())
        .then(data => console.log(data))


}

function getEmail(email){
    arr = email.split("@")
    return arr[0];
}

function test(){
    const dmk = document.querySelector('.doi-mat-khau');
    dmk.addEventListener('click', function (){
        doiMatKhau();
        test1();


    })
}

function test1(){
    const formDmk = document.querySelector('.btnCapNhatMatKhau');
    formDmk.addEventListener('click', function (){
        let input = document.querySelectorAll('input[type=password]')
        let check = true
        input.forEach(e => {
            if(e.value == null || e.value == "" & check){
                window.alert(e.name + " không được để trống");
                check = false;
            }





        })
        checkPassWord()

    })
}
async function checkPassWord(){
    let idUser = sessionStorage.getItem('idUser');
    let password = document.getElementById('matKhauCu').value;
    let newPass = document.getElementById('matKhauMoi').value
    let api = DIACHI_API +  '/user?id=' + idUser + "&mat-khau=" + password;
    let _data;
    let data = await fetch(api)
        .then(response => response.json())
        .then(async data => {
            if(data == 0){
                window.alert("Mật khẩu cũ không chính xác");
            }
            else{
                if(haiPassWord()){
                    await updatePassWord(idUser, newPass);
                    window.alert("Thay đổi mật khẩu thành công")
                    location.reload();

                }
                else{
                    window.alert("Mật khẩu mới chưa trùng khớp");
                }
            }
        })


}
async function updatePassWord(idUser, password){
    let api = DIACHI_API +  '/user/doi-mat-khau';
    let formData = new FormData();
    formData.append("idUser", idUser);
    formData.append("mat-khau", password);
    await fetch(api, {
        method: 'PUT',
        body: formData
    })

}
function haiPassWord(){
    let newPass = document.getElementById('matKhauMoi').value;
    let rePass = document.getElementById('laiMatKhauMoi').value;
    if(newPass.includes(rePass)){
        return true;
    }
    else{

        return false;
    }

}

function doiMatKhau(){
    const thongTin = document.querySelector('.container')
    let html = `<div class="shadown">
                        <div class="thuoc-tinh">
                                <span>
                                    Mật khẩu cũ
                                </span>
                            <input type="password" name="Mật khẩu cũ" id="matKhauCu" placeholder="Không được để trống">
                    
                        </div>
                        <div class="thuoc-tinh">
                                <span>
                                    Mật khẩu mới
                                </span>
                            <input type="password" name="Mật khẩu mới" id="matKhauMoi" placeholder="Không được để trống">
                    
                        </div>
                        <div class="thuoc-tinh">
                                <span>
                                    Nhập lại mật khẩu
                                </span>
                            <input type="password" name="Nhập lại mật khẩu" id="laiMatKhauMoi" placeholder="Không được để trống">
                    
                        </div>
                        <input type="checkbox" onclick="hienMatKhau()" style="margin-left: 20px">  Hiển thị mật khẩu
                </div>`
    thongTin.innerHTML = html
    const btnCapNhat = document.querySelector('.btnCapNhat')
    btnCapNhat.classList.remove('btnCapNhatThongTin');
    btnCapNhat.classList.add('btnCapNhatMatKhau')
}

function hienMatKhau(){
    var x = document.querySelectorAll('input');
    x.forEach(e => {
        if (e.type === "password") {
            e.type = "text";
        } else if(e.type == "text"){
            e.type = "password";
        }
    })
}