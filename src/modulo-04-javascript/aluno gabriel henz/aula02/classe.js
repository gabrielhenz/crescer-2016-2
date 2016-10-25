function Elfo(nome, flechas){
  this.nome = nome;
  this.flechas = flechas || 42;
  this.atirarFlecha = function(){
    this.flechas--;
  }
}

var legolas = new Elfo('legolas', 42);
var elrond = new Elfo('elrond', 1231452431);
legolas.atirarFlecha();
elrond.atirarFlecha();

//false
console.log(legolas.atirarFlecha == elrond.atirarFlecha);

//false
console.log(legolas.atirarFlecha == elrond.atirarFlecha);


// se tu quer criar um get e um set tu precisa colocar underline depois do 'this'
class ClasseElfo{
  // parametro default
  constructior(nome, flechas = 42){
    this._nome = nome;
    this.flechas = flechas;
  }
  static alturaMaximaElfos() {
    return 4.5;
  }

  atirarFlecha(){
    this.flechas--;
  }
  get nome(){
    return this._nome.toUpperCase();
  }
  set nome(valor){
    this._nome = valor;
  }
}
