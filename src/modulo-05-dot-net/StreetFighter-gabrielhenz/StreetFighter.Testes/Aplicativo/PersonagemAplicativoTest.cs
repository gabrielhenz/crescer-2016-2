using FakeItEasy;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Repositorio;

namespace StreetFighter.Testes.Aplicativo
{
    [TestClass]
    public class PersonagemAplicativoTest
    {
        [TestMethod]
        public void SalvarPersonagemComId0DeveIncluir()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = A.Fake<Personagem>();

            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.IncluirPersonagem(personagem))
                .MustHaveHappened();
        }

        [TestMethod]
        public void SalvarPersonagemComId1DeveEditar()
        {
            var repositorioFake = A.Fake<IPersonagemRepositorio>();

            var aplicativo = new PersonagemAplicativo(repositorioFake);
            var personagem = new Personagem(1, "", "", new System.DateTime(), 0, 0, "", "", false);
            aplicativo.Salvar(personagem);

            A.CallTo(() => repositorioFake.EditarPersonagem(personagem))
                .MustHaveHappened();
        }
    }
}
