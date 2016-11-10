using Loja.Dominio;
using Loja.Dominio.Exceptions;
using Loja.Dominio.Exceptions.Produto;
using Loja.Repositorio;
using Loja.Web.Filters;
using Loja.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    [UsuarioAutorizador]
    public class ProdutoController : Controller
    {
        // GET: Produto
        public ActionResult Index()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorio());
            ListaDeProdutosModel listaDeProdutosModel = produtoServico.ListarProdutos().ConverterParaModel();
            if (listaDeProdutosModel.ProdutosModel.Count <= 0)
                ViewBag.ListaVazia = "Não existe nenhum produto cadastrado";
            return View(listaDeProdutosModel);
        }

        public ActionResult Cadastro(int id = 0)
        {
            ViewBag.Id = id;
            ViewBag.CadastroOuEdicao = (id == 0) ? "Cadastro" : "Edição";
            if (id == 0)
                return View();
            else
            {
                ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorio());
                ProdutoModel model = produtoServico.BuscarPorId(id).ConverterParaModel();
                return View(model);
            }
        }

        public ActionResult Salvar(ProdutoModel model, int Id = 0)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorio());
                    var produto = new Produto(Id, model.Nome, model.Valor);
                    produtoServico.Salvar(produto);
                }
                catch(NomeProdutoIgualException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                catch(NomeProdutoMenorQueDoisCaracteresException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                catch(MaisQueDuasCasasDecimaisException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                catch (ValorProdutoIgualAZeroException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
            }
            if (Id == 0)
                TempData["EditadoOuCadastradoOuExcluido"] = "Personagem cadastrado com sucesso!";
            else
                TempData["EditadoOuCadastradoOuExcluido"] = "Personagem editado com sucesso!";
            return RedirectToAction("Index");
        }

        public ActionResult Editar(int id)
        {
            return RedirectToAction("Cadastro", new { Id = id });
        }

        public ActionResult Excluir(int id)
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorio());
            produtoServico.Excluir(id);
            TempData["EditadoOuCadastradoOuExcluido"] = "Personagem excluído com sucesso!";
            return RedirectToAction("Index");
        }
    }
}