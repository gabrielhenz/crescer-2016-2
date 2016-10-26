var arr = [ 1, 2, 3, 'batata', false];
arr.qualquerCoisa = 'nao imprime isso';

function imprime(){
  console.log(this)
}

arr.forEach(imprime);

var arr = [ {nome: 'A', idade: 4}, {nome: 'B'}, {nome: 'A', idade: 6}];
arr.filter(elem => elem.nome === 'A');

arr = [ 1, 2, 3].reduce(function(ac, elem) { return ac + elem});
arr = [ 1, 2, 3].reduce( (ac, elem) => ac + elem});

arr.map( heroi => heroi.comics.available);

//map reduce
dedosHerois.map( heroi => heroi.comics.available).reduce( (ac, qtd) => ac + qtd);

arr.sort( (elem1, elem2) => elem1.qtd - elem2.qtd);
