

document.getElementById("BFind").onclick = function() {
    var string = "ID=" + document.getElementById("ID").value + "&myHash=" + document.getElementById("crf").value
    var xhttp = new XMLHttpRequest();
    xhttp.open("post", '/findWorker', true);
    xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhttp.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {
            json = JSON.parse(this.responseText);
            table = "<h1>Worker info</h1><table id='mytable'>";
            if (json) {
                for (var key of Object.keys(json)) {
                    table += "<tr><td>" + key + "</td><td><input type='text' value='" + json[key] + "'></td></tr>"
                }
                table += "</table><br/><input type='button' value='change worker' id='save' >";
                document.getElementById("worker").innerHTML = table;
                document.getElementById("save").onclick = save;
            } else {
                var msg_bar = document.getElementById("snackbar");
                msg_bar.innerHTML = "Sorry,Worker not found";
                msg_bar.className = "show";
                setTimeout(function () {
                    msg_bar.className = msg_bar.className.replace("show", "");
                }, 3000);
            }
        } else {
            var msg_bar = document.getElementById("snackbar");
            msg_bar.innerHTML = "Looks like there was a problem."+this.responseText.toString();
            msg_bar.className = "show";
            setTimeout(function () {
                msg_bar.className = msg_bar.className.replace("show", "");
            }, 3000);
        }
    }
    xhttp.send(string.toString());
}


function save() {

    var msg_bar = document.getElementById("snackbar");
    var table = document.getElementById("mytable");
    var data = {
        'myHash': document.getElementById("crf").value
    };
    for (var i = 0, row; row = table.rows[i]; i++) {
        var key=row.cells[0].innerHTML;
        var val1= row.cells[1].querySelector('input').value;
            data[key]=val1;
    }




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