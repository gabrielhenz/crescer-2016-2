using StreetFighter.Aplicativo;
using StreetFighter.Dominio;
using StreetFighter.Web.Models;
using StreetFighter.Web.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace StreetFighter.Web.Controllers
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
        public ActionResult FazerLogin(string login, string senha)
        {
            Usuario usuarioAutenticado = ServicoDeUsuario.BuscarUsuarioAutenticado(
                    login, senha);

            if (usuarioAutenticado != null)
            {
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(usuarioAutenticado.Nome));
                return RedirectToAction("Index", "StreetFighter");
            }

            return RedirectToAction("Index");
        }
    }
}