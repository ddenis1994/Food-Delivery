window.onload=function () {
    document.readyState
    var fTr, fTd, fInput, fTdList;
    fTr = document.getElementById("filtrTR");
    fTdList = fTr.getElementsByTagName("td");
    for (i = 0; i < fTdList.length; i++) {
        fTd = fTdList[i];
        fInput = fTd.querySelector('input');
        fInput.onkeyup = function (event) {
            var input, filter, table, tr, td, i, txtValue;
            filter = event.currentTarget.value.toUpperCase();
            table = document.getElementById("workersTableBody");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[event.currentTarget.getAttribute("name") - 1];
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