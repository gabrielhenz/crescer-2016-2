using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaDeItens.Web.Validacoes
{
    public class MetodosDeValidacoes
    {
        public static ValidationResult ValidarMaiorOuIgualAZero(decimal valor, ValidationContext context)
        {
            bool ehValido = true;

            if (valor < decimal.Zero)
            {
                ehValido = false;
            }

            if (ehValido)
            {
                return ValidationResult.Success;
            }
            else
            {
                return new ValidationResult(
                    $"O campo {context.MemberName} precisa ser maior ou igual a zero.",
                    new List<string>() { context.MemberName });
            }
        }
    }
}