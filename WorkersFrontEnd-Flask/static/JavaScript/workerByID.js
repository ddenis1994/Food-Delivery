function findWorker() {
    var count=0;
    table=document.getElementById("worker").innerHTML
    var xhttp = new XMLHttpRequest();
    xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhttp.onreadystatechange = function () {
        json = this.responseText;
        if (this.readyState == 4 && this.status == 200) {
            table += "<table>";
            for (var key of Object.keys(this.responseText)) {
                table += "<tr><td>${key}</td><td><input type='text' value='${json[key]}'  ></td></tr>"
            }
            table += "</table><input type=\"button\" value=\"change worker\" onclick=\"changeWorker()\" ><div id=\"snackbar\"></div>";
            count++;
        }
        ;


        xhttp.open("post", '/findWorker', true);
        xhttp.send("ID=" + document.getElementById("ID").value + "&myHash=" + document.getElementById("crf ").value);


    }
}


function save(){

    var msg_bar = document.getElementById("snackbar");
    var data = {
        'ID':document.getElementById("ID").value,
        'myHash': document.getElementById("crf").value
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