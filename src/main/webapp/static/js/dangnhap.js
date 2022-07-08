

function dangNhap(){
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    let api = DIACHI_API+ '/dang-nhap?user-name=' + username +
        '&pass-word=' + password;
    fetch(api)
        .then(response => response.json())
        .then(data => {
            if (data != null){
                sessionStorage.setItem("idUser", data.idUser);
                document.getElementById('frm-dang-nhap').submit();
            }
            else{
                document.getElementById("feedback").hidden = false;
            }
        })

}
