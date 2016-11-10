using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class UsuarioModel
    {

        public int? Id { get; set; }

        [Required]
        [DataType(DataType.EmailAddress)]
        [EmailAddress(ErrorMessage = "O endereço de email não é válido.")]
        public string Email { get; set; }

        [Required]
        [StringLength(30, MinimumLength = 6, ErrorMessage = "A senha deve conter no minimo 6 e no máximo 30 caracteres.")]
        public string Senha { get; set; }
    }

    public static class UsuarioModelExtensions
    {
        public static UsuarioModel ConverterParaModel(this Usuario usuario)
        {
            return new UsuarioModel()
            {
                Id = usuario.Id,
                Email = usuario.Email,
                Senha = usuario.Senha
            };
        }
    }
}