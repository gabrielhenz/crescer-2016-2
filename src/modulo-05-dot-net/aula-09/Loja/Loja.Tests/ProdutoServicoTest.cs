using Loja.Dominio;
using Loja.Dominio.Exceptions;
using Loja.Dominio.Exceptions.Produto;
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
    public class ProdutoServicoTest
    {
        [TestMethod]
        public void DeveListarOsProdutos()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Assert.IsNotNull(produtoServico.ListarProdutos());
        }

        [TestMethod]
        public void DeveCadastrarUmProduto()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto("Banana", 1000.10m);

            produtoServico.Salvar(produto);

            Assert.IsTrue(produtoServico.ListarProdutos().Count == 2);
        }

        [TestMethod]
        [ExpectedException(typeof(MaisQueDuasCasasDecimaisException))]
        public void DeveLancarMaisQueDuasCasasDecimaisException()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto("Banana", 1000.12131230m);

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(NomeProdutoIgualException))]
        public void DeveLancarNomeProdutoIgualException()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto(
                "Livro - Harry Potter e a Criança Amaldiçoada (Livro 8) - Capa Dura", 
                1000.30m);

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(NomeProdutoMenorQueDoisCaracteresException))]
        public void DeveLancarNomeProdutoMenorQueDoisCaracteresException()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto("L", 1000.30m);

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        [ExpectedException(typeof(ValorProdutoIgualAZeroException))]
        public void DeveLancarValorProdutoIgualAZeroException()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto("Livro Muito Louco", 0m);

            produtoServico.Salvar(produto);
        }

        [TestMethod]
        public void DeveEditarOProduto()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto(1, "Livro com nome menor", 10.00m);

            produtoServico.Salvar(produto);

            Assert.AreEqual(produto, produtoServico.ListarProdutos().First());
        }

        [TestMethod]
        public void DeveExcluirUmProduto()
        {
            var produtoServico = new ProdutoServico(new ProdutoRepositorioMock());

            Produto produto = new Produto(1, "Livro A Ser excluido", 10.00m);

            produtoServico.Excluir(produto.Id);

            Assert.IsTrue(produtoServico.ListarProdutos().Count == 0);
        }
    }
}
