/**
 * 
 */

function processSolarM() {
  var url = "http://heuweslap2:8080/api/solaranlage/monatlich" + "?datumVon=" + document.getElementById("datumvon").value + "&datumBis=" + document.getElementById("datumbis").value;
  window.location = url;
  return false;
}

function processSolarU() {
  var url = "http://heuweslap2:8080/api/solaranlage/untertaegig" + "?datum=" + document.getElementById("datum").value;
  window.location = url;
  return false;
}
function onLoadHome() {
  document.getElementById("datumvon").value = "2020-12-01";
  document.getElementById("datumbis").value = "2020-12-18";
  document.getElementById("datum").value = "2020-12-18";
  console.log("init !");
}
function openCategory(evt, catName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(catName).style.display = "block";
  evt.currentTarget.className += " active";
}
