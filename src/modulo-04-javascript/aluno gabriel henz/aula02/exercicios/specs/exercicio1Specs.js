describe('constructor()', function(){
  it('deve criar um objeto Herois com as informações dos heróis nele.', function(){
    let personagens = [{ name: 'Deadpool' }, { name: 'Iron Man' }];
    let resultado = new Herois(personagens);
    expect(resultado.herois).toEqual(personagens);
  });
});
