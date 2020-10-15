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


window.onload=function () {
    document.readyState
    var fTr, fTd, fInput, fTdList;
    fTr = document.getElementById("filtrTR");
    fTdList = fTr.getElementsByTagName("td");
    for (i = 0; i < fTdList.length; i++) {
        fTd = fTdList[i];
        fInput = fTd.querySelector('input');
        fInput.onkeyup = function () {
            var input, filter, table, tr, td, i, txtValue;
            filter = fInput.value.toUpperCase();
            table = document.getElementById("workersTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[fTd.getAttribute("name") - 1];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    }
}