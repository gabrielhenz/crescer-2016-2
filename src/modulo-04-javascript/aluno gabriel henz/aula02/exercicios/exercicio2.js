Herois.prototype.foraDaGuerraCivil = function(marvel){
  var personagens = [];
  var participou = false;
  for(var i = 0, lenI = marvel.length; i < lenI; i++){
    var items = marvel[i]['events']['items'];
    for(var j = 0, lenJ = items.length; j < lenJ; j++){
      if(items[j]['name'] === 'Civil War'){
        participou = true;
      }
    }
    if(!participou){
      // var personagem = marvel[i]['characters']['items'];
      // for(var x = 0, lenX = personagem.length; x < lenX; x++){
      // personagens.push(personagem[i]);
      // }
      personagens.push(marvel[i]);
    }
  }
  return personagens;
}
