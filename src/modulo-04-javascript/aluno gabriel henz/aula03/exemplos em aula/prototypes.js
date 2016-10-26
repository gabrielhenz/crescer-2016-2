String.prototype.contem = function(subtexto, ignoreCase = false){
  if(ignoreCase){
    return this.toUpperCase().indexOf(subtexto.toUpperCase()) !== -1;
  }
  return 
}
