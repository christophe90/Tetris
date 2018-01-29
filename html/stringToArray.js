
function stringToArray(myStr) {

  var tab = new Array();

  var ligne = myStr.split("/");

  for (var i=0; i<ligne.length; i++)
    tab[i] = ligne[i].split(",");

  return tab;
}

tab = stringToArray("1,1,1/1,0,0/1,0,0");

console.log(tab);
