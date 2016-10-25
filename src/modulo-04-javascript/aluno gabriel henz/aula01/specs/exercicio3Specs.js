describe('find()', function(){
  it('deve encontrar elementos maiores ou iguais a 2', function(){
    //buscar dentro de um elementro desde que ele seja maior que 2.
    // =>  arrow function
    let resultado = find([ 1, 2, 3], elemento => elemento >= 2);
    expect(resultado).toEqual([ 2, 3]);
  });

  it('deve encontrar elementos que são do tipo function', function(){
    //buscar dentro de um elementro desde que ele seja maior que 2.
    // =>  arrow function
    let resultado = find([ 'a', 5, null, false, 'false' ], elemento => typeof elemento === 'string');
    expect(resultado).toEqual([ 'a', 'false']);
  });

  it('deve encontrar elementos que são do tipo string', function(){
    //buscar dentro de um elementro desde que ele seja maior que 2.
    // =>  arrow function
    let resultado = find([ 'a', 5, null, false, 'false' ], elemento => typeof elemento === 'string');
    expect(resultado).toEqual([ 'a', 'false']);
  });

  it('deve encontrar nenhum elemento', function() {
    let resultado = find([ { nome: 'a' }, { nome: 'b' }  ], elem => typeof elem.nome === 'c');
    expect(resultado).toEqual([]);
  });

  it('deve retornar array vazio caso segundo parâmetro não seja função', function() {
    let resultado = find([ { nome: 'a' }, { nome: 'b' }  ], {});
    expect(resultado).toEqual([]);
  });
}
