using Loja.Dominio;
using Loja.Dominio.Exceptions.Usuario;
using Loja.Tests.Mocks;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Tests
{
    [TestClass]
    public class UsuarioServicoTest
    {
        [TestMethod]
        public void DeveAutenticarComSucesso()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            Usuario usuario = usuarioServico.BuscarPorAutenticacao(
                "goku@bol.com", "abc123");

            Assert.IsNotNull(usuario);
        }

        [TestMethod]
        public void DeveCriarUsuario()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            usuarioServico.Salvar(new Usuario("bla@oque.com", "abc123"));
            Assert.IsNotNull(usuarioServico.BuscarPorAutenticacao("bla@oque.com", "abc123"));
        }

        [TestMethod]
        [ExpectedException(typeof(EmailJaExistenteException))]
        public void DeveLancarEmailJaExistenteException()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            usuarioServico.Salvar(new Usuario("goku@bol.com", "abc123"));
        }

        [TestMethod]
        [ExpectedException(typeof(EmailMenorOuIgualACincoCaracteresException))]
        public void DeveLancarEmailMenorOuIgualACincoCaracteresException()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            usuarioServico.Salvar(new Usuario("g@ahd", "abc123"));
        }

        [TestMethod]
        [ExpectedException(typeof(NaoContemArrobaException))]
        public void DeveLancarNaoContemArrobaException()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            usuarioServico.Salvar(new Usuario("gokubol.com", "abc123"));
        }

        [TestMethod]
        public void DeveEditarUsuario()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            Usuario usuario = new Usuario(1, "vegeta@bol.com", "abc123");

            usuarioServico.Salvar(usuario);

            Assert.AreEqual(
                usuario,
                usuarioServico.BuscarPorAutenticacao("vegeta@bol.com", "abc123"));
        }

        [TestMethod]
        public void DeveExcluirUsuario()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            Usuario usuario = new Usuario(1, "goku@bol.com", "abc123");

            usuarioServico.Excluir(usuario);

            Assert.IsNull(usuarioServico.BuscarPorAutenticacao(usuario.Email, usuario.Senha));
        }

        [TestMethod]
        public void BuscarPorAutenticacaoDeveRetornarNullSeForComStringVazia()
        {
            var usuarioServico = new UsuarioServico(
                new UsuarioRepositorioMock(),
                new ServicoDeCriptografiaMock());

            Assert.IsNull(usuarioServico.BuscarPorAutenticacao("", ""));
        }
    }
}
