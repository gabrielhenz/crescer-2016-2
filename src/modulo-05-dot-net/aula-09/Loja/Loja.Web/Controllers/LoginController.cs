using Loja.Dominio;
using Loja.Infraestrutura;
using Loja.Repositorio;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(string email, string senha)
        {
            UsuarioServico usuarioServico = ServicoDeDependencias.MontarUsuarioServico();

            Usuario usuarioAutenticado = usuarioServico.BuscarPorAutenticacao(email, senha);

            if (usuarioAutenticado != null)
            {
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(usuarioAutenticado.Email));
                return RedirectToAction("Index", "Produto");
            }
                

            ViewBag.LoginErro = "Usuario e senha incorretos.";
            return View("Index");
        }

        public ActionResult NaoAutorizado()
        {
            ViewBag.NaoAutorizado = "Você não está autorizado para acessar essa página, faça login.";
            return View("Index");
        }
    }
}