const id = document.getElementById("ID");
const name = document.getElementById("name");
const tel = document.getElementById("tel");
const crf = document.getElementById("crf");




function  add(){

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

