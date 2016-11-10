using Loja.Dominio;
using Loja.Dominio.Exceptions.Usuario;
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
    public class UsuarioController : Controller
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
                ServicoDeAutenticacao.Autenticar(new UsuarioLogadoModel(usuarioAutenticado.Id, usuarioAutenticado.Email));
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

        public ActionResult Sair()
        {
            ServicoDeAutenticacao.Sair();
            return View("Index");
        }

        public ActionResult Cadastrar(int id = 0)
        {
            if (id == 0)
                return View("Cadastro", null);
            else
            {
                UsuarioServico usuarioServico = new UsuarioServico(new UsuarioRepositorio(), new ServicoDeCriptografia());
                Usuario usuario = usuarioServico.BuscarPorId(id);
                UsuarioModel model = usuario.ConverterParaModel();
                return View("Cadastro", model);
            }
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(UsuarioModel model, int Id = 0)
        {
            try
            {
                UsuarioServico usuarioServico = new UsuarioServico(
                new UsuarioRepositorio(), new ServicoDeCriptografia());

                Usuario usuario = new Usuario(Id, model.Email, model.Senha);

                usuarioServico.Salvar(usuario);
            }
            catch(EmailJaExistenteException ex)
            {
                ModelState.AddModelError("", ex.Message);
            }
            catch (EmailMenorOuIgualACincoCaracteresException ex)
            {
                ModelState.AddModelError("", ex.Message);
            }
            catch (NaoContemArrobaException ex)
            {
                ModelState.AddModelError("", ex.Message);
            }

            if (Id == 0)
                ViewBag.CadastroOuEditado = "Usuario cadastrado com sucesso! Faça login.";
            else
                ViewBag.CadastroOuEditado = "Usuario editado com sucesso! Faça login novamente.";

            return View("Index");
        }
    }
}