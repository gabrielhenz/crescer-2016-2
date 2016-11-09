using Loja.Dominio;
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
    public class ProdutoController : Controller
    {
        // GET: Produto
        [UsuarioAutorizador]
        public ActionResult Index()
        {
            ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorio());
            ListaDeProdutosModel listaDeProdutosModel = produtoServico.ListarProdutos().ConverterParaModel();
            return View(listaDeProdutosModel);
        }

        public ActionResult Cadastro(int Id = 0)
        {
            ViewBag.Id = Id;
            ViewBag.CadastroOuEdicao = (Id == 0) ? "Cadastro" : "Edição";
            return View();
        }

        public ActionResult Salvar(int Id, ProdutoModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    ProdutoServico produtoServico = new ProdutoServico(new ProdutoRepositorio());
                    var produto = new Produto(Id, model.Nome, model.Valor);
                    produtoServico.Salvar(produto);
                }
                catch(NomeIgualException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
                catch(NomeMenorQueDoisCaracteresException ex)
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

        public ActionResult Editar(int Id)
        {
            return RedirectToAction("Cadastro", new { Id = Id });
        }

        [UsuarioAutorizador]
        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        [UsuarioAutorizador]
        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}