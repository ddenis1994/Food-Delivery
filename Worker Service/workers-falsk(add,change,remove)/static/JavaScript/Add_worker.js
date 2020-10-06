const id = document.getElementById("ID");
const name = document.getElementById("name");
const tel = document.getElementById("tel");
const crf = document.getElementById("crf");
let Worning_ID=false;
let Worning_Name=false;
let Worning_Tel=false;

function  add(){

    if(worning_tel ===false && worning_name===false && worning_id=== false ){

    var msg_bar = document.getElementById("snackbar");
    var data = {
        'ID':ID.value,
        'name': name.value,
        'tel': tel.value,
        'action': "add"
    };



    fetch(`${window.origin}/workers/save`, {
      method: "POST",
      credentials: "include",
      body: JSON.stringify(data),
      cache: "no-cache",
      headers: new Headers({
        "content-type": "application/json"
      })
    })
      .then(function (response) {
        if (response.status !== 200) {
            msg_bar.innerHTML=`Looks like there was a problem.`;
            msg_bar.className = "show";
            setTimeout(function(){ msg_bar.className = msg_bar.className.replace("show", ""); }, 3000);
          return;
        }
        response.json().then(function (data) {
            msg_bar.innerHTML=data.msg;
            msg_bar.className = "show";
            setTimeout(function(){ msg_bar.className = msg_bar.className.replace("show", ""); }, 3000);
        });
      })
      .catch(function (error) {
          msg_bar.innerHTML="Fetch error: " + error;
          msg_bar.className = "show";
          setTimeout(function(){ msg_bar.className = msg_bar.className.replace("show", ""); }, 3000);
      });

  }


}

function worning_id() {
    if (id.value === '') {
        document.getElementById("ID_worning").disable = true;
        document.getElementById("ID_worning").innerHTML = "you miss enter id";
        Worning_ID = true;
    } else {
        Worning_ID = false
        document.getElementById("ID_worning").disable = false;
        document.getElementById("ID_worning").innerHTML ='';
    }
}

function worning_name() {
    if (name.value === '') {
        document.getElementById("name_worning").disable = true;
        document.getElementById("name_worning").innerHTML = "you miss enter id";
        Worning_Name = true;
    }
    {
        Worning_Name = false
        document.getElementById("name_worning").disable = false;
        document.getElementById("name_worning").innerHTML ='';
    }
}
function worning_tel() {
    if (tel.value === ''){
        document.getElementById("tel_worning").disable=true;
        document.getElementById("tel_worning").innerHTML="you miss enter id";
        Worning_Tel=true;
    }
    {
        Worning_Tel=false
        document.getElementById("tel_worning").disable = false;
        document.getElementById("tel_worning").innerHTML ='';
    }
}
